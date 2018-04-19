package com.zrt.flow.service.flowcondition;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.MapEntityConverter;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.serial.SerialService;
import com.zrt.mybatis.domain.FbBusAddFile;
import com.zrt.mybatis.domain.FbBusAddRelevance;
import com.zrt.mybatis.domain.FbBusCondition;
import com.zrt.mybatis.mapper.FbBusAddFileMapper;
import com.zrt.mybatis.mapper.FbBusAddRelevanceMapper;
import com.zrt.mybatis.mapper.FbBusConditionMapper;

/**
 * Created by dwliu on 2017/9/22.
 */
@Service
public class FlowconditionServiceImpl implements FlowconditionService {

    @Autowired
    private FbBusConditionMapper fbBusConditionMapper;
    @Autowired
    private SerialService serialService;
    @Autowired
    private FbBusAddFileMapper fbBusAddFileMapper;
    @Autowired
    private FbBusAddRelevanceMapper fbBusAddRelevanceMapper;

    @Override
    @Transactional(rollbackFor = {Throwable.class}, propagation = Propagation.REQUIRED)
    public int applyCheckWithFile(Map<String, Object> map) throws Exception {
        if (map == null || map.isEmpty())
            return 0;
        List<Map<String, Object>> conList = (List<Map<String, Object>>) map.get("con");
        for (int i = 0; i < conList.size(); i++) {
            Map<String, Object> conMap = conList.get(i);
            FbBusCondition fbBusCondition = new FbBusCondition();
            String conId = serialService.getUUID();
            fbBusCondition.setId(conId);
            fbBusCondition.setInstId((String) map.get("inst_id"));
            fbBusCondition.setRevContent((String) conMap.get("rev_content"));
            fbBusCondition.setCreateDateTime(DateUtil.getCurrentDateTime());
            fbBusCondition.setRevDateTime(DateUtil.getCurrentDateTime());
            fbBusConditionMapper.insert(fbBusCondition);

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> listFile = (List<Map<String, Object>>) conMap.get("add_file");
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> listRelevance = (List<Map<String, Object>>) conMap.get("add_rel");
            if (listFile != null && listFile.size() > 0) {
                for (Map<String, Object> m : listFile) {
                    FbBusAddFile fbBusAddFile = (FbBusAddFile) MapEntityConverter.getEntityFromMap(m,
                            FbBusAddFile.class);
                    fbBusAddFile.setId(serialService.getUUID());
                    fbBusAddFile.setConId(conId);
                    fbBusAddFile.setCreateDateTime(DateUtil.getCurrentDateTime());
                    fbBusAddFileMapper.insertSelective(fbBusAddFile);
                }
            }

            if (listRelevance != null && listRelevance.size() > 0) {
                for (Map<String, Object> m : listRelevance) {
                    FbBusAddRelevance fbBusAddRelevance = (FbBusAddRelevance) MapEntityConverter.getEntityFromMap(m,
                            FbBusAddRelevance.class);
                    fbBusAddRelevance.setConId(conId);
                    fbBusAddRelevance.setCreateDateTime(DateUtil.getCurrentDateTime());
                    fbBusAddRelevance.setId(serialService.getUUID());
                    fbBusAddRelevanceMapper.insertSelective(fbBusAddRelevance);
                }
            }
        }
        return conList.size();
    }
}
