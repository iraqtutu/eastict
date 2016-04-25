package eastict.service.pam;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tview;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TviewExample;
public interface TviewService {
	CusResult insert(Tview _Tview);
	CusResult insertSelective(Tview _Tview);
	Tview selectByPrimaryKey(Long _Long);
	CusResult updateByPrimaryKey(Tview _Tview);
	CusResult updateByPrimaryKeySelective(Tview _Tview);
	CusResult deleteByPrimaryKey(Long _Long);
	List<Tview> selectByExample(TviewExample _TviewExample);
	EUDataGridResult getTviewList(int page, int rows);
}