package hbm.jsonvalidate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 用于配置校验规则
 * 
 *  
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ValidateRule {
	  String attr() default "";
	  String methods();
	  String context() default "";
	  String message();
}
