package com.fuck.mobile.base.common;

import com.fuck.mobile.base.constant.Constants;

/**
 * 费用配置常量
 * @author yangyu
 *
 */
public class ConfigConstants {
	/**
	 * @category 充值手续费费率  为0时表示免费
	 */
	public static final String chargeFee = Constants.YunWei + "/feeconfig/chargefee";
	
	/**
	 * @category 最小充值金额 为0时表示不限金额
	 */
	public  static final  String minCharge =Constants.YunWei + "/feeconfig/minCharge";
	
	/**
	 * @category 最小充值单位
	 */
	public  static final  String minChargeUnit= Constants.YunWei + "/feeconfig/minChargeUnit";
	
	/**
	 * 每月免费提现笔数
	 */
	public  static final  String perMonthWithdraw= Constants.YunWei + "/feeconfig/perMonthWithdraw";
	
	/**
	 * @category  提现手续费用 为0时表示免费
	 */
	public  static final String withdrawFee= Constants.YunWei + "/feeconfig/withdrawFee";
	
	/**
	 * @category 提现免手续费的最大金额
	 */
	public  static final String withdrawFreeQuota= Constants.YunWei + "/feeconfig/withdrawFreeQuota";
	
	/**
	 * @category 最小提现金额 为0时表示不限金额
	 */
	public  static final  String minWithdraw =Constants.YunWei + "/feeconfig/minWithdraw";
	
	/**
	 * @category 收费方式 默认平台垫付
	 */
	public static final  String chargeMode= Constants.YunWei + "/feeconfig/chargeMode";
	
	/**
	 * @category 计划项目 为0时表示免费
	 */
	public  static final String planServiceCharge= Constants.YunWei + "/feeconfig/planServiceCharge";
	
	/**
	 * @category 定期理财项目 为0时表示免费
	 */
	public static final  String regularServiceCharge= Constants.YunWei + "/feeconfig/regularServiceCharge";
	
	/**
	 * @category 债权转让手 为0时表示免费
	 */
	public static final  String debtsServiceCharge=Constants.YunWei + "/feeconfig/debtsServiceCharge";
	
	/**
	 * @category 风险准备金 Collection party
	 */
	public static final  String riskreserve=Constants.YunWei + "/feeconfig/riskreserve";
	
	/**
	 * @category 风险准备金的收取方
	 */
	public static final  String collParty=Constants.YunWei + "/feeconfig/collparty";
	
	/**
	 * @category 债权转让最低溢价范围
	 */
	public static final String minPremium = Constants.YunWei + "/debtconfig/minPremium";
	
	/**
	 * @category 债权转让最大溢价范围
	 */
	public static final String maxPremium = Constants.YunWei + "/debtconfig/maxPremium";
	
	/**
	 * @category 当前天数小于
	 */
	public static final  String debtLimitDay = Constants.YunWei + "/debtconfig/debtLimitDay";
	
	/**
	 * @category 最小转让金额
	 */
	public static final  String minDebtAmt= Constants.YunWei + "/debtconfig/minDebtAmt";
	
	/**
	 * @category 起投金额
	 */
	public  static final String minInvestAmt=Constants.YunWei + "/debtconfig/minInvestAmt";
	
	/**
	 * @category 用户至少持有天数才可转让
	 */
	public  static final String holdLimitDay=Constants.YunWei + "/debtconfig/holdLimitDay";
	
	
	/**
	 * @category 每份金额
	 */
	public static final String eachAmt=Constants.YunWei + "/coomonconfig/eachAmt";
	
	/**
	 * @category 新计划最低分散程度
	 */
	public  static final String planMinDegree=Constants.YunWei + "/coomonconfig/planMinDegree";;
	
	/**
	 * 最低利率偏震幅度
	 */
	public  static final String minInterestRate=Constants.YunWei + "/coomonconfig/minInterestRate";;
	
	/**
	 * 最大利率偏震幅度
	 */
	public static final  String maxInterestRate=Constants.YunWei + "/coomonconfig/maxInterestRate";;
	
	/**
	 * @category 提前退出费用
	 */
	public  static final String quitAmtRate=Constants.YunWei + "/coomonconfig/quitAmtRate";;
	
	/**
	 * @category 资产优先级排序1
	 */
	public static final  String asset1=Constants.YunWei + "/coomonconfig/asset1";;
	
	/**
	 * @category 资产优先级排序2
	 */
	public static final  String asset2=Constants.YunWei + "/coomonconfig/asset2";;

	/**
	 * @category 资产优先级排序3
	 */
	public  static final String asset3=Constants.YunWei + "/coomonconfig/asset3";;

	/**
	 * @category 资产优先级排序4
	 */
	public  static final String asset4=Constants.YunWei + "/coomonconfig/asset4";;

	/**
	 * @category 系统自动匹配时间(小时)
	 */
	public static final  String autoMateHour=Constants.YunWei + "/coomonconfig/autoMateHour";;
	
	/**
	 * @category系统自动匹配时间(分钟)
	 */
	public static final  String autoMateMinute=Constants.YunWei + "/coomonconfig/autoMateMinute";;
	
	/**
	 * @category 置顶资产终审后(小时)
	 */
	public static final  String assetFinalHour=Constants.YunWei + "/coomonconfig/assetFinalHour";;
	/**
	 * @category 置顶资产终审后(分钟)
	 */
	public static final  String assetFinalMinute=Constants.YunWei + "/coomonconfig/assetFinalMinute";;
	
	/**
	 * @category 系统每日B1开始锁定匹配债权时间 (小时)
	 */
	public  static final String lockDebtHour=Constants.YunWei + "/coomonconfig/lockDebtHour";;
	
	/**
	 * @category 系统每日B1开始锁定匹配债权时间 (分钟)
	 */
	public  static final String lockDebtMinute=Constants.YunWei + "/coomonconfig/lockDebtMinute";;
	
	/**
	 * @category 资产优先级排序
	 */
	public static final  String assetB1=Constants.YunWei + "/coomonconfig/assetB1";;
	
	/**
	 * @category 资产优先级排序
	 */
	public static final  String assetB2=Constants.YunWei + "/coomonconfig/assetB2";;
	
	/**
	 * @category 自动匹配触发模式
	 */
	public  static final String autoTriggerMode=Constants.YunWei + "/coomonconfig/autoTriggerMode";;
}
