
package ArbolParcial2;
/**
 *
 * @author SAMIR VERGARA V.
 * @author BRENDA VEGA D.
 */
public class Nodo {
    /* Declaraciones de variables */
    private int valor;
    private Nodo hojaIzquierda,hojaDerecha;
     
    /* Constructor */
    public Nodo(int valor) {
        this.valor = valor;
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    }
 
    /* Setters y Getters */
    public void setValor(int valor) {
        this.valor = valor;
    }
 
    public int getValor() {
        return valor;
    }
 
    public Nodo getHojaIzquierda() {
        return hojaIzquierda;
    }
 
    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
 
    public Nodo getHojaDerecha() {
        return hojaDerecha;
    }
 
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
}
