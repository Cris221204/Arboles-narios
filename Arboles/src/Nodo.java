public class Nodo {
    char valor;
    Nodo siguienteHermano;
    Nodo primerHijo;
    public Nodo(char valor) {
        this.valor = valor;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }
}