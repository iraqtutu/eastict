package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tfunction;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TfunctionExample;
public interface TfunctionService {
	CusResult insert(Tfunction _Tfunction);
	CusResult insertSelective(Tfunction _Tfunction);
	Tfunction selectByPrimaryKey(Long _Long);
	CusResult updateByPrimaryKey(Tfunction _Tfunction);
	CusResult updateByPrimaryKeySelective(Tfunction _Tfunction);
	CusResult deleteByPrimaryKey(Long _Long);
	List<Tfunction> selectByExample(TfunctionExample _TfunctionExample);
	EUDataGridResult getTfunctionList(int page, int rows);
}