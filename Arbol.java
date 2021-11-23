package ArbolParcial2;
/**
 *
 * @author SAMIR VERGARA V.
 * @author BRENDA VEGA D.
 */
public class Arbol {
    /* Atributos */
    private Nodo raiz;
 
    /* Contructories */
    public Arbol() {
         raiz = null;
    }
 
    public Arbol( int valor ) {
        this.raiz = new Nodo( valor );
    }
 
    public Arbol( Nodo raiz ) {
        this.raiz = raiz;
    }
 
    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
 
    /* Funciones */
    public void addNodo( Nodo nodo ) {
        if(this.raiz == null){
            this.raiz = nodo;
        }
        else{
           this.addNodo( nodo , this.raiz );//llamada recursiva
        }
    }
    private void addNodo( Nodo nodo, Nodo raiz ) {
        if ( nodo.getValor() <= raiz.getValor() ) {
           if(raiz.getHojaIzquierda() == null){
              raiz.setHojaIzquierda(nodo);
           }
           else{
              addNodo(nodo,raiz.getHojaIzquierda());//llamada recursiva
           }
        }
        else {
             if(raiz.getHojaDerecha() == null){
               raiz.setHojaDerecha(nodo);
             }
             else{
               addNodo(nodo,raiz.getHojaDerecha());
             }
        }
           //}
        //}
   }
 
   private Nodo buscarNodo( int dato, Nodo raiz ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            return null;
        }
        else {
            if(dato == raiz.getValor()){
                return raiz;
            }
            else{
                /* 4.- En caso negativo preguntamos: X < Nodo */
                if ( dato <= raiz.getValor() ) {
                    /* 
                     * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                     * que acabamos de preguntar y repetimos desde el paso 2 
                     * partiendo del Nodo al que acabamos de visitar 
                     */
                    return buscarNodo( dato , raiz.getHojaIzquierda() );
                }
                else {
                    /*      
                     * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                     * cual hicimos con el caso anterior repetimos desde el paso 2
                     * partiendo de este nuevo Nodo.
                     */
                    return buscarNodo( dato, raiz.getHojaDerecha() );
                }
            }
        }
    }
 
    public Nodo buscarNodo( int dato ) {
        return this.buscarNodo( dato , this.raiz );//llamar metodo recursivo
    }
    
    private Nodo buscarPadreNodo( int dato, Nodo raiz,Nodo padre ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             */
            return null;
        }
        else {
            if(dato == raiz.getValor()){
                return padre;
            }
            else{
                /* 4.- En caso negativo preguntamos: X < Nodo */
                if ( dato <= raiz.getValor() ) {
                    /* 
                     * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                     * que acabamos de preguntar y repetimos desde el paso 2 
                     * partiendo del Nodo al que acabamos de visitar 
                     */
                    padre = raiz;
                    return buscarPadreNodo( dato , raiz.getHojaIzquierda(),padre);
                }
                else {
                    /*      
                     * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                     * cual hicimos con el caso anterior repetimos desde el paso 2
                     * partiendo de este nuevo Nodo.
                     */
                    padre = raiz;
                    return buscarPadreNodo( dato, raiz.getHojaDerecha(),padre);
                }
            }
        }
    }
 
    public Nodo buscarPadreNodo( int dato ) {
        Nodo padre = null;
        return this.buscarPadreNodo( dato , this.raiz,padre);
    }
    
    private void imprimirPreOrden (Nodo raiz){
       if (raiz != null){
           System.out.print(raiz.getValor() + " - ");
           imprimirPreOrden (raiz.getHojaIzquierda());
           imprimirPreOrden (raiz.getHojaDerecha());
       }
    }
    private void imprimirInOrden (Nodo raiz){
       if (raiz != null){
           imprimirInOrden (raiz.getHojaIzquierda());
           System.out.print(raiz.getValor() + " - ");
           imprimirInOrden (raiz.getHojaDerecha());
       }
    }
    public void imprimirPreOrden (){
       imprimirPreOrden (this.raiz);
       System.out.println();
    }
    public void imprimirInOrden (){
       imprimirInOrden (this.raiz);
       System.out.println();
    }       
    
    
    public boolean removeNodo( Nodo nodo) {
 
        /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = nodo.getHojaDerecha() != null ? true : false;
        boolean tieneNodoIzquierda = nodo.getHojaIzquierda() != null ? true : false;
        Nodo padre;
        /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */
 
        /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            padre = this.buscarPadreNodo(nodo.getValor());
            return removeNodoCaso1( nodo,padre );
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            padre = this.buscarPadreNodo(nodo.getValor());
            return removeNodoCaso2( nodo,padre);
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            padre = this.buscarPadreNodo(nodo.getValor());
            return removeNodoCaso2( nodo,padre );
        }
 
        /* Caso 3: Tiene ambos hijos */
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }
 
        return false;
    }
 
    private boolean removeNodoCaso1( Nodo nodo,Nodo Padre) {
        /* lo único que hay que hacer es borrar el nodo y establecer el apuntador de su padre a nulo */

        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */

        if ( Padre.getHojaIzquierda() == nodo ) {
            Padre.setHojaIzquierda( null );
            return true;
        }

        if ( Padre.getHojaDerecha() == nodo) {
            Padre.setHojaDerecha( null );
            return true;
        }

        return false;
    }
 
    private boolean removeNodoCaso2( Nodo nodo, Nodo padre ) {
        /* Borrar el Nodo y el subárbol que tenía pasa a ocupar su lugar */
 
        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        
        /*
         * Buscamos el hijo existente del nodo que queremos eliminar
         */
        Nodo hijoActual = nodo.getHojaIzquierda() != null ? 
                nodo.getHojaIzquierda() : nodo.getHojaDerecha();
 
        if ( padre.getHojaIzquierda() == nodo ) {
            padre.setHojaIzquierda( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
 
            return true;
        }
 
        if ( padre.getHojaDerecha() == nodo) {
            padre.setHojaDerecha( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
 
            return true;
        } 
 
        return false;
    }
 
    private boolean removeNodoCaso3( Nodo nodo ) {
        /* Tomar el hijo derecho del Nodo que queremos eliminar */
        Nodo nodoMasALaIzquierda = recorrerIzquierda( nodo.getHojaDerecha() );
        if ( nodoMasALaIzquierda != null ) {
            /* 
             * Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
             */
            removeNodo( nodoMasALaIzquierda );
            /*
             * Reemplazamos el valor del nodo que queremos eliminar por el nodo que encontramos 
             */
            nodo.setValor( nodoMasALaIzquierda.getValor() );
            return true;
        }
        return false;
    }
 
    /* Recorrer de forma recursiva hasta encontrar el nodo más a la izquierda */
    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHojaIzquierda() != null) {
            return recorrerIzquierda( nodo.getHojaIzquierda() );
        }
        return nodo;
    }
        
    /**
     * Metodo publico para encontrar el mayor elemento en un arbol.
     * Encuentra el mayor elemento del arbol.
     * @return el mayor elemento en el arbol o nulo si esta vacio.
     */
    public int nodoNumeroMayor() {
	Nodo n = nodoNumeroMayor(raiz);
	return (n == null) ? null : n.getValor();
    }
    
    /**
     * Metodo interno para encontrar el mayor elemento en un arbol.
     * @param nodo raiz del arbol.
     * @return nodo - el nodo que contiene el elemento mayor.
     */        
    private Nodo nodoNumeroMayor(Nodo nodo) {
        if(nodo != null){
            if(nodo.getHojaDerecha() != null){
               nodo = nodoNumeroMayor( nodo.getHojaDerecha() );
            }        
        }
        return nodo;
    }   
    
    /**
     * Metodo publico para eliminar los nodos con información par en un arbol.     
     * inicializa el metodo privado eliminarNodoInformacionPar y se le pasa 
     * como parametro la raiz del arbol.
     */
    public void eliminarNodoInformacionPar(){
        eliminarNodoInformacionPar(raiz);
    }
    
    
    /** 
     * Metodo interno para eliminar los nodos con información par en un arbol. 
     * evalua el valor en cada nodo si es PAR se llama al metodo removeNodo el 
     * cual se encarga de realizar la eliminación del nodo.
     * @param nodo raiz.
     */
    private void eliminarNodoInformacionPar(Nodo nodo){
        if (nodo != null) {
            if(raiz.getValor() %2 == 0 && nodo == raiz){ 
                Nodo artificial = new Nodo(0);                
                artificial.setHojaDerecha(raiz);
                setRaiz(artificial);                               
            }
            eliminarNodoInformacionPar(nodo.getHojaIzquierda());          
            eliminarNodoInformacionPar(nodo.getHojaDerecha());
            if(nodo.getValor() %2 == 0){
                removeNodo(nodo);
            }                                          
        }        
    }
}
