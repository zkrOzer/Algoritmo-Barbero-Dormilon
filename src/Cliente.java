public class Cliente {
    private Barberia barberia;
    public Cliente(Barberia barberia){
        this.barberia = barberia;
    }

    public void run(){
        if(this.barberia.getBarbero().durmiendo){
            this.barberia.getBarbero().despertar();
        }
    }
}
