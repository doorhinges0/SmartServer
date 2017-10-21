package com.dtsjy.mdboss.common.export;

import java.util.List;
import java.util.Map;

public class ExportInfo {
	private long startindex;
	private long endindex;
	private List<String> fieldList;
	private Class<?> voClass;
	public String[] title = null;
    public String headtitle = null;
    public String endTitle = null;
    public List<PropertyFormat> ouputProperties;
    public Map<String, PropertyFormat> outputPropertiesMap;
    public int rowCount = 0;
    protected String fileName ;
    protected String filetype = "TXT" ;
	
	//
    public static String encodeKey;
	private static Class[] NUMTYPES = new Class[] { Integer.class, Long.class,
		Double.class, Float.class, Byte.class, Short.class };

	private final static String NUMBER_FORMAT = "NUMBER";
	
	private final static String DATE_FORMAT = "DATE";
	
	private final static String CODE2NAME_FORMAT = "CODE2NAME";
	
	private final static String STRING_FORMAT = null;
	
	private final static String NUMBER_FORMATTYPE = "#.##";
	
	private final static String DATE_FORMATTYPE = "yyyy-MM-dd hh:mm:ss";
	
	private final static String CODE2NAME_FORMATTYPE = null;
	
	private final static String NUMBER_CODE2NAME_FORMATTYPE = "0";
	
	private final static String STRING_FORMATTYPE = null;
	
	
	////
	private static final String XML_EXCEL_HEAD = new StringBuffer(
			"<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n")
			.append("<?mso-application progid=\"Excel.Sheet\"?>\r\n")
			.append(
					"<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"\r\n")
			.append(" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\r\n")
			.append(" xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\r\n")
			.append(
					" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"\r\n")
			.append(" xmlns:html=\"http://www.w3.org/TR/REC-html40\">\r\n")
			.append(
					" <DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">\r\n")
			.append("  <LastAuthor>{0}</LastAuthor>\r\n")
			.append("  <Created>{1,date,yyyy-MM-dd' 'hh:mm:ss}</Created>\r\n")
			.append("  <Version>11.8132</Version>\r\n")
			.append(" </DocumentProperties>\r\n")
			.append(
					" <OfficeDocumentSettings xmlns=\"urn:schemas-microsoft-com:office:office\">\r\n  <RemovePersonalInformation/>\r\n</OfficeDocumentSettings>\r\n")
			.append(
					" <ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">\r\n")
			.append(" <WindowHeight>9570</WindowHeight>\r\n")
			.append("  <WindowWidth>18195</WindowWidth>\r\n")
			.append("  <WindowTopX>480</WindowTopX>\r\n")
			.append("  <WindowTopY>120</WindowTopY>\r\n")
			.append("  <ProtectStructure>False</ProtectStructure>\r\n")
			.append("  <ProtectWindows>False</ProtectWindows>\r\n")
			.append(" </ExcelWorkbook>\r\n")
			.append(" <Styles>\r\n")
			.append("  <Style ss:ID=\"Default\" ss:Name=\"Normal\">\r\n")
			.append("   <Alignment ss:Vertical=\"Center\"/>\r\n")
			.append("   <Borders/>\r\n")
			.append(
					"   <Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"12\"/>\r\n")
			.append("   <Interior/>\r\n")
			.append("   <NumberFormat/>\r\n")
			.append("   <Protection/>\r\n")
			.append("  </Style>\r\n")
			.append("  <Style ss:ID=\"s22\">\r\n")
			.append(
					"   <Alignment ss:Horizontal=\"Center\" ss:Vertical=\"Center\" ss:WrapText=\"1\"/>\r\n")
			.append(
					"   <Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"9\" ss:Color=\"#000000\"/>\r\n")
			.append(
					"   <Interior ss:Color=\"#FFFFFF\" ss:Pattern=\"Solid\"/>\r\n")
			.append("   <NumberFormat ss:Format=\"@\"/>\r\n")
			.append("  </Style>\r\n")
			.append("  <Style ss:ID=\"s23\">\r\n")
			.append(
					"   <Alignment ss:Horizontal=\"Left\" ss:Vertical=\"Center\" ss:WrapText=\"1\"/>\r\n")
			.append(
					"   <Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"9\" ss:Color=\"#000000\"/>\r\n")
			.append(
					"   <Interior ss:Color=\"#FFFFFF\" ss:Pattern=\"Solid\"/>\r\n")
			.append("   <NumberFormat ss:Format=\"@\"/>\r\n")
			.append("  </Style>\r\n")
			.append("  <Style ss:ID=\"s25\">\r\n")
			.append(
					"   <Alignment ss:Horizontal=\"Center\" ss:Vertical=\"Center\" ss:WrapText=\"1\"/>\r\n")
			.append("   <Borders>\r\n")
			.append(
					"    <Border ss:Position=\"Bottom\" ss:LineStyle=\"Continuous\" ss:Weight=\"1\" ss:Color=\"#969696\"/>\r\n")
			.append(
					"    <Border ss:Position=\"Left\" ss:LineStyle=\"Continuous\" ss:Weight=\"1\"  ss:Color=\"#969696\"/>\r\n")
			.append(
					"    <Border ss:Position=\"Right\" ss:LineStyle=\"Continuous\" ss:Weight=\"1\" ss:Color=\"#969696\"/>\r\n")
			.append(
					"    <Border ss:Position=\"Top\" ss:LineStyle=\"Continuous\" ss:Weight=\"1\" ss:Color=\"#969696\"/>\r\n")
			.append("   </Borders>\r\n")
			.append(
					"   <Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"9\" ss:Color=\"#000000\"/>\r\n")
			.append(
					"   <Interior ss:Color=\"#FFFFFF\" ss:Pattern=\"Solid\"/>\r\n")
			.append("   <NumberFormat ss:Format=\"@\"/>\r\n").append(
					"  </Style>\r\n").append(" </Styles>\r\n").toString();
	
	protected static final String EXCEL_HEAD = "<head>\r\n" +
    		"	<meta http-equiv=Content-Type content=\"text/html; charset=GBK\">\r\n" +
    		"	<meta name=ProgId content=Excel.Sheet>\r\n" +
    		"	<meta name=Generator content=\"Microsoft Excel 11\">\r\n" +
    		"</head>\r\n" +
    		"<style>\r\n" +
    		"td {\r\n" +
    		"	border:#a8a8a8 soild 1px;\r\n" +
    		"	color:#000;\r\n" +
    		"	font-size:12px;\r\n" +
    		"	text-align:center;\r\n" +
    		"	background:#FFFFFF;\r\n" +
    		"	mso-number-format:\"\\@\";\r\n" +
    		"}\r\n" +
    		"</style>\r\n";
	
	
	
	public long getStartindex() {
		return startindex;
	}
	public void setStartindex(long startindex) {
		this.startindex = startindex;
	}
	public long getEndindex() {
		return endindex;
	}
	public void setEndindex(long endindex) {
		this.endindex = endindex;
	}
	public List<String> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}
	public Class<?> getVoClass() {
		return voClass;
	}
	public void setVoClass(Class<?> voClass) {
		this.voClass = voClass;
	}
	
	
}
