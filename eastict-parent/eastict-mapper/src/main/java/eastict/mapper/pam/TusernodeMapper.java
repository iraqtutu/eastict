package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tusernode;
import eastict.pojo.pam.TusernodeExample;

public interface TusernodeMapper {
    int insert(Tusernode record);

    int insertSelective(Tusernode record);

    List<Tusernode> selectByExample(TusernodeExample example);
}