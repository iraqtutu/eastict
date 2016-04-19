package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tuser;
import eastict.pojo.pam.TuserExample;

public interface TuserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    Tuser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
}