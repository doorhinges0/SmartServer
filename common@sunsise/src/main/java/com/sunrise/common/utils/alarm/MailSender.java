package com.sunrise.common.utils.alarm;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.utils.log.LogUtils;

public class MailSender extends MailSenderSupport
{
	Logger log = LoggerFactory.getLogger(MailSender.class);

	public void sendMail(String receiver, String subject, String message) throws Exception
	{
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
		properties.setProperty("mail.smtp.auth", "true");//需要验证

		Session session = Session.getInstance(properties);
		session.setDebug(false);
		//邮件信息
		Message messgae = new MimeMessage(session);
//		messgae.setFrom(new InternetAddress("caiwanli@dtsjy.com"));//设置发送人
		messgae.setFrom(new InternetAddress(getMailFrom()));//设置发送人
		BodyPart html = new MimeBodyPart();
		html.setContent(message,  "text/html; charset=utf-8");
//		messgae.setText(message);//设置邮件内容
		messgae.setSubject(subject);//设置邮件主题
		Multipart multipart = new MimeMultipart();  
		multipart.addBodyPart(html);
		messgae.setContent(multipart);
		
		//发送邮件
		Transport tran = session.getTransport();
		tran.connect(getServerHost(), getServerPort(), getAuthUserName(), getAuthPassword());
//		tran.connect("mail.dtsjy.com", 25, "002784", "");
		tran.sendMessage(messgae, new Address[] { new InternetAddress(receiver) });//设置邮件接收人
		tran.close();

		LogUtils.debug(log,String.format("sent mail to <%s>: %s", receiver, subject));
	}
	
	public static void main(String[] args) throws Exception{
		new MailSender().sendMail("scutcwl@163.com", "测试主题", "测试消息");
	}
}
