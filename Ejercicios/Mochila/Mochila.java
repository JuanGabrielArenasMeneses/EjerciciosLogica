package Ejercicios.Mochila;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Mochila {
    private static int capacidadMochila=ramdom(100,5);
    private static int numeroObjetos=ramdom(50,1);
    private static Objeto[] objetosArray=new Objeto[numeroObjetos];
    public static ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    public static ArrayList<Objeto> objetosPeso = new ArrayList<Objeto>();
    public static ArrayList<Objeto> objetosValor = new ArrayList<Objeto>();

    public static void crearObjetos() {
        print("numero de objetos "+numeroObjetos);
        for (int i = 0; i < numeroObjetos; i++) {
            int peso=ramdom(100);
            int valor=ramdom(1000);
            //objetosMap.put(peso, valor);
            Objeto obj = new Objeto(peso,valor);
            objetosArray[i]=(obj);
            objetos.add(obj);
        }
        print(objetosArray);
        Objeto[] objetosOrdenAscValor=ordenarArrayPeso(objetosArray,1);
        print(objetosOrdenAscValor);
            //print(objetosOrdenAscValor);
        //print("Valor total en la mochila "+guardarMochila(objetosMap));
        /*objetosPeso=ordenarArray(objetos,1);
        objetosValor=ordenarArray(objetos,2);
        print("objetos originales");
        print(objetos);
        print("objetos por peso");
        print(objetosPeso);
        print("objetos por valor");
        print(objetosValor);*/
    }
      
    public static int guardarMochila(SortedMap<Integer,Integer> obj) {
        int valorTotal=0;
        while (obj.get(obj)!=null) {
            if (capacidadMochila <= 0){return valorTotal;}
            for (Integer key : obj.keySet()) {
                capacidadMochila += key;
                valorTotal+=obj.get(key);
            }
        }
        return valorTotal;
    }
    
    public static Objeto[] ordenarArrayPeso(Objeto[] obj, int n) {
        print("ordenar array: "+ obj.length);
        Objeto[] respuesta = new Objeto[obj.length];
        Objeto aux = new Objeto();
        String operacion ="";
        operacion=(n==1)? "peso": "valor";
        //print("antes");
        for (int i = 0; i < obj.length; i++) {
            print("i: "+i);
            aux = new Objeto(obj[i].getPeso(),obj[i].getValor());
            print("aux= peso: "+obj[i].getPeso()+ "valor: "+obj[i].getValor());
            for (int j = 1; j < obj.length; j++) {
                //print("j: "+j);
                //int iteratedj=(n==1)? obj[j].getPeso(): obj[j].getValor();
                if (aux.getPeso()>obj[j].getPeso()) {
                    aux = new Objeto(obj[j].getPeso(),obj[j].getValor());
                    obj[j]=obj[i];
                    obj[i]=aux;
                    //print("comparacion "+operacion+" :"+aux.getPeso()+" y "+obj[j].getPeso()+" auxiliar: "+aux.getPeso()+", "+aux.getValor());

                }
            }
            //print("seguarda: "+aux.getPeso()+", "+aux.getValor());
            respuesta[i]=(aux);
            aux=null;
        }
        return respuesta;
    }
    public class CompararObjetos implements Comparator<Objeto>{
        @Override
        public int compare(Objeto e1, Objeto e2){
           if(e1.getValor()>e2.getValor()){
               return -1;
           }else if(e1.getValor()>e2.getValor()){
               return 0;
           }else{
               return 1;
           }
       }  
     }
    public static int ramdom(int n){
        return (int)(Math.random()*n+1);
    }
    public static int ramdom(int n, int r){
        return (int)(Math.random()*(n-r)+r);
    }
    public static boolean print(String s) {
        System.out.println(s);
        return true;
    }
    public static boolean print(Objeto[] objetos) {
        for (int i = 0; i < objetos.length; i++) {
            System.out.println("peso: "+objetos[i].getPeso());
            System.out.println("valor: "+objetos[i].getValor());
        }
        return true;
    }
    public static boolean print(ArrayList<Objeto> s) {
        for (int i = 0; i < s.size(); i++) {
            System.out.println("peso: "+s.get(i).getPeso());
            System.out.println("valor: "+s.get(i).getValor());
        }
        return true;
    }
}
    
