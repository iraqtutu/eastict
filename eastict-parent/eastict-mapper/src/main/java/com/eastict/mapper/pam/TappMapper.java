package com.eastict.mapper.pam;

import eastict.pojo.pam.Tapp;
import eastict.pojo.pam.TappExample;
import java.util.List;

public interface TappMapper {
    int insert(Tapp record);

    int insertSelective(Tapp record);

    List<Tapp> selectByExample(TappExample example);
}