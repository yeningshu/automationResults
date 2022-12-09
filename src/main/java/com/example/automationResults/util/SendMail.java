/**
 * @author yedeng
 * @date 2022年12月8日
 * 
 */
package com.example.automationResults.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

public class SendMail {
	private Properties prop = null;
	private MimeMessage mimeMessage;
	/**
	 * 发件人地址
	 */
	@Value("${mail.mailAddr}")
//	final String E_ACCOUNT = "";
	private String E_ACCOUNT;
	
	/**
	 * 发件人密码
	 */
	@Value("${mail.mailPassWord}")
//	final String E_PAW = "";
	private String E_PAW ;

	private void init() {
		try {
			prop = new Properties();
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com"); // 服务器
			prop.setProperty("mail.smtp.port", "465"); // 端口
			prop.setProperty("mail.smtp.auth", "true"); // 使用smtp身份验证

			// 使用SSL，企业邮箱必需！
			// 开启安全协议
			MailSSLSocketFactory sf = null;
			try {
				sf = new MailSSLSocketFactory();
				sf.setTrustAllHosts(true);
			} catch (GeneralSecurityException e1) {
				e1.printStackTrace();
			}
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.ssl.socketFactory", sf);
			//
			// 获取Session对象
			Session session = Session.getDefaultInstance(prop, new Authenticator() {
				// 此访求返回用户和密码的对象
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					PasswordAuthentication pa = new PasswordAuthentication(E_ACCOUNT, E_PAW);
					return pa;
				}
			});
			// 设置session的调试模式，发布时取消
//	        session.setDebug(true);
			mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(E_ACCOUNT, E_ACCOUNT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws MessagingException, GeneralSecurityException {
//		SendMail SendEamil = new SendMail();
//		SendEamil.mailSend("yedeng21991@163.com", "异常通知", "中央缓存宕机");
//	}

	/**
	 * 发送邮件
	 * @param recEmail 收件人邮件地址
	 * @param subject  邮件主题
	 * @param text  邮件内容
	 */
	public void mailSend(String recEmail, String subject, String text) {
		try {
			if (prop == null) {
				init();
			}

			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recEmail));
			mimeMessage.setSubject(subject); // 设置主题
			mimeMessage.setSentDate(new Date());
			mimeMessage.setText(text); // 设置内容
			mimeMessage.saveChanges();

			Transport.send(mimeMessage); // 发送
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
