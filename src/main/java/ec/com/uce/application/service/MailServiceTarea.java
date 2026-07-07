package ec.com.uce.application.service;

import ec.com.uce.domain.model.Mail;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class MailServiceTarea implements Runnable {

    @Inject
    private MailService mailService;
    private Mail mail;

    //setters

    public void setMail(Mail mail) {
        this.mail = mail;
    }



    @Override
    public void run() {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Factura: " + nombreHilo + " | ID: " + Thread.currentThread().threadId());
            this.mailService.guardar(mail);
           
    }
}