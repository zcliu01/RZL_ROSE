package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbRoleTemplate;
import com.zrt.mybatis.domain.FbRoleTemplateExample;
import com.zrt.mybatis.domain.FbRoleTemplateKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbRoleTemplateMapper {
    int countByExample(FbRoleTemplateExample example);

    int deleteByExample(FbRoleTemplateExample example);

    int deleteByPrimaryKey(FbRoleTemplateKey key);

    int insert(FbRoleTemplate record);

    int insertSelective(FbRoleTemplate record);

    List<FbRoleTemplate> selectByExample(FbRoleTemplateExample example);

    FbRoleTemplate selectByPrimaryKey(FbRoleTemplateKey key);

    int updateByExampleSelective(@Param("record") FbRoleTemplate record, @Param("example") FbRoleTemplateExample example);

    int updateByExample(@Param("record") FbRoleTemplate record, @Param("example") FbRoleTemplateExample example);

    int updateByPrimaryKeySelective(FbRoleTemplate record);

    int updateByPrimaryKey(FbRoleTemplate record);
}