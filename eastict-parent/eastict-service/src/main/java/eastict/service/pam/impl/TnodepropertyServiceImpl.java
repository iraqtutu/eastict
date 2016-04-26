package eastict.service.pam.impl;
import eastict.mapper.pam.TnodepropertyMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tnodeproperty;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TnodepropertyExample;
import eastict.service.pam.TnodepropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TnodepropertyServiceImpl  implements TnodepropertyService{
	@Autowired
	private TnodepropertyMapper _TnodepropertyMapper;
	@Override
	public CusResult insert(Tnodeproperty _Tnodeproperty){
		try{
			Object rlt = _TnodepropertyMapper.insert(_Tnodeproperty);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tnodeproperty _Tnodeproperty){
		try{
			Object rlt = _TnodepropertyMapper.insertSelective(_Tnodeproperty);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public Tnodeproperty selectByPrimaryKey(Long _Long){
		return _TnodepropertyMapper.selectByPrimaryKey(_Long);
	}
	@Override
	public CusResult updateByPrimaryKey(Tnodeproperty _Tnodeproperty){
		try{
			Object rlt = _TnodepropertyMapper.updateByPrimaryKey(_Tnodeproperty);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tnodeproperty _Tnodeproperty){
		try{
			Object rlt = _TnodepropertyMapper.updateByPrimaryKeySelective(_Tnodeproperty);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult deleteByPrimaryKey(Long _Long){
		try{
			Object rlt = _TnodepropertyMapper.deleteByPrimaryKey(_Long);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tnodeproperty> selectByExample(TnodepropertyExample _TnodepropertyExample){
		return _TnodepropertyMapper.selectByExample(_TnodepropertyExample);
	}
	@Override
	public EUDataGridResult getTnodepropertyList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
