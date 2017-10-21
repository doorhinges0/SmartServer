package com.dtsjy.mdboss.common.validate;

import hbm.jsonvalidate.ValidateRule;
import hbm.jsonvalidate.ValidateSet;
import hbm.jsonvalidate.Validator;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Payload;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.hibernate.validator.internal.constraintvalidators.DigitsValidatorForCharSequence;
import org.hibernate.validator.internal.constraintvalidators.DigitsValidatorForNumber;
import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.hibernate.validator.internal.constraintvalidators.LengthValidator;
import org.hibernate.validator.internal.constraintvalidators.MaxValidatorForNumber;
import org.hibernate.validator.internal.constraintvalidators.MinValidatorForNumber;
import org.hibernate.validator.internal.constraintvalidators.ParameterScriptAssertValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.model.constants.CommonModel;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.services.CommonService;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.JsonResponseUtils;
import com.dtsjy.mdboss.common.utils.date.DatePattern;
import com.dtsjy.mdboss.common.utils.date.DateToolkit;
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.log.LogUtils;
import com.dtsjy.mdboss.common.utils.pattern.PatternToolkit;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.common.utils.validate.ValidateUtils;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UserVO;

/*
 * 校验基类，保存一些通用的校验方法（校验不通过返回false）
 */
@ValidateSet(rules={
		@ValidateRule(attr = "usercode", methods = "notEmpty", message = "用户编码不能为空！")
	})
public class BaseValidator implements Validator {

	Logger log = LoggerFactory.getLogger(BaseValidator.class);

	// 校验value不为null，如果是null，返回false
	public Boolean notNull(Object value, String context) {
		return value != null;
	}
	
	public boolean notEmpty(Object value,String context){
		return !StringToolkit.isEmpty(value);
	}


	/**
	 * 检验字符是否为空字符串。
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean notBlank(Object value, String context) {
		if (null == value) {
			return false;
		}

		return value.toString().trim().length() > 0;
	}
	
	// 校验value是否为邮箱格式,空值返回true
	public boolean email(Object value, String context) {
		return new EmailValidator().isValid(value.toString(), null);
	}

	// 校验value是否为手机号码格式,空值返回true
	public boolean mobile(Object value, String context) {
		return null == value ? false : ValidateUtils.isMobile(value.toString());
	}

	// 校验value是否为座机号码格式,空值返回true
	public boolean phone(Object value, String context) {
		return null == value ? false : ValidateUtils.isPhone(value.toString());
	}

	// 校验value为null，如果是null，返回true
	public boolean isNull(Object value, String context) {
		return null == value;
	}

	// 当value不为null，且为字符串 false（不区分大小写）时，返回true; 其它情况返回false
	public boolean assertFalse(Object value, String context) {
		return ((value != null) && value.toString().equalsIgnoreCase("false"));
	}

	// 当value不为null，且为字符串 true（不区分大小写）时，返回true; 其它情况返回false
	public boolean assertTrue(Object value, String context) {
		return ((value != null) && value.toString().equalsIgnoreCase("true"));
	}

	/**
	 * 检验value是否小于或等于context中指定的max属性的数值。
	 * 当context为空或value为null时，返回真；当value小于或等于max时，返回 真。
	 * 
	 * @param value
	 * @param context
	 *            json格式的字符串 max指定比较值，inclusive指定比较时是否包括比较值。
	 * @return
	 */
	public boolean decimalMax(Object value, String context) {
		if (value == null || !StringToolkit.isValuedString(context)) {
			return true;
		}

		try {
			JSONObject json = JSON.parseObject(context);
			BigDecimal max = json.getBigDecimal("max");
			boolean inclusive = json.getBooleanValue("inclusive");
			int comparisonResult = new BigDecimal(value.toString())
					.compareTo(max);
			return inclusive ? comparisonResult <= 0 : comparisonResult < 0;
		} catch (Exception nfe) {
			log.error(nfe.getMessage());
			return false;
		}
	}

	public boolean decimalMin(Object value, String context) {
		if (value == null || !StringToolkit.isValuedString(context)) {
			return true;
		}

		try {
			JSONObject json = JSON.parseObject(context);
			BigDecimal max = json.getBigDecimal("max");
			boolean inclusive = json.getBooleanValue("inclusive");
			int comparisonResult = new BigDecimal(value.toString())
					.compareTo(max);
			return inclusive ? comparisonResult >= 0 : comparisonResult > 0;
		} catch (Exception nfe) {
			log.error(nfe.getMessage());
			return false;
		}
	}

	/**
	 * 校验value小于或等于某number值
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean numMax(Object value, String context) {
		if (value == null || !StringToolkit.isValuedString(context)) {
			return true;
		}
		try {
			JSONObject json = JSON.parseObject(context);
			final long max = json.getLongValue("max");
			Max maxValue = new Max() {

				public Class<? extends Annotation> annotationType() {
					return null;
				}

				public long value() {
					return max;
				}

				public Class<? extends Payload>[] payload() {
					return null;
				}

				public String message() {
					return null;
				}

				public Class<?>[] groups() {
					return null;
				}
			};

			MaxValidatorForNumber validator = new MaxValidatorForNumber();
			validator.initialize(maxValue);
			return validator.isValid((Number) value, null);
		} catch (Exception nfe) {
			log.error(nfe.getMessage());
			return false;
		}
	}

	/**
	 * 校验value大于或等于某number值
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean numMin(Object value, String context) {
		if (value == null || !StringToolkit.isValuedString(context)) {
			return true;
		}
		try {
			JSONObject json = JSON.parseObject(context);
			final long min = json.getLongValue("min");
			Min minValue = new Min() {

				public Class<? extends Annotation> annotationType() {
					return null;
				}

				public long value() {
					return min;
				}

				public Class<? extends Payload>[] payload() {
					return null;
				}

				public String message() {
					return null;
				}

				public Class<?>[] groups() {
					return null;
				}
			};

			MinValidatorForNumber validator = new MinValidatorForNumber();
			validator.initialize(minValue);
			return validator.isValid((Number) value, null);
		} catch (Exception nfe) {
			log.error(nfe.getMessage());
			return false;
		}
	}

	/**
	 * 基于perl5正则表工语法，检验value。当value匹配正则表达式时，返回真，否则返回假。
	 * 
	 * @param value
	 * @param context
	 *            json格式字符串，其中属性"regx"配置用于检验的正则表达式
	 * @return
	 */
	public boolean pattern(Object value, String context) {
		if (null == value) {
			return true;
		}
		try {
			JSONObject json = JSON.parseObject(context);
			String regx = json.getString("regx");
			return PatternToolkit.matches(value.toString(), regx);
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	/**
	 * 判断value是否为指定精度的浮点数。
	 * 
	 * @param value
	 * @param context
	 *            maxIntegerLength指定整数部分的最大长度，maxFractionLength指定小数部分的最大长度，
	 *            这两个数皆不能小于0.
	 * @return
	 */
	public boolean digits(Object value, String context) {
		if (null == value) {
			return true;
		}

		try {
			JSONObject json = JSON.parseObject(context);
			final int maxIntegerLength = json.getIntValue("maxIntegerLength");
			final int maxFractionLength = json.getIntValue("maxFractionLength");
			Digits constraintAnnotation = new Digits() {
				public Class<? extends Annotation> annotationType() {
					return null;
				}

				public Class<? extends Payload>[] payload() {
					return null;
				}

				public String message() {
					return "";
				}

				public int integer() {
					return maxIntegerLength;
				}

				public Class<?>[] groups() {
					return null;
				}

				public int fraction() {
					return maxFractionLength;
				}
			};

			if (value instanceof Number) {
				DigitsValidatorForNumber validator = new DigitsValidatorForNumber();
				validator.initialize(constraintAnnotation);
				return validator.isValid((Number) value, null);
			} else {
				DigitsValidatorForCharSequence validator = new DigitsValidatorForCharSequence();
				validator.initialize(constraintAnnotation);
				return validator.isValid(value.toString(), null);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}


	/**
	 * 检验脚本
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean parameterScriptAsser(Object value, String context) {
		if (null == value) {
			return true;
		}

		try {
			ParameterScriptAssertValidator validator = new ParameterScriptAssertValidator();
			JSONObject json = JSON.parseObject(context);
			final String script = json.getString("script");
			final String lang = json.getString("lang");
			//
			if (!StringToolkit.isValuedString(script)
					|| !StringToolkit.isValuedString(lang)) {
				return true;
			}

			ParameterScriptAssert constraintAnnotation = new ParameterScriptAssert() {
				public Class<? extends Annotation> annotationType() {
					return null;
				}

				public String script() {
					return script;
				}

				public Class<? extends Payload>[] payload() {
					return null;
				}

				public String message() {
					return "";
				}

				public String lang() {
					return lang;
				}

				public Class<?>[] groups() {
					return null;
				}
			};

			validator.initialize(constraintAnnotation);

			Object[] arguments = null;
			if (value.getClass().isArray()) {
				arguments = (Object[]) value;
			} else {
				arguments = new Object[] { value };
			}

			return validator.isValid(arguments, null);
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	/**
	 * 判断参数value指定的日期是否在context指定的日期之前(context为空时，则与当前时刻作比较）
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean past(Object value, String context) {
		if (null == value) {
			return true;
		}

		try {
			Date date = null;
			JSONObject json = JSON.parseObject(context);
			String dateTimeString = json.getString("dateTimeString");// dateTimeString必须符合yyyy-mm-dd
																		// HH:mm:ss格式
			if (StringToolkit.isValuedString(dateTimeString)) {
				date = DateToolkit.utilStrToDate(dateTimeString,
						DatePattern._YYYYMMDDHHMISS.toString());
			} else {
				date = new Date();
			}

			Date valueDate = null;
			if (value instanceof Date) {
				valueDate = (Date) value;
			} else {
				valueDate = DateToolkit.utilStrToDate(value.toString(),
						DatePattern._YYYYMMDDHHMISS.toString());
			}

			return valueDate.before(date);
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}

	}

	/**
	 * 判断参数value指定的日期是否在context指定的日期之后(context为空时，则与当前时刻作比较）
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean future(Object value, String context) {
		if (null == value) {
			return true;
		}

		try {
			Date date = null;
			JSONObject json = JSON.parseObject(context);
			String dateTimeString = json.getString("dateTimeString");// dateTimeString必须符合yyyy-mm-dd
																		// HH:mm:ss格式
			if (StringToolkit.isValuedString(dateTimeString)) {
				date = DateToolkit.utilStrToDate(dateTimeString,
						DatePattern._YYYYMMDDHHMISS.toString());
			} else {
				date = new Date();
			}

			Date valueDate = null;
			if (value instanceof Date) {
				valueDate = (Date) value;
			} else {
				valueDate = DateToolkit.utilStrToDate(value.toString(),
						DatePattern._YYYYMMDDHHMISS.toString());
			}

			return valueDate.after(date);
		} catch (Exception e) {
			LogUtils.error(log,e.getMessage());
			return false;
		}

	}

	/**
	 * 检验value字符串的长度在min与max之间（包括min与max)
	 * 
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean length(Object value, String context) {
		if (null == value) {
			return true;
		}

		try {
			LengthValidator validator = new LengthValidator();
			JSONObject json = JSON.parseObject(context);
			final int max = json.getIntValue("max");
			final int min = json.getIntValue("min");

			Length constraintAnnotation = new Length() {

				public Class<? extends Annotation> annotationType() {
					return null;
				}

				public Class<? extends Payload>[] payload() {
					return null;
				}

				public int min() {
					return min;
				}

				public String message() {
					return null;
				}

				public int max() {
					return max;
				}

				public Class<?>[] groups() {
					return null;
				}
			};

			validator.initialize(constraintAnnotation);

			return validator.isValid(value.toString(), null);
		} catch (Exception e) {
			LogUtils.error(log,e.getMessage());
			return false;
		}
	}
	
	/**
	 * 检验value是否是有效的固定参数值（UCP_DICT_DICTITEM.dictcode）
	 * @param value 入参
	 * @param context 属性defition的值指定字典类型
	 * @return
	 */
	public boolean isDictitem(Object value, String context) {
		if (null == value) {
			return false;
		}
		
		try{
			String definition = JSON.parseObject(context).getString("definition");
			DictItemVO dictItemVO = CommonServiceUtils.getDictItem(definition, value.toString());
			
			return null != dictItemVO;
		}catch (Exception e) {
			LogUtils.error(log,e.getMessage());
			return false;
		}
	}
	
	/**
	 * 检查value是否为指定的系统参数值（common_sys_param.value)
	 * @param value 入参
	 * @param context 参数编码
	 * @return
	 */
	public boolean isParam(Object value,String context){
		if (null == value) {
			return false;
		}
		
		try{
			String paramid = JSON.parseObject(context).getString("paramid");
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery param = new BaseQuery();
			param.addCondition("paramid", QueryOperate.EQUAL_TO, paramid);
			param.addCondition("value", QueryOperate.EQUAL_TO, value);
			String rsp = service.selectByExample(UcpModel.APP_CODE.value(),null,null,CommonModel.COMMON_SYS_PARAM.value(), JSON.toJSONString(param));
			return JsonResponseUtils.getRowsFormResponse(rsp).size() > 0;
		}catch (Exception e) {
			LogUtils.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 检验value是否等于数组中的某一个值
	 * @param value
	 * @param context 属性value为字符串数组json串,如：[1,2,3]
	 * @return
	 */
	public boolean isValueOf(Object value, String context) {
		if (null == value) {
			return false;
		}
		
		try{
			JSONArray values = JSONArray.parseArray(context);
			for (Object v : values){
				if (value.equals(v)){
					return true;
				}
			}
			return false;
		}catch (Exception e) {
			LogUtils.error(log,e.getMessage());
			return false;
		}
	}
	
	/**
	 * 检验用户存在
	 * @param value 入参（用户编码）
	 * @param context 空
	 * @return 用户存在返回真，不存在返回假
	 */
	public boolean validUser(Object value, String context) {
		if (null == value) {
			return false;
		}
		
		try{
			UserVO user = CommonServiceUtils.getUcpUser(value.toString());
			return null != user;
		}catch (Exception e) {
			LogUtils.error(log,e.getMessage());
			return false;
		}
	}
	
	public boolean isJson(Object value,String context){
		return JsonUtil.isJsonObject(value);
	}
}