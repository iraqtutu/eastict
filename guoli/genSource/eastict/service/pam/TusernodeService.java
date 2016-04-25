package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tusernode;
import java.util.List;
import eastict.pojo.pam.TusernodeExample;
public interface TusernodeService {
	CusResult insert(Tusernode _Tusernode);
	CusResult insertSelective(Tusernode _Tusernode);
	List<Tusernode> selectByExample(TusernodeExample _TusernodeExample);
	EUDataGridResult getTusernodeList(int page, int rows);
}