package com.sunrise.common.office.pageoffice;

import java.awt.Color;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.common.utils.string.StringToolkit;
import org.apache.commons.lang.ArrayUtils;

import com.zhuozhengsoft.pageoffice.BorderStyleType;
import com.zhuozhengsoft.pageoffice.DocumentVersion;
import com.zhuozhengsoft.pageoffice.OfficeVendorType;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PDFCtrl;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.RibbonToolbar;
import com.zhuozhengsoft.pageoffice.ThemeType;

public class PageofficeControllerImpl implements PageofficeController {
	private static final String[] officeFile = new String[]{"doc","docx","xls","xlsx","ppt","pptx"};
	
	private String fileType;
	private PDFCtrl  pdfCtrl;
	private PageOfficeCtrl officeCtrl;
	
	public PageofficeController init(HttpServletRequest request, String fileType) {
		if (StringToolkit.isNotEmpty(fileType)){
			this.fileType = "docx";
		}
		
		if (isPdf(fileType)){
			pdfCtrl = new PDFCtrl(request);
			pdfCtrl.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
		}else if (isOffice(fileType)){
			officeCtrl = new PageOfficeCtrl(request);
			officeCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		}else {
			officeCtrl = new PageOfficeCtrl(request);
			officeCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		}
		
		return this;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
		
	}

	public String getFileType() {
		return fileType;
	}


	public void addCustomMenuItem(String caption, String jsFunction,
			boolean enabled) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.addCustomMenuItem(caption, jsFunction, enabled);
		}
	}

	public void addCustomToolButton(String caption, String jsFunction,
			int iconIndex) {
		if (null != pdfCtrl){
			pdfCtrl.addCustomToolButton(caption, jsFunction, iconIndex);
		}else {
			officeCtrl.addCustomToolButton(caption, jsFunction, iconIndex);
		}
	}

	public void setAllowCopy(boolean value) {
		if (null != pdfCtrl){
			pdfCtrl.setAllowCopy(value);
		}else {
			officeCtrl.setAllowCopy(value);
		}
	}

	public void setBorderColor(Color value) {
		if (null != pdfCtrl){
			pdfCtrl.setBorderColor(value);
		}else {
			officeCtrl.setBorderColor(value);
		}
	}

	public void setBorderStyle(BorderStyleType value) {
		if (null != pdfCtrl){
			pdfCtrl.setBorderStyle(value);
		}else {
			officeCtrl.setBorderStyle(value);
		}
	}

	public void setCaption(String value) {
		if (null != pdfCtrl){
			pdfCtrl.setCaption(value);
		}else {
			officeCtrl.setCaption(value);
		}
	}

	public void setCompressDocument(boolean value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setCompressDocument(value);
		}
	}

	public void setCustomMenuCaption(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setCustomMenuCaption(value);
		}
	}

	public void setCustomRibbon(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setCustomRibbon(value);
		}
	}

	public void setCustomToolbar(boolean value) {
		if (null != pdfCtrl){
			pdfCtrl.setCustomToolbar(value);
		}else {
			officeCtrl.setCustomToolbar(value);
		}
	}

	public void setEnableUserProtection(boolean value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setEnableUserProtection(value);
		}
	}

	public void setFileTitle(String value) {
		if (null != pdfCtrl){
			pdfCtrl.setFileTitle(value);
		}else {
			officeCtrl.setFileTitle(value);
		}
	}

	public void setHTTPBasic_Password(String value) {
		if (null != pdfCtrl){
			pdfCtrl.setHTTPBasic_Password(value);
		}else {
			officeCtrl.setHTTPBasic_Password(value);
		}
	}

	public void setHTTPBasic_UserName(String value) {
		if (null != pdfCtrl){
			pdfCtrl.setHTTPBasic_UserName(value);
		}else {
			officeCtrl.setHTTPBasic_UserName(value);
		}
	}

	public void setJsFunction_AfterDocumentClosed(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_AfterDocumentClosed(value);
		}
	}

	public void setJsFunction_AfterDocumentOpened(String value) {
		if (null != pdfCtrl){
			pdfCtrl.setJsFunction_AfterDocumentOpened(value);
		}else {
			officeCtrl.setJsFunction_AfterDocumentOpened(value);
		}
	}

	public void setJsFunction_AfterDocumentSaved(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_AfterDocumentSaved(value);
		}
	}

	public void setJsFunction_BeforeDocumentClosed(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_BeforeDocumentClosed(value);
		}
	}

	public void setJsFunction_BeforeDocumentSaved(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_BeforeDocumentSaved(value);
		}
	}

	public void setJsFunction_OnExcelCellClick(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_OnExcelCellClick(value);
		}
	}

	public void setJsFunction_OnWordDataRegionClick(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setJsFunction_OnWordDataRegionClick(value);
		}
	}

	public void setMenubar(boolean value) {
		if (null != pdfCtrl){
			pdfCtrl.setMenubar(value);
		}else {
			officeCtrl.setMenubar(value);
		}
	}

	public void setMenubarColor(Color value) {
		if (null != pdfCtrl){
			pdfCtrl.setMenubarColor(value);
		}else {
			officeCtrl.setMenubarColor(value);
		}
	}

	public void setMenubarTextColor(Color value) {
		if (null != pdfCtrl){
			pdfCtrl.setMenubarTextColor(value);
		}else {
			officeCtrl.setMenubarTextColor(value);
		}
	}

	public void setOfficeToolbars(boolean value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setOfficeToolbars(value);
		}
	}

	public void setOfficeVendor(OfficeVendorType value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setOfficeVendor(value);
		}
	}

	public void setProtectPassword(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setProtectPassword(value);
		}
	}

	public void setSaveDataPage(String saveDataPage) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setSaveDataPage(saveDataPage);
		}
	}

	public void setSaveFileMaxSize(int value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setSaveFileMaxSize(value);
		}
	}

	public void setSaveFilePage(String saveFilePage) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setSaveFilePage(saveFilePage);
		}
	}

	public void setServerPage(String serverPage) {
		if (null != pdfCtrl){
			pdfCtrl.setServerPage(serverPage);
		}else {
			officeCtrl.setServerPage(serverPage);
		}
	}

	public void setTagId(String id) {
		if (null != pdfCtrl){
			pdfCtrl.setTagId(id);
		}else {
			officeCtrl.setTagId(id);
		}
	}

	public void setTheme(ThemeType value) {
		if (null != pdfCtrl){
			pdfCtrl.setTheme(value);
		}else {
			officeCtrl.setTheme(value);
		}
	}

	public void setTimeSlice(int value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setTimeSlice(value);
		}
	}

	public void setTitlebar(boolean value) {
		if (null != pdfCtrl){
			pdfCtrl.setTitlebar(value);
		}else {
			officeCtrl.setTitlebar(value);
		}
	}

	public void setTitlebarColor(Color value) {
		if (null != pdfCtrl){
			pdfCtrl.setTitlebarColor(value);
		}else {
			officeCtrl.setTitlebarColor(value);
		}
	}

	public void setTitlebarTextColor(Color value) {
		if (null != pdfCtrl){
			pdfCtrl.setTitlebarTextColor(value);
		}else {
			officeCtrl.setTitlebarTextColor(value);
		}
	}

	public void setVisible(boolean value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setVisible(value);
		}
	}

	public void setWriter(Object writerObj) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setWriter(writerObj);
		}
	}

	public void setZoomSealServer(String value) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.setZoomSealServer(value);
		}
	}

	public void webCreateNew(String userName, DocumentVersion docVersion) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.webCreateNew(userName,docVersion);
		}
	}

	public void webOpen(String documentURL, OpenModeType openMode,
			String userName) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.webOpen(documentURL, openMode, userName);
		}
	}

	public void wordCompare(String documentURL, String documentURL2,
			OpenModeType openMode, String userName) {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			officeCtrl.wordCompare(documentURL,documentURL2,openMode,userName);
		}
	}

	public RibbonToolbar getRibbonBar() {
		if (null != pdfCtrl){
			throw new UnsupportedOperationException();
		}else {
			return officeCtrl.getRibbonBar();
		}
	}

	public void webOpen(String documentURL) {
		if (null != pdfCtrl){
			pdfCtrl.webOpen(documentURL);
		}else {
			throw new UnsupportedOperationException();
		}
	}
	
	private boolean isPdf(String fileType){
		return "pdf".equalsIgnoreCase(this.fileType);
	}
	
	private boolean isOffice(String fileType){
		return ArrayUtils.contains(officeFile, this.fileType);
	}
}
