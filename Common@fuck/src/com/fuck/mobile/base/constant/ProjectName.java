package com.fuck.mobile.base.constant;

public enum ProjectName {
	
	//用户系统
	UserApp("1000","UserApp","com.fuck","用户服务模块"),
	UserSchedule("1001","UserSchedule","com.fuck","用户消息模块"),
	UserWeb("1002","UserWeb","com.fuck","用户前端模块"),
	UserAdminWeb("1003","UserAdminWeb","com.fuck","用户后台模块"),
	
	//PC web
	PCWeb("1100","PCWeb","com.fuck","PC前端模块"),
	
	//APP
	MobileWeb("1200","MobileWeb","com.fuck","手机接口模块"),
	MobileAdminWeb("1201","MobileAdminWeb","com.fuck","手机端后台模块"),
	
	//账户
	AccountApp("1300","AccountApp","com.fuck","账户服务模块"),
	AccountAdminWeb("1301","AccountAdminWeb","com.fuck","账户后台管理模块"),
	AccountWeb("1302","AccountWeb","com.fuck","账户管理模块"),
	
	//托管
	TrusteeApp("1400","TrusteeApp","com.fuck","托管服务模块"),
	TrusteeWeb("1401","TrusteeWeb","com.fuck","托管前端模块"),
	TrusteeSchedule("1402","TrusteeSchedule","com.fuck","托管消息模块"),
	TrusteeAdminweb("1403","TrusteeAdminweb","com.fuck","托管系统运营后台"),
	
	//支付
	PaymentApp("1500","PaymentApp","com.fuck","支付服务模块"),
	PaymentCallBackWeb("1501","PaymentCallBackWeb","com.fuck","支付回调模块"),
	PaymentAdminWeb("1502","PaymentAdminWeb","com.fuck","支付后台模块"),
	
	//资产
	AssetAdminWeb("1602","AssetAdminWeb","com.fuck","资产后台管理模块"),
	AssetApp("1603","AssetApp","com.fuck","资产服务模块"),
	AssetWeb("1604","AssetWeb","com.fuck","资产服务前端模快"),
	AssetSchedule("1605","AssetSchedule","com.fuck","资产服务定时任务"),

	//产品
	ProductApp("1700","ProductApp","com.fuck","产品服务模块"),
	ProductWeb("1701","ProductWeb","com.fuck","产品服务前端模快"),
	ProductAdminWeb("1702","ProductAdminWeb","com.fuck","产品后台模块"),
	ProductSchedule("1703","ProductSchedule","com.fuck","产品定时任务"),
	
	//市场
	MarketApp("1800","MarketApp","com.fuck","市场服务模块"),
	MarketCoopWeb("1801","MarketCoopWeb","com.fuck","市场前端模块"),
	MarketThirdPartWeb("1802","MarketThirdPartWeb","com.fuck","市场第三方模块"),
	MarketAdminWeb("1803","MarketAdminWeb","com.fuck","市场后台模块"),
	MarketSchedule("1804","MarketSchedule","com.fuck","市场定时任务"),
	
	
	//id
	IDApp( "1900","IDApp","com.fuck","ID模块"),
	
	//消息
	MessageApp("2000","MessageApp","com.fuck","消息服务模块"),
	MessageAdminWeb("2001","MessageAdmin","com.fuck","消息后台模块"),
	
	//内容
	CMSApp("2100","CMSApp","com.fuck","内容服务"),
	CMSWeb("2101","CMSWeb","com.fuck","内容服务前端"),
	CMSAdminWeb("2102","CMSAdminWeb","com.fuck","内容后台管理"),
	
	//奖励系统
	RewardApp("2200","RewardApp","com.fuck","奖励系统服务"),
	RewardWeb("2201","RewardWeb","com.fuck","奖励系统前端"),
	RewardAdminWeb("2202","RewardAdminWeb","com.fuck","奖励系统后台管理"),
	RewardSchedule("2203","RewardSchedule","com.fuck","奖励系统定时任务"),

	//奖励系统
	FinancialPlanApp("2300","FinancialPlanApp","com.fuck","理财计划匹配模块"),

	//活动系统
	ActivityApp("2400","ActivityApp","com.fuck","活动系统服务"),
	ActivityAdminWeb("2401","ActivityAdminWeb","com.fuck","活动系统后台管理"),
	ActivitySchedule("2402","ActivitySchedule","com.fuck","活动系统定时任务"),
	
	WapWeb("2500","WapWeb","com.fuck","WAP系统前端"),
	
	//后台
	AdminApp("9000","AdminApp","com.fuck","后台服务模块"),
	AdminWeb("9001","AdminWeb","com.fuck","后台管理模块"),
	AdminZKWeb("9002","AdminZKWeb","com.fuck","配置管理模块"),
	
	Common("8888","Common","com.fuck","公用模块"),
	;
	
	private String appId;
	private String appName;
	private String packageName;
	private String projectName;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	private ProjectName(String  appId,String appName,String packageName,String projectName){
		this.appId = appId;
		this.appName = appName;
		this.packageName = packageName;
		this.projectName = projectName;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppName() {
		return appName;
	}
	public String getPackageName() {
		return packageName;
	}

}
