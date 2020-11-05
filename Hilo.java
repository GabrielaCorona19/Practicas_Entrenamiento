package condicionescompetencias;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private int caso;
    private boolean salir;
    private boolean muerto;
    private int tiempo; 
    private boolean bandera = false; 
    private Cerradura cer; 
    private Lock MUTEX;
    private mutex m;
    private alternancia alt; 
    private int nombre;
    private dijkstra dij;
    
//Acceso a variables dependiendo del metodo
    public void dijkstra(dijkstra d){
        this.dij = d;
        this.dij.agregarProceso();
        this.nombre = this.dij.getTamano();
        System.out.print(nombre);
    }
      
    public void alternancia(alternancia a){
        this.alt = a;
        this.nombre = this.alt.nombre();
    }

    public void setMutex(mutex m){
        this.m = m;
    }

    public void setCerradura(Cerradura cer){
        this.cer = cer;
    }

    public void setSalir(){
        this.salir = true;
    }

    public void setEntrenamiento(int ent){
        this.caso = ent; 
    }
    
    public void matar(){
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
        MUTEX = new ReentrantLock();
    }

    public void run(){
        salir = false;
        while(salir == false){ //Desactiva la ejecución de todos los hilos
            try{
                switch(caso){
                    case 0: 
                        sinAlgoritmo();
                        break;
                    case 1: 
                        interrupciones();
                        break;
                    case 2: 
                        variableCerradura();
                        break;
                    case 3:
                        mutexA();
                        break;
                    case 4:
                        alternancia();
                        break;
                    case 5:
                        Dijkstra();
                        break;
                    case 6:
                        Mutex();
                        break; 
                }
                
            }catch(Exception e){e.printStackTrace();}
        }
        area.setText("");
    }

    private void sinAlgoritmo() {
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
                        area.append("Kill...\n");
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
        if(cer.getCerradura() == false){
                cer.setCerradura(true);
                try{
                    rc.setDatoCompartido(this.getName());
                    area.append(rc.getDatoCompartido()+ "\n");
                    sleep(1000);
                    if(muerto == true){
                        area.append("Kill...");
                        this.stop();
                    }
                
                    cer.setCerradura(false);
                    sleep(500);
                }catch(Exception e){e.printStackTrace();}
            }else{
                try{
                    area.append("Esperando...\n");
                    sleep(2000);
                }catch(InterruptedException e){e.printStackTrace();}
            }
    }

    private void mutexA() { //Mutex con API
        try {            
            if(MUTEX.tryLock()){
                MUTEX.lock();
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+ "\n");
                sleep(500);
                if(muerto == true){
                        area.append("me van a matar...");
                        this.stop();
                }
                MUTEX.unlock();
                
            }else{
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Mutex() {
        try {
            sleep(tiempo);
            if(m.getPase()){
                m.setPase(false);
                m.lock();
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+ "\n");
                sleep(500);
                if(muerto == true){
                        area.append("me van a matar...");
                        this.stop();
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
        
  

    private void alternancia() {
        try {
               switch(nombre){
                   case 1:
                        if(alt.getTurno() ==1 && alt.getTurno2()==1){
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido()+ "\n");
                            sleep(500);
                            if(muerto == true){
                                area.append("Kill...");
                                this.stop();
                            }
                            alt.setTurno(2);
                            sleep(500);
                        }else{
                            sleep(100);
                        }
                        
                   break;
                   case 2:
                        if(alt.getTurno() ==2 && alt.getTurno2()==1){
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido()+ "\n");
                            sleep(500);
                            if(muerto == true){
                                area.append("me van a matar...");
                                this.stop();
                            }
                            alt.setTurno(1);
                            alt.setTurno2(2);
                            sleep(500);
                        }else{
                            sleep(100);
                        }
                        
                    break;
                   
                   case 3:
                       if(alt.getTurno1() ==1 && alt.getTurno2()==2){
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido()+ "\n");
                            sleep(500);
                            if(muerto == true){
                                area.append("me van a matar...");
                                this.stop();
                            }
                            alt.setTurno1(2);
                            sleep(500);
                        }else{
                           sleep(100);
                       }
                        
                    case 4:
                        if(alt.getTurno1() ==2 && alt.getTurno2()==2){
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido()+ "\n");
                            sleep(500);
                            if(muerto == true){
                                area.append("me van a matar...");
                                this.stop();
                            }
                            alt.setTurno1(1);
                            alt.setTurno2(1);
                            sleep(500);
                        }else{
                            sleep(100);
                        }
                        
                    break;
     
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
            area.append("me van a matar...");
            this.stop();
        }
        
        dij.setValorC(true, i);
        dij.setValorB(true, i);
        sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
