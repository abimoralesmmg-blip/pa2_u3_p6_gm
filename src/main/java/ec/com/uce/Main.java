package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main (String...arg){

        Quarkus.run(App.class,arg);
    }

    public static class App implements QuarkusApplication {


        @Inject
        private FacturaService facturaService;

        @Inject
        private MailService mailService;

        @Inject
        private ReporteService reporteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Prueba de nuevo proyecto ");

            Factura f1= new Factura();
            f1.setFecha(LocalDate.of(2026, 06, 12));
            f1.setNumero("003-22");
            f1.setRuc("154541313");

            //this.facturaService.guardar(f1);

            
            Factura fact = this.facturaService.buscarPorId(1);
            System.out.println(fact.getNumero());


            System.out.println("MAIL ");

            Mail m1 = new Mail ();
            m1.setCorreo("gene@uce.edu.ec");
            m1.setRemitente("Genessis");
            m1.setDestinatario("Abigail");
            m1.setAsunto("Trabajo");
            m1.setFecha(LocalDate.of(2026, 06, 12));
        
            //this.mailService.guardar(m1);

            
            Mail m = this.mailService.buscarPorId(1);
            System.out.println(m.getId());

            System.out.println("Reporte ");

            Reporte r1 = new Reporte();
            r1.setTitulo("Historial Reporte");
            r1.setAutor("Genessis");
            r1.setTipo("Importe");
            r1.setContenedor("El reporte es el siguiente:");
            
            //this.reporteService.guardar(r1);

            
             Reporte re  = this.reporteService.buscarPorId(1);
            System.out.println(re.getId());
            return 0;
        }

    }


}
