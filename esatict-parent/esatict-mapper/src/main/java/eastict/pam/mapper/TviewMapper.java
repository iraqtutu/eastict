package eastict.pam.mapper;

import eastict.pam.pojo.Tview;
import eastict.pam.pojo.TviewExample;
import java.util.List;

public interface TviewMapper {
    int deleteByPrimaryKey(Long viewid);

    int insert(Tview record);

    int insertSelective(Tview record);

    List<Tview> selectByExample(TviewExample example);

    Tview selectByPrimaryKey(Long viewid);

    int updateByPrimaryKeySelective(Tview record);

    int updateByPrimaryKey(Tview record);
}