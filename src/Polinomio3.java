import javax.swing.JOptionPane;

public class Polinomio3 {
    public Lista polinomio;

    public Polinomio3(int[] vector) {
        polinomio = new Lista();
        for (int i = 1; i < vector.length; i = i + 2) {
            if ((polinomio.punta == null) || (polinomio.punta != null && polinomio.punta.getExponente() < vector[i])) {
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

    public Polinomio3() {
        polinomio = new Lista();
    }

    void mostrarVector() {
        String vector = "";

        Nodo posicion = polinomio.punta;
        boolean bandera = true;
        if (posicion == null) {
            bandera = false;
        }

        while (bandera) {

            vector = vector + "[" + posicion.getCoeficiente() + "] [" + posicion.getExponente() + "]";

            if (posicion.getLiga() == null) {
                bandera = false;
            }
            posicion = posicion.getLiga();
        }

        JOptionPane.showMessageDialog(null,
                "El vector del Polinomio en la posicion COEFICIENTE-EXPONENTE es:\n" + vector);

    }

    String mostrarNatural() {
        String natural = "";
        Nodo posicion = polinomio.punta;
        do {
            if (polinomio.punta == null) {
                natural = "";
            } else {
                if (posicion.getExponente() == 1) {
                    if (posicion.getCoeficiente() > 0 && natural != "") {
                        natural = natural + "+" + posicion.getCoeficiente() + "x";
                    } else {
                        natural = natural + posicion.getCoeficiente() + "x";
                    }

                } else if (posicion.getExponente() == 0) {
                    if (posicion.getCoeficiente() > 0 && natural != "") {
                        natural = natural + "+" + posicion.getCoeficiente();
                    } else {
                        natural = natural + posicion.getCoeficiente() + "x";
                    }

                } else {
                    if (posicion.getCoeficiente() > 0 && natural != "") {
                        natural = natural + "+" + posicion.getCoeficiente() + "x^" + posicion.getExponente();
                    } else {
                        natural = natural + posicion.getCoeficiente() + "x^" + posicion.getExponente();
                    }

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
        if (polinomio.punta == null || ingreso.polinomio.punta == null) {
            if (polinomio.punta == null) {
                completo.polinomio = ingreso.polinomio;
            } else {
                completo.polinomio = polinomio;
            }
        } else if (polinomio.punta == null && ingreso.polinomio.punta == null) {
            completo.polinomio.punta = null;
        } else {
            do {
                if (posicion.getExponente() > posicion2.getExponente() || posicion2 == null) {
                    completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente(), posicion.getExponente());

                    posicion = posicion.getLiga();
                } else if (posicion.getExponente() < posicion2.getExponente() || posicion == null) {
                    completo.polinomio.insertarFinal(posicionC, posicion2.getCoeficiente(), posicion2.getExponente());

                    posicion2 = posicion2.getLiga();
                } else if (posicion2.getExponente() == posicion.getExponente()) {
                    completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente() + posicion2.getCoeficiente(),
                            posicion.getExponente());
                    posicion2 = posicion2.getLiga();
                    posicion = posicion.getLiga();
                }
                if (completo.polinomio.punta.getLiga() != null) {
                    posicionC = posicionC.getLiga();
                } else {
                    posicionC = completo.polinomio.punta;
                }

            } while (posicion != null || posicion2 != null);
            completo.polinomio.redimensionar();

        }

        JOptionPane.showMessageDialog(null, "La suma del polinomio: \n" + mostrarNatural() + "\ny el polinomio: \n"
                + ingreso.mostrarNatural() + "\nEs igual a: \n" + completo.mostrarNatural());
    }

    void restar(int[] vector) {
        Polinomio3 ingreso = new Polinomio3(vector);
        Polinomio3 completo = new Polinomio3();
        Nodo posicion = polinomio.punta;
        Nodo posicion2 = ingreso.polinomio.punta;
        Nodo posicionC = completo.polinomio.punta;
        if (polinomio.punta == null || ingreso.polinomio.punta == null) {
            if (polinomio.punta == null) {
                completo.polinomio = ingreso.polinomio;
            } else {
                completo.polinomio = polinomio;
            }
        } else if (polinomio.punta == null && ingreso.polinomio.punta == null) {
            completo.polinomio.punta = null;
        } else {
            do {
                if (posicion.getExponente() > posicion2.getExponente() || posicion2 == null) {
                    completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente(), posicion.getExponente());

                    posicion = posicion.getLiga();
                } else if (posicion.getExponente() < posicion2.getExponente() || posicion == null) {
                    completo.polinomio.insertarFinal(posicionC, posicion2.getCoeficiente(), posicion2.getExponente());

                    posicion2 = posicion2.getLiga();
                } else if (posicion2.getExponente() == posicion.getExponente()) {
                    completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente() - posicion2.getCoeficiente(),
                            posicion.getExponente());
                    posicion2 = posicion2.getLiga();
                    posicion = posicion.getLiga();
                }
                if (completo.polinomio.punta.getLiga() != null) {
                    posicionC = posicionC.getLiga();
                } else {
                    posicionC = completo.polinomio.punta;
                }

            } while (posicion != null || posicion2 != null);
            completo.polinomio.redimensionar();
        }
        JOptionPane.showMessageDialog(null, "La Resta del polinomio: \n" + mostrarNatural() + "\ny el polinomio: \n"
                + ingreso.mostrarNatural() + "\nEs igual a: \n" + completo.mostrarNatural());
    }

    void evaluar() {
        int x = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese el valor que tendra 'X', para evaluar el polinomio"));
        double total = 0;
        Nodo posicion = polinomio.punta;
        while (posicion != null) {
            total = total + (posicion.getCoeficiente() * (Math.pow(x, posicion.getExponente())));
            posicion = posicion.getLiga();
        }

        JOptionPane.showMessageDialog(null,
                "El resultado del polinomio \n" + mostrarNatural() + "\nEvaluado en X: " + x + " es: " + total);
    }

    void insertar(int[] vector) {
        Polinomio3 ingreso = new Polinomio3(vector);
        Polinomio3 completo = new Polinomio3();
        Nodo posicion = polinomio.punta;
        Nodo posicion2 = ingreso.polinomio.punta;
        Nodo posicionC = completo.polinomio.punta;
        if (polinomio.punta == null){
            polinomio=ingreso.polinomio;
        }else{
            do {
            if (posicion.getExponente() > posicion2.getExponente() || posicion2 == null) {
                completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente(), posicion.getExponente());

                posicion = posicion.getLiga();
            } else if (posicion.getExponente() < posicion2.getExponente() || posicion == null) {
                completo.polinomio.insertarFinal(posicionC, posicion2.getCoeficiente(), posicion2.getExponente());

                posicion2 = posicion2.getLiga();
            } else if (posicion2.getExponente() == posicion.getExponente()) {
                completo.polinomio.insertarFinal(posicionC, posicion.getCoeficiente() + posicion2.getCoeficiente(),
                        posicion.getExponente());
                posicion2 = posicion2.getLiga();
                posicion = posicion.getLiga();
            }
            if (completo.polinomio.punta.getLiga() != null) {
                posicionC = posicionC.getLiga();
            } else {
                posicionC = completo.polinomio.punta;
            }

        } while (posicion != null || posicion2 != null);
        completo.polinomio.redimensionar();
        polinomio = completo.polinomio;
        }
        
    }

    void eliminar() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Este es el polinomio: \n" + mostrarNatural()
                + "\nIngrese el exponente del monomio que desea eliminar: "));
        Nodo posicion = polinomio.punta;
        Nodo anterior = posicion;
        boolean eliminado = true;
        while (posicion != null) {

            if (posicion.getExponente() == x) {
                if (posicion == polinomio.punta && polinomio.punta.getLiga() == null) {
                    polinomio.punta = null;
                } else if (posicion.getLiga() == null) {
                    anterior.setLiga(null);
                } else if (posicion == polinomio.punta) {
                    polinomio.punta = polinomio.punta.getLiga();
                    posicion.setLiga(null);
                } else {
                    anterior.setLiga(posicion.getLiga());
                    posicion.setLiga(null);
                    posicion = anterior.getLiga();

                }
                eliminado = false;
            }

            anterior = posicion;
            posicion = posicion.getLiga();
        }
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "El dato con el exponente " + x + " no existe.");
        }
    }

    void multiplicar(int[] vector) {
        Polinomio3 ingreso = new Polinomio3(vector);
        Polinomio3 completo = new Polinomio3();

        Nodo posicion = polinomio.punta;
        Nodo posicion2 = ingreso.polinomio.punta;
        Nodo posicionC = completo.polinomio.punta;
        Nodo anteriorC = posicionC;
        if (polinomio.punta == null || ingreso.polinomio.punta == null) {
            completo.polinomio.punta= null;
        } else {
            while (posicion != null) {
                while (posicion2 != null) {
                    if (completo.polinomio.punta == null) {
                        completo.polinomio.insertarInicio(posicion.getCoeficiente() * posicion2.getCoeficiente(),
                                posicion.getExponente() + posicion2.getExponente());
                    } else {
                        posicionC = completo.polinomio.punta;
                        anteriorC = posicionC;
                        while (posicionC.getExponente() > posicion.getExponente() + posicion2.getExponente()
                                && posicionC.getLiga() != null) {
                            anteriorC = posicionC;
                            posicionC = posicionC.getLiga();
                        }
                        if (posicionC.getExponente() == posicion.getExponente() + posicion2.getExponente()) {
                            posicionC.setCoeficiente(posicionC.getCoeficiente()
                                    + (posicion.getCoeficiente() * posicion2.getCoeficiente()));

                        } else if (posicionC.getLiga() == null
                                && posicionC.getExponente() > (posicion2.getExponente() + posicion.getExponente())) {
                            completo.polinomio.insertarFinal(posicionC,
                                    posicion.getCoeficiente() * posicion2.getCoeficiente(),
                                    posicion.getExponente() + posicion2.getExponente());
                        } else if (posicionC == completo.polinomio.punta) {
                            completo.polinomio.insertarInicio(posicion.getCoeficiente() * posicion2.getCoeficiente(),
                                    posicion.getExponente() + posicion2.getExponente());
                        } else {
                            completo.polinomio.insertarMedio(posicionC, anteriorC,
                                    posicion.getCoeficiente() * posicion2.getCoeficiente(),
                                    posicion.getExponente() + posicion2.getExponente());
                        }
                    }
                    posicion2 = posicion2.getLiga();
                }
                posicion2 = ingreso.polinomio.punta;
                posicion = posicion.getLiga();
            }
                completo.polinomio.redimensionar();
            
        }
        JOptionPane.showMessageDialog(null, "La multiplicacion del polinomio \n" + mostrarNatural()
                + "\ny el polinomio \n" + ingreso.mostrarNatural() + "\nEs: \n" + completo.mostrarNatural());

    }
}
