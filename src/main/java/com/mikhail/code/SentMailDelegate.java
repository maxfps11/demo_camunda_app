package com.mikhail.code;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SentMailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String to = (String) delegateExecution.getVariable("to");
        String text = (String) delegateExecution.getVariable("text");
        String subject = (String) delegateExecution.getVariable("subject");

        MailUtil.sendMail(to, subject, text);
    }
}
