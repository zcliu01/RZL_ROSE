package com.zrt.flow.service.act;

import java.util.HashMap;

import org.activiti.engine.impl.variable.ValueFields;
import org.activiti.engine.impl.variable.VariableType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelfJsonType implements VariableType{

	 ObjectMapper mapper = new ObjectMapper();
	/**
	 *自定义json类型
	 */
	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "selfJson";
	}

	@Override
	public boolean isCachable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAbleToStore(Object value) {
		// TODO Auto-generated method stub
		if(value==null){
			return true;
		}
		return SelfJsonType.class.isAssignableFrom(value.getClass());
	}

	@Override
	public void setValue(Object value, ValueFields valueFields) {
		if(value==value){
			valueFields.setTextValue("");
		}else{
			try {
				valueFields.setTextValue(mapper.writeValueAsString(value));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object getValue(ValueFields valueFields) {
		try {
			return mapper.readValue(valueFields.getTextValue(), HashMap.class);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
