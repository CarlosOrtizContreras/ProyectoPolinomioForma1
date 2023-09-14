import javax.swing.JOptionPane;

public class Polinomio3 {
    Lista polinomio;

    public Polinomio3(int[] vector) {
        Lista polinomio = new Lista();
        for (int i = 1; i < vector.length; i = i + 2) {
            if ((polinomio.punta == null) || polinomio != null & polinomio.punta.getExponente() < vector[i]) {
                polinomio.insertarInicio(vector[i - 1], vector[i]);
            } else {
                Nodo posicionAnterior = polinomio.punta;
                Nodo posicion = polinomio.punta;
                while (posicion.getLiga() != null && posicion.getExponente() > vector[i]) {
                    posicionAnterior = posicion;
                    posicion = posicion.getLiga();
                }
                if (posicion.getLiga() == null && posicion.getExponente() > vector[i]) {
                    polinomio.insertarFinal(posicion, vector[i - 1], vector[i]);
                } else if (posicion.getExponente() == vector[i]) {
                    posicion.setCoeficiente(posicion.getCoeficiente() + vector[i - 1]);
                } else {
                    polinomio.insertarMedio(posicion, posicionAnterior, vector[i - 1], vector[i]);
                }
            }
        }

    }
     public Polinomio3(){
        Lista polinomio = new Lista();      
     }

    void mostrarVector() {
        String vector = "";
        Nodo posicion = polinomio.punta;
        do {
            if (polinomio.punta == null) {
                vector = "";
            } else {
                vector = vector + "[" + posicion.getCoeficiente() + "] [" + posicion.getExponente() + "]";
                posicion = posicion.getLiga();
            }

        } while (posicion != null);

        JOptionPane.showMessageDialog(null,
                "El vector del Polinomio en la posicion  COEFICIENTE-EXPONENTE es:\n" + vector);

    }

    String mostrarNatural() {
        String natural = "";
        Nodo posicion = polinomio.punta;
        do {
            if (polinomio.punta == null) {
                natural = "";
            } else {
                if (posicion.getExponente() == 1) {
                    natural = natural + posicion.getCoeficiente() + "x";
                } else if (posicion.getExponente() == 0) {
                    natural = natural + posicion.getCoeficiente();
                } else {
                    natural = natural + posicion.getCoeficiente() + "x^" + posicion.getExponente();
                }
                posicion = posicion.getLiga();
            }

        } while (posicion != null);

        return natural;
    }

    void sumar(int[] vector) {
        Polinomio3 ingreso = new Polinomio3(vector);
        Polinomio3 completo = new Polinomio3();
        Nodo posicion = polinomio.punta;
        Nodo posicion2 = ingreso.polinomio.punta;
        Nodo posicionC = completo.polinomio.punta;
        
        do {
            if (posicion.getExponente()>posicion2.getExponente() || posicion2== null){
                completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente(), posicion.getExponente());
                
                posicion = posicion.getLiga();
            }else if (posicion.getExponente()< posicion2.getExponente() || posicion== null){
                completo.polinomio.insertarFinal(posicionC, posicion2.getCoeficiente(), posicion2.getExponente());
                
                posicion2= posicion2.getLiga();
            } else if (posicion2.getExponente() == posicion.getExponente()){
                completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente()+posicion2.getCoeficiente(), posicion.getExponente());
                posicion2 = posicion2.getLiga();
                posicion=posicion.getLiga();
            }
            if(completo.polinomio.punta.getLiga()!= null){
                    posicionC = posicionC.getLiga();
                }
            
        } while (posicion != null || posicion2 != null);
        Polinomio3 aux = new Polinomio3();
        aux.polinomio= polinomio;
        polinomio = completo.polinomio;
        

       polinomio.redimensionar();

       JOptionPane.showMessageDialog(null, "La suma del polinomio: \n"+ aux.mostrarNatural() +"\ny el polinomio: \n"+ ingreso.mostrarNatural()+ "\nEs igual a: \n"+ mostrarNatural());
    }
}
