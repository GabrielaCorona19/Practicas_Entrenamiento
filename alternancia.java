package condicionescompetencias;

public class alternancia {
    private int turno;
    private int turno1;
    private int turno2;
    private int nombre;
    
    alternancia(){
        this.turno = 1;
        this.turno1 = 1;
        this.turno2 = 1;
    }
    
    public void reiniciar(){
        turno = 1;
        turno1 = 1;
        turno2 = 1;
        nombre = 0;
    }
    
    public void setTurno(int turno){
        
        this.turno = turno;
    }
    
    public void setTurno1(int turno){
        
        this.turno1 = turno;
    }
    
    public void setTurno2(int turno){
        this.turno2 = turno;
    }
    
    public int getTurno2(){
        return turno2;
    }
    
    public int getTurno1(){
        return turno1;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public int nombre(){
        nombre++;
        return nombre;
    }
}
