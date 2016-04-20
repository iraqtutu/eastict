package com.eastict.service.pam.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eastict.pojo.ControllerResult;
import com.eastict.service.pam.UserService;

import eastict.mapper.pam.TuserMapper;
import eastict.pojo.pam.Tuser;
import eastict.pojo.pam.TuserExample;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TuserMapper userMapper;
	
	@Override
	public ControllerResult createUser(String userid, String logonname, String displayname, String pwdmd5, DateTime createTime,
			String pictureUrl) {
		Tuser user = new Tuser();
		user.setUserid(userid);
		user.setLogonname(logonname);
		user.setDisplayname(displayname);
		user.setPwdmd5(pwdmd5);
		user.setCreatetime(DateTime.now().toDate());
		user.setEnabled(true);
		user.setPictureurl(pictureUrl);
		userMapper.insert(user);
		return ControllerResult.ok();
	}

	@Override
	public Tuser getUserByID(String userid) {
		Tuser user = userMapper.selectByPrimaryKey(userid);
		return user;
	}

	@Override
	public Tuser getUserByLoginName(String loginName) {
		TuserExample xampl = new TuserExample();
		xampl.createCriteria().andLogonnameEqualTo(loginName);
		List<Tuser> users = userMapper.selectByExample(xampl);
		if(users!=null && users.size() > 0){
			return users.get(1);
		}else{
			return null;
		}
	}

}
