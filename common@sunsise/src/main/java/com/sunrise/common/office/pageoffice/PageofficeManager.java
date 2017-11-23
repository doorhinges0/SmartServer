package com.sunrise.common.office.pageoffice;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.common.model.SerialNoHolder4Rest;
import com.zhuozhengsoft.pageoffice.OpenModeType;

public class PageofficeManager {
	
	public static PageofficeController getControl(HttpServletRequest request,String fileType){
		return new PageofficeControllerImpl().init(request, fileType);
	}
	
	public static void openPdfNormal(PageofficeController control,String tagId,String filePath){
		// Create custom toolbar
		control.addCustomToolButton("打印", "Print()", 6);
		control.addCustomToolButton("隐藏/显示书签", "SetBookmarks()", 0);
		control.addCustomToolButton("-", "", 0);
		control.addCustomToolButton("实际大小", "SetPageReal()", 16);
		control.addCustomToolButton("适合页面", "SetPageFit()", 17);
		control.addCustomToolButton("适合宽度", "SetPageWidth()", 18);
		control.addCustomToolButton("-", "", 0);
		control.addCustomToolButton("首页", "FirstPage()", 8);
		control.addCustomToolButton("上一页", "PreviousPage()", 9);
		control.addCustomToolButton("下一页", "NextPage()", 10);
		control.addCustomToolButton("尾页", "LastPage()", 11);
		control.addCustomToolButton("-", "", 0);
	
		control.webOpen(filePath);
		control.setTagId("PDFCtrl1"); //此行必须
	}
	
	public static void readOnly(String filePath,String tagId,PageofficeController control){
		if (null != control){
			control.setAllowCopy(false);//禁止拷贝
			control.setMenubar(false);//隐藏菜单栏
			control.setOfficeToolbars(false);//隐藏Office工具条
			control.setCustomToolbar(false);//隐藏自定义工具栏
			control.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
			//设置页面的显示标题
			control.setCaption("文件在线安全浏览");
			
			//打开文件
			control.webOpen(filePath, OpenModeType.docReadOnly, SerialNoHolder4Rest.userCode.get());
			control.setTagId(tagId); //此行必须	
		}
	}
}
