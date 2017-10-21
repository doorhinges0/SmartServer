package com.dtsjy.mdboss.common.export;

import java.io.OutputStream;
import java.util.Iterator;

public interface Exportor {
	public void addOutputProperty(int propertyId, String propertyName,
            String format, String formatType,String style);

	public void writeTitle(OutputStream os, String[] title);
	
	public void write(OutputStream os, Iterator<?> itt, Class<?> vo);
	
	public void buildPages(ExportInfo info,OutputStream os);
	
	public void beforeWrite( OutputStream os );
    
	public void afterWrite( OutputStream os );
}
