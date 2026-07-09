package ec.com.uce.application.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.respository.Auditar;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditar
@Interceptor
@Priority(1)
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService auditoriaService; 

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {
        String nombreMetodo = context.getMethod().getName();
        // Convertimos los parámetros a una representación textual
        String argumentos = Arrays.toString(context.getParameters());

        if (argumentos.length() > 255) {
        argumentos = argumentos.substring(0, 252) + "...";
        }

        long tiempoInicio = System.currentTimeMillis();
        
        // Ejecución del método original
        Object result = context.proceed();
        
        long tiempoFin = System.currentTimeMillis();
        long tiempoEjecucion = tiempoFin - tiempoInicio;

        // Crear objeto de auditoría
        Auditoria auditoria = new Auditoria();
        auditoria.setNombreMetodo(nombreMetodo);
        auditoria.setArgumento(argumentos);
        auditoria.setFechaHora(LocalDateTime.now());
        auditoria.setTiempoEjecucionMs(tiempoEjecucion);

        // Guardar en base de datos
        auditoriaService.crear(auditoria);

        System.out.println("Método interceptado: " + nombreMetodo);
        System.out.println("Argumentos recibidos: " + argumentos); 
        return result;
    }
}
