package ec.com.uce;

import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.ProductoService;
import ec.com.uce.application.service.ReporteService;

import ec.com.uce.domain.model.Producto;
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
        private ProductoService productoService;
        
        @Override
        public int run(String... args) throws Exception {

            List<Producto> lista = new ArrayList<>();

            

            for (int i = 0; i < 500; i++) {
                Producto p = new Producto();
                p.setNombre("Producto " + i);
                p.setDescripcion("Descripción del producto " + i);
                p.setPrecio(19.99 + i);
                p.setStock(i % 100);
                p.setCategoria("Categoría " + (i % 5));
                
                lista.add(p);
            }

            this.productoService.guardarLista(lista);

            return 0;
        }

    }


}
