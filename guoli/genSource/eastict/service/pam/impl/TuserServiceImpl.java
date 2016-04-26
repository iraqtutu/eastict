package eastict.service.pam.impl;
import eastict.mapper.pam.TuserMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tuser;
import java.lang.String;
import java.util.List;
import eastict.pojo.pam.TuserExample;
import eastict.service.pam.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TuserServiceImpl  implements TuserService{
	@Autowired
	private TuserMapper _TuserMapper;
	@Override
	public CusResult insert(Tuser _Tuser){
		try{
			Object rlt = _TuserMapper.insert(_Tuser);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tuser _Tuser){
		try{
			Object rlt = _TuserMapper.insertSelective(_Tuser);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public Tuser selectByPrimaryKey(String _String){
		return _TuserMapper.selectByPrimaryKey(_String);
	}
	@Override
	public CusResult updateByPrimaryKey(Tuser _Tuser){
		try{
			Object rlt = _TuserMapper.updateByPrimaryKey(_Tuser);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tuser _Tuser){
		try{
			Object rlt = _TuserMapper.updateByPrimaryKeySelective(_Tuser);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult deleteByPrimaryKey(String _String){
		try{
			Object rlt = _TuserMapper.deleteByPrimaryKey(_String);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tuser> selectByExample(TuserExample _TuserExample){
		return _TuserMapper.selectByExample(_TuserExample);
	}
	@Override
	public EUDataGridResult getTuserList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
