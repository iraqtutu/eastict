package eastict.pam.mapper;

import eastict.pam.pojo.Tapp;
import eastict.pam.pojo.TappExample;
import java.util.List;

public interface TappMapper {
    int insert(Tapp record);

    int insertSelective(Tapp record);

    List<Tapp> selectByExample(TappExample example);
}