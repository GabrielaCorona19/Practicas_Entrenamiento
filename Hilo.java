package condicionescompetencias;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private int algoritmo;
    private boolean salir=false;
    private boolean muerto;
    private int tiempo; 
    private boolean bandera = false; 
    private cerradura cer;
    private Lock mutex;
    private mutex m;
    private dekker d; 
    private int nombre;
    private dijkstra dij;
    

    public void dijkstra(dijkstra dij){
        this.dij = dij;
        this.dij.agregarProceso();
        this.nombre = this.dij.getTamano();
        System.out.print(nombre);
    }
    

    public void dekker(dekker d){
        this.d = d;
        this.nombre = d.nombre();
    }
    

    public void setMutex(mutex art){
        this.m = art;
    }
    

    public void setCerradura(cerradura cer){
        this.cer = cer;
    }

    public void setSalir(){
        this.salir = true;
    }

    public void setAlgoritmo(int alg){
        this.algoritmo = alg; 
    }

    public void dead(){
        this.muerto = true;
    }

    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }
    
    Hilo(JTextArea area, RCompartido rc){
        this.area = area; 
        this.rc = rc;
        this.salir = false;
        this.muerto = false;
        mutex = new ReentrantLock();
    }
    

    
    public void run(){
        while(salir == false){
            try{
                switch(algoritmo){
                    case 0:
                        condicionesCompetencia();
                        break;
                    case 1: 
                        interrupciones();
                        break;
                    case 2: 
                        variableCerradura();
                        break;
                    case 3:
                        mutexAPI();
                        break;
                    case 4:
                        dekker();
                        break;
                    case 5:
                        Dijkstra();
                        break;
                    case 6:
                        mutex();
                        break; 
                }
                
            }catch(Exception e){e.printStackTrace();}
        }
        area.setText("");
    }

    private void condicionesCompetencia() {
        rc.setDatoCompartido(this.getName());
        area.append(rc.getDatoCompartido()+ "\n");
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void interrupciones() {
        try{
            int largo = rc.largo();
            bandera = false;
            sleep(tiempo);
                for(int i = 0; i<largo; i++)
                    if(rc.comprobarInter(i) == true)
                        bandera = true;
                if (bandera == false){
                      rc.setDatoCompartido(this.getName());
                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, true);
                    
                    if(muerto == true){
                        area.append("Me matan...\n");
                        this.stop();
                    }
                    area.append(rc.getDatoCompartido()+ "\n");
                    sleep(1000);
                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, false);
                }else{
                    area.append("Esperando...\n");
                }
            }catch(Exception e){e.printStackTrace();}
    }

    
    private void variableCerradura() {
        if(cer.isCerradura() == false){
                cer.cerrar();
                try{
                    rc.setDatoCompartido(this.getName());
                    area.append(rc.getDatoCompartido()+ "\n");
                    sleep(1000);
                    if(muerto == true){
                        area.append("Me matan...");
                        this.stop();
                    }
                
                    cer.abrir();
                    sleep(500);
                }catch(Exception e){e.printStackTrace();}
            }else{
                try{
                    area.append("Esperando...\n");
                    sleep(2000);
                }catch(InterruptedException e){e.printStackTrace();}
            }
    }

    
    private void mutexAPI() {
        try {
            sleep(tiempo);
            if(mutex.tryLock()){               
                mutex.lock();
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+ "\n");
                sleep(500);
                if(muerto == true){
                        area.append("Me matan...");
                        this.stop();
                }
                mutex.unlock();
                sleep(700);
            }else{
                sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  

    private void dekker() {
     try {
            if(d.getTurno() == nombre){
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+ "\n");
                sleep(500);
                if(muerto == true){
                    area.append("Me matan...");
                    this.stop();
                }
                if(nombre == d.getContador()){
                    d.setTurno(1);
                }else{
                    
                    d.setTurno(nombre+1);
                }
            }else{
                area.append("Esperando...\n");
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Dijkstra() {
        boolean salir1=true;
        try {
        int i = nombre-1;   
        int cont = 0; 
        
        do{
            dij.setValorB(false, i);
            salir1=true;
            if(dij.getValorK() != i){
                if(cont == 10){
                        dij.setValorB(true,dij.getValorK());
                       dij.setValorC(true,dij.getValorK());
                       cont= 0;
                }
                dij.setValorC(true, i);
                if(dij.getValorB(dij.getValorK())){
                   dij.setValork(i);
                }else{
                    cont++;
                }         
                salir1 = false;
            }else{
                dij.setValorC(false, i);
                for(int j=0;j<dij.getTamano();j++){ 
                    if(j != i && dij.getValorC(j) == false){   
                        salir1 = false;  
                    }
                }
            }
            if(salir ==true)
                salir1 = true;
           sleep(100);   
        }while(salir1 == false);
        dij.setValorC(false, i);
        rc.setDatoCompartido(this.getName());
        area.append(rc.getDatoCompartido()+ "\n");
        sleep(500);
        if(muerto == true){
            area.append("Me matan...");
            this.stop();
        }
        
        dij.setValorC(true, i);
        dij.setValorB(true, i);
        sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mutex() {
        try {
            sleep(tiempo);
            if(m.getPase()){
                m.setPase(false);
                m.lock();
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+ "\n");
                sleep(500);
                if(muerto == true){
                        area.append("Me matan...");
                        this.stop();
                }else{
                    area.append("Esperando..." + "\n");
                }
                m.unLock();
                m.setPase(true);
                sleep(700);
            }else{
                sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}