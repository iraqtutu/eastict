package eastict.controller.pam;
import eastict.service.pam.TuserService;
import eastict.pojo.pam.Tuser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import java.lang.String;
@Controller
public class TuserController {
	@Autowired
	private TuserService _TuserService;
	@RequestMapping(value="/Tuser/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tuser _val){
		CusResult  _rlt = _TuserService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tuser/{keyVal}")
	@ResponseBody
	public Tuser selectByPrimaryKey(@PathVariable String keyVal){
		Tuser _Tuser = _TuserService.selectByPrimaryKey(keyVal);
		return  _Tuser;
	}
	@RequestMapping("/Tuser/list")
	@ResponseBody
	public EUDataGridResult getTuserList(Integer page, Integer rows) {
		EUDataGridResult result = _TuserService.getTuserList(page, rows);
		return result;
	}
}