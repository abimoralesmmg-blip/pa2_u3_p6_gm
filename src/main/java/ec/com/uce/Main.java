package ec.com.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.AnimacionService;
import ec.com.uce.application.service.EstudianteService;
import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.FacturaServiceCompletableFuture;
import ec.com.uce.application.service.FacturaServiceParalelo;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Animacion;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main (String...arg){

        Quarkus.run(App.class,arg);
    }

    public static class App implements QuarkusApplication {


       @Inject
        private ReporteService reporteService;
        
        @Override
        public int run(String... args) throws Exception {

            List<Reporte> lista = new ArrayList<>();

            

            for ( int i=0; i <10; i++){
                Reporte r1 = new Reporte();
                r1.setTitulo("Reporte"+i);
                r1.setAutor("Genessis Molina");
                r1.setTipo("Importante"+i);
                r1.setContenedor("pdf");

                lista.add(r1);
            }

            this.reporteService.guardarListaReportes(lista);

            return 0;
        }

    }


}
