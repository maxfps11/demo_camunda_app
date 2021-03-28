package com.mikhail.code;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static void sendMail(String to, String subject, String text) throws MessagingException {
        String from = "super.vbif201@ya.ru";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //props.put("mail.debug", "true");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("super.vbif201@ya.ru", "password");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);

        Transport.send(message);
    }
}
