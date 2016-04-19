package com.eastict.service.pam;

import org.joda.time.DateTime;

import com.eastict.pojo.ControllerResult;

import eastict.pojo.pam.Tuser;

public interface UserService {
	ControllerResult createUser(String userid,String logonname,String displayname,String pwdmd5,DateTime createTime,String pictureUrl);
	Tuser getUserByID(String userid);
	Tuser getUserByLoginName(String loginName);
}
