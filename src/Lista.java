public class Lista {
    private Nodo punta;

    public Lista() {
        this.punta = null;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    void insertarInicio(int coeficiente, int exponente) {
        Nodo posicion;
        Nodo nuevo = new Nodo(coeficiente, exponente);
        if (punta == null) {
            punta = nuevo;
        } else {
            posicion = punta;
            punta = nuevo;
            punta.setLiga(posicion);

        }

    }

    void insertarFinal(Nodo posicion, int coeficiente, int exponente) {

        Nodo nuevo = new Nodo(coeficiente, exponente);

        posicion.setLiga(nuevo);

    }

    void insertarMedio(Nodo posicion, Nodo posicionAnterior, int coeficiente, int exponente) {

        Nodo nuevo = new Nodo(coeficiente, exponente);
        posicionAnterior.setLiga(nuevo);
        nuevo.setLiga(posicion);
    }
}
