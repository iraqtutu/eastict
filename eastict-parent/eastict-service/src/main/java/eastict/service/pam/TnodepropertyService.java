package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tnodeproperty;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TnodepropertyExample;
public interface TnodepropertyService {
	CusResult insert(Tnodeproperty _Tnodeproperty);
	CusResult insertSelective(Tnodeproperty _Tnodeproperty);
	Tnodeproperty selectByPrimaryKey(Long _Long);
	CusResult updateByPrimaryKey(Tnodeproperty _Tnodeproperty);
	CusResult updateByPrimaryKeySelective(Tnodeproperty _Tnodeproperty);
	CusResult deleteByPrimaryKey(Long _Long);
	List<Tnodeproperty> selectByExample(TnodepropertyExample _TnodepropertyExample);
	EUDataGridResult getTnodepropertyList(int page, int rows);
}