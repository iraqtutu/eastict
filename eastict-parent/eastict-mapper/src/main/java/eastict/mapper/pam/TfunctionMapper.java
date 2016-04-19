package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tfunction;
import eastict.pojo.pam.TfunctionExample;

public interface TfunctionMapper {
    int deleteByPrimaryKey(Long funcid);

    int insert(Tfunction record);

    int insertSelective(Tfunction record);

    List<Tfunction> selectByExample(TfunctionExample example);

    Tfunction selectByPrimaryKey(Long funcid);

    int updateByPrimaryKeySelective(Tfunction record);

    int updateByPrimaryKey(Tfunction record);
}