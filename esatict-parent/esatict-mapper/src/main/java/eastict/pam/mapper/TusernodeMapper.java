package eastict.pam.mapper;

import eastict.pam.pojo.Tusernode;
import eastict.pam.pojo.TusernodeExample;
import java.util.List;

public interface TusernodeMapper {
    int insert(Tusernode record);

    int insertSelective(Tusernode record);

    List<Tusernode> selectByExample(TusernodeExample example);
}