public class Barbero extends Thread{
    boolean durmiendo;
    private Barberia barberia;
    public Barbero(Barberia barberia){
        this.barberia = barberia;
    }

    public void run(){
        while(this.barberia.isBarberiaAbierta()){
            if(this.barberia.numeroClientes() == 0){
                dormir();
            }
            else{
                atender();
            }
        }
    }

    private void dormir(){
        this.durmiendo = true;
        System.out.println("Los barberos empezaron a dormir");
        while(this.durmiendo){
            if(!barberia.isBarberiaAbierta()){
                System.out.println("Los barberos despertaron porque van a cerrar");
                return;
            }
            try{
                System.out.println("zzzzzzzz");
                Thread.sleep(2000);
            }
            catch(Throwable e){
            }
        }
    }

    private void atender() {
        Cliente cliente = this.barberia.getCliente();
        if (cliente == null) {
            return;
        }
        System.out.println("El barbero esta atendiendo a un cliente");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El cliente fue atendido, Gracias por su preferencia! :)");
        barberia.eliminarCliente();

    }


    public void despertar(){
        this.durmiendo = false;
        System.out.println("El barbero");
    }
}
