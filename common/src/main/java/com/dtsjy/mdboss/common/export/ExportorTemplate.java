package com.dtsjy.mdboss.common.export;

import java.io.OutputStream;
import java.util.Iterator;

public abstract class ExportorTemplate implements Exportor {

	public void addOutputProperty(int propertyId, String propertyName,
			String format, String formatType, String style) {
		// TODO Auto-generated method stub

	}

	public void writeTitle(OutputStream os, String[] title) {
		// TODO Auto-generated method stub

	}

	public void buildPages(ExportInfo info, OutputStream os) {
		
		
	}
	
	public void write(OutputStream os, Iterator<?> itt, Class<?> vo) {
		// TODO Auto-generated method stub

	}

	public void beforeWrite(OutputStream os) {
		// TODO Auto-generated method stub

	}

	public void afterWrite(OutputStream os) {
		// TODO Auto-generated method stub

	}

}
