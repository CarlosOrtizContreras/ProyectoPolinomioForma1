public class Lista {
    Nodo punta;

    public Lista() {
        this.punta = null;
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
        if (punta == null) {
            punta = nuevo;
        } else {
            posicion.setLiga(nuevo);
        }
    }

    void insertarMedio(Nodo posicion, Nodo posicionAnterior, int coeficiente, int exponente) {

        Nodo nuevo = new Nodo(coeficiente, exponente);
        posicionAnterior.setLiga(nuevo);
        nuevo.setLiga(posicion);
    }

    void redimensionar() {
        Nodo posicion = punta;
        Nodo anterior = punta;

        while (posicion.getLiga() != null) {
            if (posicion.getCoeficiente() == 0) {
                if (posicion == punta) {
                    posicion = posicion.getLiga();
                    punta.setLiga(null);
                    punta = posicion;
                } else {
                    anterior.setLiga(posicion.getLiga());
                    posicion.setLiga(null);
                    posicion = anterior.getLiga();
                }
            }
            anterior = posicion;
            posicion = posicion.getLiga();
        }
    }
}
