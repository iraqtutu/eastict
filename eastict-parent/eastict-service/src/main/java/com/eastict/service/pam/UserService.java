package com.eastict.service.pam;

import org.joda.time.DateTime;

import com.eastict.pojo.CusResult;

import eastict.pojo.pam.Tuser;

public interface UserService {
	CusResult createUser(Tuser user);
	Tuser getUserByID(String userid);
	Tuser getUserByLoginName(String loginName);
}
