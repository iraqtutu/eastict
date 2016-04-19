package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tviewnode;
import eastict.pojo.pam.TviewnodeExample;
import eastict.pojo.pam.TviewnodeKey;

public interface TviewnodeMapper {
    int deleteByPrimaryKey(TviewnodeKey key);

    int insert(Tviewnode record);

    int insertSelective(Tviewnode record);

    List<Tviewnode> selectByExample(TviewnodeExample example);

    Tviewnode selectByPrimaryKey(TviewnodeKey key);

    int updateByPrimaryKeySelective(Tviewnode record);

    int updateByPrimaryKey(Tviewnode record);
}