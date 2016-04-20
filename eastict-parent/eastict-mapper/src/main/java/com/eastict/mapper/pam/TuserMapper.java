package com.eastict.mapper.pam;

import eastict.pojo.pam.Tuser;
import eastict.pojo.pam.TuserExample;
import java.util.List;

public interface TuserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    Tuser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
}