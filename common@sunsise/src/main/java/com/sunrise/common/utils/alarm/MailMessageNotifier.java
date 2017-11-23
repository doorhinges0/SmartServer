package com.sunrise.common.utils.alarm;

import java.util.HashMap;
import java.util.Map;

import com.sunrise.common.script.juel.JuelScriptUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import com.sunrise.common.model.SerialNoHolder;
import com.sunrise.common.services.CommonServiceUtils;
import com.sunrise.common.utils.file.FileToolkit;
import com.sunrise.ucp.dal.gen.model.UserVO;

public class MailMessageNotifier implements MessageNotifier, InitializingBean
{
	MailSender mailSender;

	String messageTemplate;

	Resource messageTemplateResource;

	String subject;

	private String subjectTemplate;

	public void afterPropertiesSet() throws Exception
	{
		messageTemplate = FileToolkit.read(messageTemplateResource.getInputStream()).toString();
	}

	public MailSender getMailSender()
	{
		return mailSender;
	}

	public Resource getMessageTemplateResource()
	{
		return messageTemplateResource;
	}

	public String getSubject()
	{
		return subject;
	}

	public String getSubjectTemplate()
	{
		return subjectTemplate;
	}

	/**
	 * @param 
	 */
	public void notify(UserVO[] users, String msg) throws Exception
	{
//		ScriptEngineManager sm = new ScriptEngineManager();
//		sm.getEngineByName("");
		for (UserVO user : users)
		{
			if (user == null)
				continue;

//			ScriptEngine scriptEngine = new JuelScriptEngineFactory().getScriptEngine();
//			msg = (String) scriptEngine.eval(msg);
//			scriptEngine.put("user", user);
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("msg", msg);
			context.put("user", user);
			context.put("operator", CommonServiceUtils.getUcpUser(SerialNoHolder.userCode.get()));
			msg = JuelScriptUtils.translate(messageTemplate, context);
//			subjectTemplate = "${operator.username}祝您生日快乐！";
			String subject = JuelScriptUtils.translate(subjectTemplate, context);
			String email = user.getEmail();
			if (email != null)
			{
				mailSender.sendMail(email, subject,msg);
			}
		}
	}
	
	@Override
	public void notify(UserVO[] users, String subjectTemplate,
			String msgTemplate) throws Exception {
		for (UserVO user : users)
		{
			if (user == null)
				continue;

			Map<String, Object> context = new HashMap<String, Object>();
			context.put("user", user);
			context.put("operator", CommonServiceUtils.getUcpUser(SerialNoHolder.userCode.get()));
			String msg = JuelScriptUtils.translate(messageTemplate, context);
			String subject = JuelScriptUtils.translate(subjectTemplate, context);
			String email = user.getEmail();
			if (email != null)
			{
				mailSender.sendMail(email, subject,msg);
			}
		}
		
	}
	
	public void setMailSender(MailSender mailSender)
	{
		this.mailSender = mailSender;
	}

	public void setMessageTemplateResource(Resource messageTemplateResource)
	{
		this.messageTemplateResource = messageTemplateResource;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public void setSubjectTemplate(String subjectTemplate)
	{
		this.subjectTemplate = subjectTemplate;
	}
	
}
