package eastict.pam.mapper;

import eastict.pam.pojo.Tuser;
import eastict.pam.pojo.TuserExample;
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