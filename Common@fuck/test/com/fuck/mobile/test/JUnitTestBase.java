package com.fuck.mobile.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) 
//@WebAppConfiguration 
@ContextConfiguration(loader=AnnotationConfigContextLoaderEx.class)
public class JUnitTestBase extends AbstractJUnit4SpringContextTests  {
		
	
}
