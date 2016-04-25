package eastict.controller.pam;
import eastict.service.pam.TviewnodeService;
import eastict.pojo.pam.Tviewnode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.TviewnodeKey;
@Controller
public class TviewnodeController {
	@Autowired
	private TviewnodeService _TviewnodeService;
	@RequestMapping(value="/Tviewnode/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tviewnode _val){
		CusResult  _rlt = _TviewnodeService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tviewnode/{keyVal}")
	@ResponseBody
	public Tviewnode selectByPrimaryKey(@PathVariable TviewnodeKey keyVal){
		Tviewnode _Tviewnode = _TviewnodeService.selectByPrimaryKey(keyVal);
		return  _Tviewnode;
	}
	@RequestMapping("/Tviewnode/list")
	@ResponseBody
	public EUDataGridResult getTviewnodeList(Integer page, Integer rows) {
		EUDataGridResult result = _TviewnodeService.getTviewnodeList(page, rows);
		return result;
	}
}