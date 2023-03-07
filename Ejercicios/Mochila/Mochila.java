package Ejercicios.Mochila;

public class Mochila {
    private static int capacidadMochila=ramdom(100,5);
    private static int numeroObjetos=ramdom(50,1);
    private static Objeto[] objetosArray=new Objeto[numeroObjetos];
    
    public static void crearObjetos() {
        print("numero de objetos "+numeroObjetos);
        for (int i = 0; i < numeroObjetos; i++) {
            int peso=ramdom(100);
            int valor=ramdom(1000);
            //objetosMap.put(peso, valor);
            Objeto obj = new Objeto(peso,valor);
            objetosArray[i]=(obj);
        }
        print(objetosArray);
        Objeto[] objetosOrdenAscValor=ordenarArrayPeso(objetosArray,1);
        print(objetosOrdenAscValor);
        int valorTotal=guardarMochila(objetosOrdenAscValor);
        print("Valor Total en la mochila"+valorTotal);
    }
    public static int guardarMochila(Objeto[] obj) {
        int valor=0, i=0;
        if (capacidadMochila <= 0){return valor;}
        for (int j = 0; j < obj.length; j++) {
            capacidadMochila += obj[i].getPeso();
            valor+=obj[i].getValor();
        }
        i++;
        return valor;
    }
    public static Objeto[] ordenarArrayPeso(Objeto[] obj, int n) {
        Objeto[] respuesta = new Objeto[obj.length];
        Objeto aux = new Objeto();
        for (int i = 0; i < obj.length; i++) {
            aux = new Objeto(obj[i].getPeso(),obj[i].getValor());
            for (int j = 1; j < obj.length; j++) {
                if (aux.getPeso()>obj[j].getPeso()) {
                    aux = new Objeto(obj[j].getPeso(),obj[j].getValor());
                    obj[j]=obj[i];
                    obj[i]=aux;
                }
            }
            respuesta[i]=(aux);
            aux=null;
        }
        return respuesta;
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
}