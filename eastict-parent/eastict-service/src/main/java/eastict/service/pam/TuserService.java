package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tuser;
import java.lang.String;
import java.util.List;
import eastict.pojo.pam.TuserExample;
public interface TuserService {
	CusResult insert(Tuser _Tuser);
	CusResult insertSelective(Tuser _Tuser);
	Tuser selectByPrimaryKey(String _String);
	CusResult updateByPrimaryKey(Tuser _Tuser);
	CusResult updateByPrimaryKeySelective(Tuser _Tuser);
	CusResult deleteByPrimaryKey(String _String);
	List<Tuser> selectByExample(TuserExample _TuserExample);
	EUDataGridResult getTuserList(int page, int rows);
}