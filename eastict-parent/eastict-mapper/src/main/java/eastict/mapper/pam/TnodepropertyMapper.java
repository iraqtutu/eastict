package eastict.mapper.pam;

import java.util.List;

import eastict.pojo.pam.Tnodeproperty;
import eastict.pojo.pam.TnodepropertyExample;

public interface TnodepropertyMapper {
    int deleteByPrimaryKey(Long propertyid);

    int insert(Tnodeproperty record);

    int insertSelective(Tnodeproperty record);

    List<Tnodeproperty> selectByExample(TnodepropertyExample example);

    Tnodeproperty selectByPrimaryKey(Long propertyid);

    int updateByPrimaryKeySelective(Tnodeproperty record);

    int updateByPrimaryKey(Tnodeproperty record);
}