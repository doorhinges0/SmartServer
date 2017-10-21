package com.dtsjy.mdboss.common.office.pageoffice;

import javax.servlet.http.HttpServletRequest;

import com.zhuozhengsoft.pageoffice.BorderStyleType;
import com.zhuozhengsoft.pageoffice.DocumentVersion;
import com.zhuozhengsoft.pageoffice.OfficeVendorType;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.RibbonToolbar;
import com.zhuozhengsoft.pageoffice.ThemeType;

public interface PageofficeController {

	public PageofficeController  init(HttpServletRequest request,String fileType);

	public void setFileType(String fileType);

	public String getFileType();

	/** PageofficeCtrl的方法 **/
	/** 添加菜单项到自定义菜单。**/
	public void addCustomMenuItem(String caption, String jsFunction,
			boolean enabled);

	/** 添加按钮到自定义工具栏。**/
	public void addCustomToolButton(String caption, String jsFunction,
			int iconIndex);

	/** 设置当前文档是否允许复制、粘贴的功能。**/
	public void setAllowCopy(boolean value);

	/** 设置 PageOfficeCtrl 控件的边框颜色。**/
	public void setBorderColor(java.awt.Color value);

	/** 设置 PageOfficeCtrl 控件的边框样式。**/
	public void setBorderStyle(BorderStyleType value);

	/** 设置 PageOfficeCtrl 控件标题栏文字。**/
	public void setCaption(String value);

	/** 设置控件在保存文档时是否使用压缩。**/
	public void setCompressDocument(boolean value);

	/** 设置自定义菜单的标题。**/
	public void setCustomMenuCaption(String value);

	/** 自定义Office2007/2010的Ribbon工具栏。**/
	public void setCustomRibbon(String value);

	/** 设置 PageOfficeCtrl 控件是否显示自定义工具栏。**/
	public void setCustomToolbar(boolean value);

	/** 表示是否启用用户自己设置的文档保护。**/
	public void setEnableUserProtection(boolean value);

	/** 设置控件客户端弹出的“另存为”对话框的默认文件名。**/
	public void setFileTitle(String value);

	/** 打开或保存文档时要求 HTTP Basic 验证的用户密码。**/
	public void setHTTPBasic_Password(String value);

	/** 打开或保存文档时要求 HTTP Basic 验证的用户名。**/
	public void setHTTPBasic_UserName(String value);

	/** 定义一个 JavaScript 函数响应 AfterDocumentClosed 事件。**/
	public void setJsFunction_AfterDocumentClosed(String value);

	/** 定义一个 JavaScript 函数响应 AfterDocumentOpened 事件。**/
	public void setJsFunction_AfterDocumentOpened(String value);

	/** 定义一个 JavaScript 函数响应 AfterDocumentSaved 事件。**/
	public void setJsFunction_AfterDocumentSaved(String value);

	/** 定义一个 JavaScript 函数响应 BeforeDocumentClosed 事件。**/
	public void setJsFunction_BeforeDocumentClosed(String value);

	/** 定义一个 JavaScript 函数响应 BeforeDocumentSaved 事件。**/
	public void setJsFunction_BeforeDocumentSaved(String value);

	/** 定义一个 JavaScript 函数响应 OnExcelCellClick 事件。**/
	public void setJsFunction_OnExcelCellClick(String value);

	/** 定义一个 JavaScript 函数响应 OnWordDataRegionClick 事件。**/
	public void setJsFunction_OnWordDataRegionClick(String value);

	/** 设置 PageOfficeCtrl 控件是否显示菜单栏。**/
	public void setMenubar(boolean value);

	/** 设置控件的菜单栏颜色。**/
	public void setMenubarColor(java.awt.Color value);

	/** 设置控件菜单栏的文字颜色。**/
	public void setMenubarTextColor(java.awt.Color value);

	/** 设置 PageOfficeCtrl 控件是否显示Office工具栏。**/
	public void setOfficeToolbars(boolean value);

	/** 设置Office办公软件类型。**/
	public void setOfficeVendor(OfficeVendorType value);

	/** 设置当前Word或Excel文档使用的保护密码。**/
	public void setProtectPassword(String value);

	/** 设置 PageOffice 控件的数据保存页面。**/
	public void setSaveDataPage(String saveDataPage);

	/** 设置控件能够保存最大文档的大小，以字节为单位。**/
	public void setSaveFileMaxSize(int value);

	/** 设置 PageOffice 控件的文档保存页面。**/
	public void setSaveFilePage(String saveFilePage);

	/** 设置 PageOfficeCtrl 控件的运行服务页面。**/
	public void setServerPage(String serverPage);

	/** 此方法非常重要，在PageOfficeCtrl的后台Java调用代码末尾处必须调用。**/
	public void setTagId(String id);

	/** 设置 PageOfficeCtrl 控件的界面主题。**/
	public void setTheme(ThemeType value);

	/** 设置文档并发控制的时间片，以分钟为单位。**/
	public void setTimeSlice(int value);

	/** 设置 PageOfficeCtrl 控件是否显示标题栏。**/
	public void setTitlebar(boolean value);

	/** 设置控件的标题栏颜色。**/
	public void setTitlebarColor(java.awt.Color value);

	/** 设置控件标题栏的文字颜色。**/
	public void setTitlebarTextColor(java.awt.Color value);

	/** 设置控件运行时是否可见。**/
	public void setVisible(boolean value);

	/** 设置 PageOfficeCtrl 控件的数据对象。**/
	public void setWriter(Object writerObj);

	/** 设置当前网站以外的ZoomSeal管理系统的印章服务地址。**/
	public void setZoomSealServer(String value);

	/** 创建一个新文档并以普通编辑方式在线打开此文档。**/
	public void webCreateNew(String userName, DocumentVersion docVersion);

	/** 在线打开Office文档。**/
	public void webOpen(String documentURL, OpenModeType openMode,
			String userName);

	/** 在线比较两个不同版本的Word文档。**/
	public void wordCompare(String documentURL, String documentURL2,
			OpenModeType openMode, String userName);

	public RibbonToolbar getRibbonBar();
	
	/**用于打开pdf文档**/
	public void webOpen(String documentURL);
	/** PdfCtrl的方法 **/
	
}
