package eastict.pam.mapper;

import eastict.pam.pojo.Tnodeproperty;
import eastict.pam.pojo.TnodepropertyExample;
import java.util.List;

public interface TnodepropertyMapper {
    int deleteByPrimaryKey(Long propertyid);

    int insert(Tnodeproperty record);

    int insertSelective(Tnodeproperty record);

    List<Tnodeproperty> selectByExample(TnodepropertyExample example);

    Tnodeproperty selectByPrimaryKey(Long propertyid);

    int updateByPrimaryKeySelective(Tnodeproperty record);

    int updateByPrimaryKey(Tnodeproperty record);
}