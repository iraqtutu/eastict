package eastict.controller.pam;
import eastict.service.pam.TviewService;
import eastict.pojo.pam.Tview;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import java.lang.Long;
@Controller
public class TviewController {
	@Autowired
	private TviewService _TviewService;
	@RequestMapping(value="/Tview/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tview _val){
		CusResult  _rlt = _TviewService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tview/{keyVal}")
	@ResponseBody
	public Tview selectByPrimaryKey(@PathVariable Long keyVal){
		Tview _Tview = _TviewService.selectByPrimaryKey(keyVal);
		return  _Tview;
	}
	@RequestMapping("/Tview/list")
	@ResponseBody
	public EUDataGridResult getTviewList(Integer page, Integer rows) {
		EUDataGridResult result = _TviewService.getTviewList(page, rows);
		return result;
	}
}