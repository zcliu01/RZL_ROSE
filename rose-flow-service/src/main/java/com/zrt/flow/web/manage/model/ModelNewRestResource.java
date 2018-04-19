package com.zrt.flow.web.manage.model;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;
 
@RestController
@RequestMapping(value="/model")
public class ModelNewRestResource 
implements ModelDataJsonConstants {
   
  protected static final Logger LOGGER = LoggerFactory.getLogger(ModelNewRestResource.class);
 
  @Autowired
  private RepositoryService repositoryService;
   
  @Autowired
  private ObjectMapper objectMapper;
  
  @Autowired
  private FbBusTemplateMapper fbBusTemplateMapper;

   
  @RequestMapping(value="/new", method = RequestMethod.POST,headers = "Accept=application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public Map<String, Object> addModel( @RequestBody Map<String, Object> map) {
      String url = "";
      Model model = new ModelEntity();
      ResultMap resultMap = new ResultMap();
      Map<String, Object> dataMap=new HashMap<String, Object>();

    try {
    	//获取模版id
      FbBusTemplate  fbBusTemplate=	fbBusTemplateMapper.selectByPrimaryKey((String)map.get("id"));
      String modelId=fbBusTemplate.getModelId();
      if(!"".equals(modelId) && modelId!=null){
    	  dataMap.put("model_id", model.getId());
          resultMap.data(dataMap);
    	  resultMap.success();
    	  return resultMap.map();
      }
      String name=fbBusTemplate.gettName();
      String key=fbBusTemplate.gettCode();
      String description=fbBusTemplate.gettDesc();
      //保存模型
      
      model.setName(name);
      model.setKey(key);
  //    model.setVersion(1);
      ObjectNode modelJson = (ObjectNode) objectMapper.readTree("{}");
      modelJson.put(MODEL_NAME, model.getName());
      modelJson.put(MODEL_DESCRIPTION, description);
      model.setMetaInfo(modelJson.toString());
      repositoryService.saveModel(model);
       
      
      //保存模型资源
      repositoryService.addModelEditorSource(model.getId(), ("{\"resourceId\":\""+model.getId()+"\",\"properties\":{\"process_id\":\""+key+"\",\"name\":\""+name+"\",\"documentation\":\""+description+"\",\"process_author\":\"\",\"process_version\":\"\",\"process_namespace\":\"http://www.activiti.org/processdef\",\"executionlisteners\":\"\",\"eventlisteners\":\"\",\"signaldefinitions\":\"\",\"messagedefinitions\":\"\"},\"stencil\":{\"id\":\"BPMNDiagram\"},\"childShapes\":[],\"bounds\":{\"lowerRight\":{\"x\":1200,\"y\":1050},\"upperLeft\":{\"x\":0,\"y\":0}},\"stencilset\":{\"url\":\"stencilsets/bpmn2.0/bpmn2.0.json\",\"namespace\":\"http://b3mn.org/stencilset/bpmn2.0#\"},\"ssextensions\":[]}").getBytes("utf-8"));
       
      InputStream svgStream = new ByteArrayInputStream("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:oryx=\"http://oryx-editor.org\"  width=\"50\" height=\"50\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:svg=\"http://www.w3.org/2000/svg\"><defs/><svg id=\"underlay-container\"/><g stroke=\"none\" font-family=\"Verdana, sans-serif\" font-size-adjust=\"none\" font-style=\"normal\" font-variant=\"normal\" font-weight=\"normal\" line-heigth=\"normal\" font-size=\"12\"><g class=\"stencils\"><g class=\"me\"/><g class=\"children\"/><g class=\"edge\"/></g><g class=\"svgcontainer\"><g display=\"none\"><rect x=\"0\" y=\"0\" stroke-width=\"1\" stroke=\"#777777\" fill=\"none\" stroke-dasharray=\"2,2\" pointer-events=\"none\"/></g><g display=\"none\"><path stroke-width=\"1\" stroke=\"silver\" fill=\"none\" stroke-dasharray=\"5,5\" pointer-events=\"none\"/></g><g display=\"none\"><path stroke-width=\"1\" stroke=\"silver\" fill=\"none\" stroke-dasharray=\"5,5\" pointer-events=\"none\"/></g><g/></g></g></svg>".getBytes("utf-8"));
      TranscoderInput input = new TranscoderInput(svgStream);
       
      PNGTranscoder transcoder = new PNGTranscoder();
      // Setup output
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      TranscoderOutput output = new TranscoderOutput(outStream);
       
      // Do the transformation
      transcoder.transcode(input, output);
      final byte[] result = outStream.toByteArray();
      repositoryService.addModelEditorSourceExtra(model.getId(), result);
      outStream.close();
      
      //更新绑定的model_ide
      fbBusTemplate.setModelId(model.getId());
      fbBusTemplate.setUpdateDateTime(DateUtil.getCurrentDateTime());
      fbBusTemplateMapper.updateByPrimaryKey(fbBusTemplate);
      dataMap.put("model_id", model.getId());
      resultMap.data(dataMap);
	  resultMap.success();
//      url = "http://127.0.0.1:"+request.getLocalPort()+request.getContextPath()+"/process-editor/modeler.html?modelId="+model.getId();
//      url = "<a href='"+url+"' target='_blank'>"+url+"</a>";
    } catch (Exception e) {
      LOGGER.error("Error saving model", e);
      throw new ActivitiException("Error saving model", e);
    }
    return resultMap.map();
  }
}