package com.eastict.service.pam.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eastict.mapper.pam.TuserMapper;
import com.eastict.pojo.CusResult;
import com.eastict.service.pam.UserService;

import eastict.pojo.pam.Tuser;
import eastict.pojo.pam.TuserExample;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TuserMapper userMapper;
	
	@Override
	public CusResult createUser(Tuser user) {
		user.setCreatetime(DateTime.now().toDate());
		user.setEnabled(true);
		userMapper.insert(user);
		return CusResult.ok();
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
