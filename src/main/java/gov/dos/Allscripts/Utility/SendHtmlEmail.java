package gov.dos.Allscripts.Utility;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendHtmlEmail extends BaseTest {
	
	public void send(String from, String password, String to, String sub, String msg) 
	{
        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtpdc2.plan-sys.com");
//        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "25");
        
        String d_email = "";
        String d_password = "";
        String d_host = "";
        String  d_port  = "587";

        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.password", d_password);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        
        
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        
        //session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(sub);
            
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setContent(msg, "text/html");
            
            BodyPart messageBodyPart2 = new MimeBodyPart();
            Path file = Paths.get("target", "surefire-reports", "emailable-report.html");
            String fileName = file.toFile().getAbsolutePath();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName("emailable-report.html");
            
            Multipart multipartObject = new MimeMultipart();
            multipartObject.addBodyPart(messageBodyPart1);
            multipartObject.addBodyPart(messageBodyPart2);
            
            message.setContent(multipartObject);
            
            Transport.send(message);
           //log.info("message sent successfully....");
           log.info("message sent successfully....");
        } 
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
