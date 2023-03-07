package Ejercicios.Mochila;
import java.util.HashMap;
import java.util.Map;

public class Mochila {
    private int capacidadMochila=ramdom(100);
    private static int numeroObjetos=ramdom(100);
    
    static HashMap<Integer,Integer> objetos = new HashMap<Integer,Integer>();
    
    public static void crearObjetos() {
        for (int i = 0; i < numeroObjetos; i++) {
            int objetoKey=ramdom(100);
            int objetoValue=ramdom(1000);
            objetos.put(objetoKey, objetoValue);
        }
        for(Map.Entry<Integer,Integer> entry:objetos){

        }
    }
    public static int ramdom(int n){
        return (int)(Math.random()*n+1);
    }
    public static boolean print(String s) {
        System.out.println(s);
        return true;
    }
}
    
