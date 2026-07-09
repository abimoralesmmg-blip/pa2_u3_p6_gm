package ec.com.uce.application.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import ec.com.uce.domain.respository.Archivo;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Archivo
@Interceptor
public class ArchivoInterceptor {

    @AroundInvoke
    public Object archivo(InvocationContext context)throws Exception{
       // 1. Obtener los datos antes de que se ejecute el método
        String nombreMetodo = context.getMethod().getName();
        String fechaActual = LocalDateTime.now().toString();
 
        // 2. Dejar que el método original (ej. crearEstudiante) se ejecute
        Object resultado = context.proceed();
 
        // 3. Escribir en el archivo de forma ultra simple
        try {
            // El 'true' evita que se borre lo que ya estaba escrito antes
            FileWriter escritor = new FileWriter("auditoria.txt", true);
            BufferedWriter buffer = new BufferedWriter(escritor);
 
            // Escribimos la línea con el formato que necesitas
            buffer.write("Metodo: " + nombreMetodo + " - Fecha: " + fechaActual);
            buffer.newLine(); // Hace el salto de línea para el siguiente registro
 
            // Cerramos el buffer para que guarde los cambios en el archivo físico
            buffer.close();
           
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo de auditoría");
        }
 
        // 4. Retornar el resultado del método interceptado
        return resultado;
       
    }

}
