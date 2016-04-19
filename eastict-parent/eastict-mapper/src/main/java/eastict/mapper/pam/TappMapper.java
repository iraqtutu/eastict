package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tapp;
import eastict.pojo.pam.TappExample;

public interface TappMapper {
    int insert(Tapp record);

    int insertSelective(Tapp record);

    List<Tapp> selectByExample(TappExample example);
}