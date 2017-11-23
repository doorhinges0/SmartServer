package com.fuck.mobile.base.spring;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


public class DataModelAndView extends ModelAndView {

	static Log log = LogFactory.getLog(DataModelAndView.class);
	private byte[] datas;
	private String ct = "application/octet-stream";
	
	public DataModelAndView(byte[] datas)
	{
		super();
		this.datas = datas;
	}
	
	public DataModelAndView(byte[] datas,String contentType)
	{
		super();
		this.datas = datas;
		this.ct = contentType;
	}
	
	 public boolean hasView()
	 {
		 return true;
	 }
	
	public boolean isEmpty()
	{
		return false;
	}

	@Override
	public View getView() {
	
		return new View() {
			
			@Override
			public void render(Map<String, ?> paramMap,
					HttpServletRequest paramHttpServletRequest,
					HttpServletResponse paramHttpServletResponse) throws Exception {
							
				paramHttpServletResponse.setContentType(getContentType());
				
				ServletOutputStream out =	paramHttpServletResponse.getOutputStream();
				try
				{
					if(datas != null)
					{
						out.write(datas);
						out.flush();
						
					}
					
				}finally
				{
					if(out != null)
					{
						out.close();
					}
				}
				
			}
			
			@Override
			public String getContentType() {

				return ct;
			}
		};
		
	}
	

}
