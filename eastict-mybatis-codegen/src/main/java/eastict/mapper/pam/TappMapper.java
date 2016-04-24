package eastict.mapper.pam;

import eastict.pojo.pam.Tapp;
import eastict.pojo.pam.TappExample;
import java.util.List;

public interface TappMapper {
    int deleteByPrimaryKey(Long appid);

    int insert(Tapp record);

    int insertSelective(Tapp record);

    List<Tapp> selectByExample(TappExample example);

    Tapp selectByPrimaryKey(Long appid);

    int updateByPrimaryKeySelective(Tapp record);

    int updateByPrimaryKey(Tapp record);
}