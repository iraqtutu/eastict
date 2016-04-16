package eastict.pam.mapper;

import eastict.pam.pojo.Tviewnode;
import eastict.pam.pojo.TviewnodeExample;
import eastict.pam.pojo.TviewnodeKey;
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