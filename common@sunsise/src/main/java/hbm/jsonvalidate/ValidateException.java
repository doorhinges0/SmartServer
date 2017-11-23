package hbm.jsonvalidate;

import java.util.List;

/**
 * 校验异常
 * 
 *  
 *
 */
public class ValidateException extends Exception {

	private static final long serialVersionUID = 1L;
	private List<String> errorList;

	public ValidateException(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<String> getErrorList() {
		return errorList;
	}
	
}
