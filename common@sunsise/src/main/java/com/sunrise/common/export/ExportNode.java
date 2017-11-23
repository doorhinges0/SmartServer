package com.sunrise.common.export;

import java.util.List;

public class ExportNode {
	private String id;
	private String outFileName;
	private List<String> refs;
	private String converter;
	public String getConverter() {
		return converter;
	}
	public void setConverter(String converter) {
		this.converter = converter;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOutFileName() {
		return outFileName;
	}
	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}
	public List<String> getRefs() {
		return refs;
	}
	public void setRefs(List<String> refs) {
		
		this.refs = refs;
	}
}
