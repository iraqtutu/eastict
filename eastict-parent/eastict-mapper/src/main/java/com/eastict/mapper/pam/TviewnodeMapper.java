package com.eastict.mapper.pam;

import eastict.pojo.pam.Tviewnode;
import eastict.pojo.pam.TviewnodeExample;
import eastict.pojo.pam.TviewnodeKey;
import java.util.List;

public interface TviewnodeMapper {
    int deleteByPrimaryKey(TviewnodeKey key);

    int insert(Tviewnode record);

    int insertSelective(Tviewnode record);

    List<Tviewnode> selectByExample(TviewnodeExample example);

    Tviewnode selectByPrimaryKey(TviewnodeKey key);

    int updateByPrimaryKeySelective(Tviewnode record);

    int updateByPrimaryKey(Tviewnode record);
}