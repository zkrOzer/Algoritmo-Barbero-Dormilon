import java.util.*;
public class Main {
    private static int hora, minutos, segundos;
    private static long time_start, time_end;
    public static void main(String []args){
        System.out.println("Autor: Josue Ysai Martinez Morales\n");
        time_start = System.currentTimeMillis();
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        System.out.println(hora + ":" + minutos + ":" + segundos);
        System.out.println("La Barberia\n" + "ABIERTO, pase");
        new Barberia();
        time_end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: "+ ( time_end - time_start) +" millisegundos");
    }
}
