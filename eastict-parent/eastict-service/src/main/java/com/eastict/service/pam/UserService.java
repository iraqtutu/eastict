package com.eastict.service.pam;

import org.joda.time.DateTime;

import eastict.pojo.pam.Tuser;

public interface UserService {
	Tuser createUser(String userid,String logonname,String displayname,String pwdmd5,DateTime createTime,String pictureUrl);
	Tuser getUserByID(String userid);
	Tuser getUserByLoginName(String loginName);
}
