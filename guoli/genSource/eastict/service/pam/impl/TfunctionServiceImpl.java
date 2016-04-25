package eastict.service.pam.impl;
import eastict.mapper.pam.TfunctionMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tfunction;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TfunctionExample;
import eastict.service.pam.TfunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TfunctionServiceImpl  implements TfunctionService{
	@Autowired
	private TfunctionMapper _TfunctionMapper;
	@Override
	public CusResult insert(Tfunction _Tfunction){
		Object rlt = _TfunctionMapper.insert(_Tfunction);
		return CusResult.ok(rlt);
	}
	@Override
	public CusResult insertSelective(Tfunction _Tfunction){
		Object rlt = _TfunctionMapper.insertSelective(_Tfunction);
		return CusResult.ok(rlt);
	}
	@Override
	public Tfunction selectByPrimaryKey(Long _Long){
		return _TfunctionMapper.selectByPrimaryKey(_Long);
	}
	@Override
	public CusResult updateByPrimaryKey(Tfunction _Tfunction){
		Object rlt = _TfunctionMapper.updateByPrimaryKey(_Tfunction);
		return CusResult.ok(rlt);
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tfunction _Tfunction){
		Object rlt = _TfunctionMapper.updateByPrimaryKeySelective(_Tfunction);
		return CusResult.ok(rlt);
	}
	@Override
	public CusResult deleteByPrimaryKey(Long _Long){
		Object rlt = _TfunctionMapper.deleteByPrimaryKey(_Long);
		return CusResult.ok(rlt);
	}
	@Override
	public List<Tfunction> selectByExample(TfunctionExample _TfunctionExample){
		return _TfunctionMapper.selectByExample(_TfunctionExample);
	}
	@Override
	public EUDataGridResult getTfunctionList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
