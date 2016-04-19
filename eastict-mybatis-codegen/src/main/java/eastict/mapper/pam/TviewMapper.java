package eastict.mapper.pam;

import eastict.pojo.pam.Tview;
import eastict.pojo.pam.TviewExample;
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