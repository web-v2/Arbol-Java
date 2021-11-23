package ArbolParcial2;
import java.util.Scanner;
/**
 *
 * @author SAMIR VERGARA V.
 * @author BRENDA VEGA D.
 */
public class AplicacionArbol {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Nodo n;
        Arbol ab = new Arbol();
        int dato;
        //Ingresar datos al arbol
        while(true){
            System.out.print("Digite dato entero 0-termina:");
            dato = sc.nextInt();
            if(dato == 0){
                break;
            }
            else{
                n = new Nodo(dato);
                ab.addNodo(n);
            }
        }
       
        System.out.println("Imprimir datos en inorden:");
        ab.imprimirInOrden();
        System.out.println("Imprimir datos en preorden:");
        ab.imprimirPreOrden();

        /*1. Cuál es el nodo que tiene el valor numérico entero más alto del árbol.*/
        System.out.println("El valor mayor en el Arbol es: "+ab.nodoNumeroMayor());
        /*2. Eliminar en el árbol, aquellos nodos cuya información numérica sea par.*/
        ab.eliminarNodoInformacionPar();     
        
        System.out.println("Imprimir datos en inorden:");
        ab.imprimirInOrden();
        System.out.println("Imprimir datos en preorden:");
        ab.imprimirPreOrden();

    }
}
