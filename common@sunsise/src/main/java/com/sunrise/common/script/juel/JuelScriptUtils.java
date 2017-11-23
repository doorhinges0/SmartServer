package com.sunrise.common.script.juel;

import java.util.HashMap;
import java.util.Map;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import com.sunrise.ucp.dal.gen.model.UserVO;

/**
 * @todo 待完善
 * @author livan.c
 *
 */
public class JuelScriptUtils {

	public static String translate(String expression,Map<String, Object> context){
		String msg = "";
		try {
			ExpressionFactory factory = new de.odysseus.el.ExpressionFactoryImpl();
			de.odysseus.el.util.SimpleContext simpleContext = new de.odysseus.el.util.SimpleContext();
//			simpleContext.setFunction("math", "max", Math.class.getMethod("max", int.class, int.class));
//			simpleContext.setVariable("foo", factory.createValueExpression(0, int.class));
//			simpleContext.setFunction("user", "name", UserVO.class.getMethod("getUsername"));
			if (null != context && context.size() > 0){
				for (String key : context.keySet()) {
					Object val = context.get(key);
					simpleContext.setVariable(key, factory.createValueExpression(val, val.getClass()));
				}
			}
//			ValueExpression e = factory.createValueExpression(simpleContext, "${math:max(foo,bar)}", int.class);
			ValueExpression e = factory.createValueExpression(simpleContext, expression, String.class);
			//factory.createValueExpression(simpleContext, "${bar}", int.class).setValue(simpleContext, 1);
			msg = e.getValue(simpleContext).toString();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public static void main(String[] args) {
		Map<String, Object> context = new HashMap<String, Object>();
		UserVO user = new UserVO();
		user.setUsercode("001");
		user.setUsername("用户名");
		context.put("operatorName", "蔡万里");
		context.put("user", user);
		
		System.out.println(translate("${operatorName}祝${user.username}生日快乐！", context));
	}
}
