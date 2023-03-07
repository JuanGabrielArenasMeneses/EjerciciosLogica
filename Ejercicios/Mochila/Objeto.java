package Ejercicios.Mochila;

public class Objeto {
    private Integer peso;
    private Integer valor;

    public Objeto(){}
    public Objeto(int p,int v){
        this.peso=p;
        this.valor=v;
    }
    public void setPeso(int p) {
        this.peso=p;
    }
    public void setValor(int v) {
        this.valor=v;
    }
    public int getPeso() {
        return this.peso;
    }
    public int getValor() {
        return this.valor;
    }
}
