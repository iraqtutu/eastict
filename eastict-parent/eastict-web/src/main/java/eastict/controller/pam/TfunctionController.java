package eastict.controller.pam;
import eastict.service.pam.TfunctionService;
import eastict.pojo.pam.Tfunction;
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
public class TfunctionController {
	@Autowired
	private TfunctionService _TfunctionService;
	@RequestMapping(value="/Tfunction/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tfunction _val){
		CusResult  _rlt = _TfunctionService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tfunction/{keyVal}")
	@ResponseBody
	public Tfunction selectByPrimaryKey(@PathVariable Long keyVal){
		Tfunction _Tfunction = _TfunctionService.selectByPrimaryKey(keyVal);
		return  _Tfunction;
	}
	@RequestMapping("/Tfunction/list")
	@ResponseBody
	public EUDataGridResult getTfunctionList(Integer page, Integer rows) {
		EUDataGridResult result = _TfunctionService.getTfunctionList(page, rows);
		return result;
	}
}