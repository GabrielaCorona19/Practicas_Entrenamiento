package condicionescompetencias;
public class dekker {
    private int turno;
    private int nombre = 0;
    
    dekker(){
        this.turno = 1;
    }
    
    public void reiniciar(){
        turno = 1;
        nombre = 0;
    }
    
    public void setTurno(int turno){
        System.out.println("Entre:"+ turno);
        this.turno = turno;
    }
    
    public int getTurno(){
        return turno;
    }
    public int getContador(){
        return nombre;
    }
    
    public int nombre(){
        nombre++;
        return nombre;
    }
}
