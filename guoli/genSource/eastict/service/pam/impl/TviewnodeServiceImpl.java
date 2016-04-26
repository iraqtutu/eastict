package eastict.service.pam.impl;
import eastict.mapper.pam.TviewnodeMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tviewnode;
import eastict.pojo.pam.TviewnodeKey;
import java.util.List;
import eastict.pojo.pam.TviewnodeExample;
import eastict.service.pam.TviewnodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TviewnodeServiceImpl  implements TviewnodeService{
	@Autowired
	private TviewnodeMapper _TviewnodeMapper;
	@Override
	public CusResult insert(Tviewnode _Tviewnode){
		try{
			Object rlt = _TviewnodeMapper.insert(_Tviewnode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tviewnode _Tviewnode){
		try{
			Object rlt = _TviewnodeMapper.insertSelective(_Tviewnode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public Tviewnode selectByPrimaryKey(TviewnodeKey _TviewnodeKey){
		return _TviewnodeMapper.selectByPrimaryKey(_TviewnodeKey);
	}
	@Override
	public CusResult updateByPrimaryKey(Tviewnode _Tviewnode){
		try{
			Object rlt = _TviewnodeMapper.updateByPrimaryKey(_Tviewnode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tviewnode _Tviewnode){
		try{
			Object rlt = _TviewnodeMapper.updateByPrimaryKeySelective(_Tviewnode);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult deleteByPrimaryKey(TviewnodeKey _TviewnodeKey){
		try{
			Object rlt = _TviewnodeMapper.deleteByPrimaryKey(_TviewnodeKey);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tviewnode> selectByExample(TviewnodeExample _TviewnodeExample){
		return _TviewnodeMapper.selectByExample(_TviewnodeExample);
	}
	@Override
	public EUDataGridResult getTviewnodeList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
