package condicionescompetencias;


public class Cerradura {
     boolean cerradura;
    
    Cerradura(){
        this.cerradura = false;
    }
    
    public void reiniciar(){
        this.cerradura = false;
    }
    
    public void setCerradura(boolean ban){
        this.cerradura = ban;
    }
    
    public boolean getCerradura(){
        return cerradura;
    }
}
