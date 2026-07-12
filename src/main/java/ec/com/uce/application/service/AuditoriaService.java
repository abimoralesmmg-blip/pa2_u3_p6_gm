package ec.com.uce.application.service;

import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.infraestructure.repository.AuditoriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {
    @Inject
    private AuditoriaRepositoryImpl auditoriaRepositoryImpl;

    @Transactional
    public void crear (Auditoria auditoria){

        this.auditoriaRepositoryImpl.crear(auditoria);
    }


}
