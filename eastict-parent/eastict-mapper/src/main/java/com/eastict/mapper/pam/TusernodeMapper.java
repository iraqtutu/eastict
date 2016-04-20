package com.eastict.mapper.pam;

import eastict.pojo.pam.Tusernode;
import eastict.pojo.pam.TusernodeExample;
import java.util.List;

public interface TusernodeMapper {
    int insert(Tusernode record);

    int insertSelective(Tusernode record);

    List<Tusernode> selectByExample(TusernodeExample example);
}