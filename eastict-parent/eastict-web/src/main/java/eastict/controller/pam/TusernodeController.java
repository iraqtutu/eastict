package eastict.controller.pam;
import eastict.service.pam.TusernodeService;
import eastict.pojo.pam.Tusernode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
@Controller
public class TusernodeController {
	@Autowired
	private TusernodeService _TusernodeService;
	@RequestMapping(value="/Tusernode/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tusernode _val){
		CusResult  _rlt = _TusernodeService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tusernode/list")
	@ResponseBody
	public EUDataGridResult getTusernodeList(Integer page, Integer rows) {
		EUDataGridResult result = _TusernodeService.getTusernodeList(page, rows);
		return result;
	}
}