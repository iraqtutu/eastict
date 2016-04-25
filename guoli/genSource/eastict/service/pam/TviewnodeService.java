package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tviewnode;
import eastict.pojo.pam.TviewnodeKey;
import java.util.List;
import eastict.pojo.pam.TviewnodeExample;
public interface TviewnodeService {
	CusResult insert(Tviewnode _Tviewnode);
	CusResult insertSelective(Tviewnode _Tviewnode);
	Tviewnode selectByPrimaryKey(TviewnodeKey _TviewnodeKey);
	CusResult updateByPrimaryKey(Tviewnode _Tviewnode);
	CusResult updateByPrimaryKeySelective(Tviewnode _Tviewnode);
	CusResult deleteByPrimaryKey(TviewnodeKey _TviewnodeKey);
	List<Tviewnode> selectByExample(TviewnodeExample _TviewnodeExample);
	EUDataGridResult getTviewnodeList(int page, int rows);
}