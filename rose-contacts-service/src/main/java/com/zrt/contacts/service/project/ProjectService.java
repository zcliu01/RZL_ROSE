package com.zrt.contacts.service.project;

import java.util.Map;

import com.zrt.commons.AppException;

public interface ProjectService {
      /**
       * 查询所有的项目列表
       * @param map
       * @return
       */
	  Map<String,Object> projectList(Map<String, Object> map) throws AppException;;
}
