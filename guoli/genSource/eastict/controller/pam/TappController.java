package eastict.controller.pam;
import eastict.service.pam.TappService;
import eastict.pojo.pam.Tapp;
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
public class TappController {
	@Autowired
	private TappService _TappService;
	@RequestMapping(value="/Tapp/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tapp _val){
		CusResult  _rlt = _TappService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tapp/{keyVal}")
	@ResponseBody
	public Tapp selectByPrimaryKey(@PathVariable Long keyVal){
		Tapp _Tapp = _TappService.selectByPrimaryKey(keyVal);
		return  _Tapp;
	}
	@RequestMapping("/Tapp/list")
	@ResponseBody
	public EUDataGridResult getTappList(Integer page, Integer rows) {
		EUDataGridResult result = _TappService.getTappList(page, rows);
		return result;
	}
}