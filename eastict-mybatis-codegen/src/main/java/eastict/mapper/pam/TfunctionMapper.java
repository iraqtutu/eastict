package eastict.mapper.pam;

import eastict.pojo.pam.Tfunction;
import eastict.pojo.pam.TfunctionExample;
import java.util.List;

public interface TfunctionMapper {
    int deleteByPrimaryKey(Long funcid);

    int insert(Tfunction record);

    int insertSelective(Tfunction record);

    List<Tfunction> selectByExample(TfunctionExample example);

    Tfunction selectByPrimaryKey(Long funcid);

    int updateByPrimaryKeySelective(Tfunction record);

    int updateByPrimaryKey(Tfunction record);
}