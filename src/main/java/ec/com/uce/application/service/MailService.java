package ec.com.uce.application.service;


import ec.com.uce.domain.model.Mail;
import ec.com.uce.infraestructure.repository.MailRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped

public class MailService {

    @Inject
    private MailRepositoryImpl mailRepositoryImpl;

    public void guardar (Mail mail){
        //this.mailRepositoryImpl.persist(factura);
        mail.persist();
        

    }
    public Mail buscarPorId(Integer id){
       // return this.mailRepositoryImpl.findById(id);
        return Mail.findById(id);
    }

}
