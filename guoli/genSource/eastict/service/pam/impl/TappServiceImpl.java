package eastict.service.pam.impl;
import eastict.mapper.pam.TappMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tapp;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TappExample;
import eastict.service.pam.TappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TappServiceImpl  implements TappService{
	@Autowired
	private TappMapper _TappMapper;
	@Override
	public CusResult insert(Tapp _Tapp){
		try{
			Object rlt = _TappMapper.insert(_Tapp);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tapp _Tapp){
		try{
			Object rlt = _TappMapper.insertSelective(_Tapp);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public Tapp selectByPrimaryKey(Long _Long){
		return _TappMapper.selectByPrimaryKey(_Long);
	}
	@Override
	public CusResult updateByPrimaryKey(Tapp _Tapp){
		try{
			Object rlt = _TappMapper.updateByPrimaryKey(_Tapp);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tapp _Tapp){
		try{
			Object rlt = _TappMapper.updateByPrimaryKeySelective(_Tapp);
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
			Object rlt = _TappMapper.deleteByPrimaryKey(_Long);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tapp> selectByExample(TappExample _TappExample){
		return _TappMapper.selectByExample(_TappExample);
	}
	@Override
	public EUDataGridResult getTappList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
