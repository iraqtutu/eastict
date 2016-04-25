package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tapp;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TappExample;
public interface TappService {
	CusResult insert(Tapp _Tapp);
	CusResult insertSelective(Tapp _Tapp);
	Tapp selectByPrimaryKey(Long _Long);
	CusResult updateByPrimaryKey(Tapp _Tapp);
	CusResult updateByPrimaryKeySelective(Tapp _Tapp);
	CusResult deleteByPrimaryKey(Long _Long);
	List<Tapp> selectByExample(TappExample _TappExample);
	EUDataGridResult getTappList(int page, int rows);
}