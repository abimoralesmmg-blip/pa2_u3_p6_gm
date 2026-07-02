package ec.com.uce.application.service;

import ec.com.uce.domain.model.Mail;


public class MailServiceTarea implements Runnable {

    
    private MailService mailService;
    private Mail mail;

    public MailServiceTarea(Mail mail, MailService mailService) {
        this.mail = mail;
        this.mailService = mailService;
    }

    @Override
    public void run() {
       
            this.mailService.guardar(mail);
           
    }
}