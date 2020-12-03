package condicionescompetencias;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RCompartido {
    private String datoCompartido;
    private interrupcion[] inter;

    public void iniciarInterrupcion(){
        inter = new interrupcion[2]; //tiene minimo dos interrupciones
        for(int i =0; i<inter.length; i++)
            inter[i] = new interrupcion();
    }

    public int largo(){
        return inter.length;
    }

    public boolean comprobarInter(int i){
        return inter[i].isInter();
    }

    public void estadoInter(int i, boolean estado){
       inter[i].setInter(estado);
    }

    
    RCompartido(){
        datoCompartido="";
    }
    public String getDatoCompartido() {
        return datoCompartido;
    }
    public void setDatoCompartido(String datoCompartido) {
        this.datoCompartido = datoCompartido;
    }
    
    
}
