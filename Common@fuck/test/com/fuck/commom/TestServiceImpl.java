package com.fuck.commom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fuck.mobile.base.dao.db.MainDao;

@Repository
public class TestServiceImpl implements ITestService {

	@Autowired
	MainDao main;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void add(String v) throws Exception {
		aaa(v);
	}

	
	private void aaa(String v) throws Exception{
		main.update("insert into cms.test(id) values(?)", v);
		throw new Exception("sss");
	}
}
