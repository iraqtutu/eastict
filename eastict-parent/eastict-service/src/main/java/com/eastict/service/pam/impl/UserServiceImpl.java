package com.eastict.service.pam.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eastict.pojo.ControllerResult;
import com.eastict.service.pam.UserService;

import eastict.mapper.pam.TuserMapper;
import eastict.pojo.pam.Tuser;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tuser getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

}
