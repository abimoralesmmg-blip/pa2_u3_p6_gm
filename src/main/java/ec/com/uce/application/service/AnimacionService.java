package ec.com.uce.application.service;

import ec.com.uce.domain.model.Animacion;
import ec.com.uce.domain.respository.MedirTiempo;
import ec.com.uce.infraestructure.repository.AnimacionRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AnimacionService {
    @Inject
    private AnimacionRepositoryImpl animacionRepositoryImpl;

    @MedirTiempo
    public void guardar (Animacion animacion){
        String nombreHilo =Thread.currentThread().getName();
        long idHilo = Thread.currentThread().threadId();
        System.out.println("Hilo Animacion: " + nombreHilo + " | ID: " + idHilo);
        this.animacionRepositoryImpl.persist(animacion);
        

    }

    @MedirTiempo
    public void procesarGuion() throws InterruptedException {
        System.out.println("Hilo Guion: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().threadId());
        Thread.sleep(100); 
    }

    @MedirTiempo
    public void crearModelos3D() throws InterruptedException {
        System.out.println("Hilo Modelado: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().threadId());
        Thread.sleep(150);
    }

    @MedirTiempo
    public void aplicarTexturas() throws InterruptedException {
        System.out.println("Hilo Texturizado: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().threadId());
        Thread.sleep(100);
    }

    @MedirTiempo
    public void generarRender() throws InterruptedException {
        System.out.println("Hilo Render: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().threadId());
        Thread.sleep(200);
    }
}
