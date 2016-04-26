package eastict.service.pam.impl;
import eastict.mapper.pam.TusernodeMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tusernode;
import java.util.List;
import eastict.pojo.pam.TusernodeExample;
import eastict.service.pam.TusernodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TusernodeServiceImpl  implements TusernodeService{
	@Autowired
	private TusernodeMapper _TusernodeMapper;
	@Override
	public CusResult insert(Tusernode _Tusernode){
		try{
			Object rlt = _TusernodeMapper.insert(_Tusernode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tusernode _Tusernode){
		try{
			Object rlt = _TusernodeMapper.insertSelective(_Tusernode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tusernode> selectByExample(TusernodeExample _TusernodeExample){
		return _TusernodeMapper.selectByExample(_TusernodeExample);
	}
	@Override
	public EUDataGridResult getTusernodeList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
