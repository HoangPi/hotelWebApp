package business;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailService {
    public static void sendEmail(String to, String subject, String body) throws MessagingException
    {
        Properties props = new Properties();
//        props.put("mail.transport.protocol","smtp");
//        props.put("mail.smtp.host","localhost");
//        props.put("mail.smtp.port",25);
//        props.put("mail.smtp.password","nbcyojydelpxcpjz");
        final String username = "mailofphifortesting@gmail.com";
        final String password = "nbcyojydelpxcpjz";
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
//        Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);
        Transport.send(message);

//        session.setDebug(true);
//
//        MimeMessage message = new MimeMessage(session);
//        message.setSubject(subject);
//        message.setText(body);
//
//        Address sourceAdr = new InternetAddress(from);
//        Address dstAdr = new InternetAddress(to);
//        message.setFrom(sourceAdr);
//        message.setRecipient(Message.RecipientType.TO,dstAdr);
//
//
//        Transport.send(message);
    }
}
