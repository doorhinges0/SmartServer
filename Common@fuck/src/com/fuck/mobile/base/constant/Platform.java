
package com.fuck.mobile.base.constant;

public enum Platform {
	PC(0,"PC"),Android(1,"Android"),IOS(2,"IOS"),WeiXin(3,"WeiXin"),WAP(4,"WAP"),BACK_PC(5,"BACK_PC");

	private Integer value;

	private String desc;

	private Platform(Integer value,String desc){
		this.value = value;
		this.desc = desc;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static String getNameByValue(int value){
		String name = "";
		if(value== PC.getValue().intValue()){
			name = PC.getDesc();
		}else if(value== Android.getValue().intValue()){
			name = Android.getDesc();
		}else if(value== IOS.getValue().intValue()){
			name = IOS.getDesc();
		}else if(value== WeiXin.getValue().intValue()){
			name = WeiXin.getDesc();
		}else if(value== WAP.getValue().intValue()){
			name = WAP.getDesc();
		}else if(value== BACK_PC.getValue().intValue()){
			name = BACK_PC.getDesc();
		}
		return name;
	}
	
	
}
