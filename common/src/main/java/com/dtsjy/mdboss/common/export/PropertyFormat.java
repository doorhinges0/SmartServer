package com.dtsjy.mdboss.common.export;

public class PropertyFormat {
	public PropertyFormat(int propertyId, String propertyName, String format,
			String formatType, String style) {
		this.propertyName = propertyName;
		this.format = format;
		this.formatType = formatType;
		this.propertyId = propertyId;
		this.style = style;
	}

	int propertyId;

	String propertyName;

	String format;

	String formatType;

	String style;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
