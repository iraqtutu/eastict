package eastict.controller.pam;
import eastict.service.pam.TnodepropertyService;
import eastict.pojo.pam.Tnodeproperty;
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
public class TnodepropertyController {
	@Autowired
	private TnodepropertyService _TnodepropertyService;
	@RequestMapping(value="/Tnodeproperty/save", method=RequestMethod.POST)
	@ResponseBody
	public CusResult insert(Tnodeproperty _val){
		CusResult  _rlt = _TnodepropertyService.insert(_val);
		return  _rlt;
	}
	@RequestMapping("/Tnodeproperty/{keyVal}")
	@ResponseBody
	public Tnodeproperty selectByPrimaryKey(@PathVariable Long keyVal){
		Tnodeproperty _Tnodeproperty = _TnodepropertyService.selectByPrimaryKey(keyVal);
		return  _Tnodeproperty;
	}
	@RequestMapping("/Tnodeproperty/list")
	@ResponseBody
	public EUDataGridResult getTnodepropertyList(Integer page, Integer rows) {
		EUDataGridResult result = _TnodepropertyService.getTnodepropertyList(page, rows);
		return result;
	}
}