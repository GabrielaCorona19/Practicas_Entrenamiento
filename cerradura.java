package condicionescompetencias;

public class cerradura {
    private boolean cerradura;
    
    cerradura(){
        this.cerradura=false;
    }
    
    public boolean isCerradura(){
        return cerradura;
    }
    
    public void setCerradura(boolean cerradura){
        this.cerradura=cerradura;
    }
    
    public void cerrar(){
        cerradura=true;
    }
    
    public void abrir(){
        cerradura=false;
    }
    
}
