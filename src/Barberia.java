import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Barberia {

    private Barbero barbero;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Random random = new Random();
    private final int maximoClientes = 5;
    private boolean barberiaAbierta = true;
    private int contador = 1;
    public Barberia(){
        barbero = new Barbero(this);
        Thread thread = new Thread(() -> {
            crearCliente();
        });
        thread.start();
        barbero.start();
        teclas();
    }

    private void crearCliente(){
        try {
            while (barberiaAbierta) {
                if(clientes.size() >= maximoClientes) {
                    Thread.sleep(1000);
                    continue;
                }
                if (random.nextInt(100) <= 15) {
                    agregarCliente();
                }
                Thread.sleep(500);
            }
        }
        catch(Throwable e){

        }
    }

    private void agregarCliente(){
        clientes.add(new Cliente(this));
        System.out.println("Un nuevo cliente llegó, numero de clientes: " +contador);
        contador ++;
        if(this.barbero.durmiendo){
            System.out.println("El cliente despertó al barbero ");
            this.barbero.despertar();
        }
    }

    private void teclas(){
        while(barberiaAbierta){
            Scanner scan = new Scanner(System.in);
            if(scan.nextLine().toLowerCase().equals("c")){
                this.barberiaAbierta = false;
                if(clientes.size() > 0){
                    System.out.println("La barberia cerrará cuando se atiendan los clientes faltantes");
                }
            }
        }
    }

    public boolean isSupermercadoAbierto() {
        return supermercadoAbierto;
    }

    public int numeroClientes(){
        return this.clientes.size();
    }

    public Cliente getCliente(){
        return this.clientes.size() > 0 ? clientes.get(0) : null;
    }

    public void eliminarCliente(){
        clientes.remove(clientes.get(0));
    }
    public Barbero getBarbero(){
        return this.barbero;
    }
}
