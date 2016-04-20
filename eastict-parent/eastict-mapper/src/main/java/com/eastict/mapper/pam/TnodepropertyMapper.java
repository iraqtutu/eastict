package com.eastict.mapper.pam;

import eastict.pojo.pam.Tnodeproperty;
import eastict.pojo.pam.TnodepropertyExample;
import java.util.List;

public interface TnodepropertyMapper {
    int deleteByPrimaryKey(Long propertyid);

    int insert(Tnodeproperty record);

    int insertSelective(Tnodeproperty record);

    List<Tnodeproperty> selectByExample(TnodepropertyExample example);

    Tnodeproperty selectByPrimaryKey(Long propertyid);

    int updateByPrimaryKeySelective(Tnodeproperty record);

    int updateByPrimaryKey(Tnodeproperty record);
}