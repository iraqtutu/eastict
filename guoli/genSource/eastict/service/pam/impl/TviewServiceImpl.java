package eastict.service.pam.impl;
import eastict.mapper.pam.TviewMapper;
import com.eastict.pojo.CusResult;
import com.eastict.pojo.EUDataGridResult;
import eastict.pojo.pam.Tview;
import java.lang.Long;
import java.util.List;
import eastict.pojo.pam.TviewExample;
import eastict.service.pam.TviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.eastict.common.utils.IDUtils;
@Service
public class TviewServiceImpl  implements TviewService{
	@Autowired
	private TviewMapper _TviewMapper;
	@Override
	public CusResult insert(Tview _Tview){
		try{
			Object rlt = _TviewMapper.insert(_Tview);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult insertSelective(Tview _Tview){
		try{
			Object rlt = _TviewMapper.insertSelective(_Tview);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public Tview selectByPrimaryKey(Long _Long){
		return _TviewMapper.selectByPrimaryKey(_Long);
	}
	@Override
	public CusResult updateByPrimaryKey(Tview _Tview){
		try{
			Object rlt = _TviewMapper.updateByPrimaryKey(_Tview);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public CusResult updateByPrimaryKeySelective(Tview _Tview){
		try{
			Object rlt = _TviewMapper.updateByPrimaryKeySelective(_Tview);
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
			Object rlt = _TviewMapper.deleteByPrimaryKey(_Long);
			return CusResult.ok(rlt);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new CusResult(500,ex.getMessage(),null);
		}
	}
	@Override
	public List<Tview> selectByExample(TviewExample _TviewExample){
		return _TviewMapper.selectByExample(_TviewExample);
	}
	@Override
	public EUDataGridResult getTviewList(int page, int rows){
		//请根据需要实现分页查询，通过Example查询实现
		return null;
	}
}
