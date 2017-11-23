package com.sunrise.common.utils.alarm;


import com.sunrise.ucp.dal.gen.model.UserVO;

public interface MessageNotifier {
	void notify(UserVO[] users, String msg) throws Exception;
	void notify(UserVO[] users, String subjectTemplate,String msgTemplate) throws Exception;
}