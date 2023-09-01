import javax.swing.JOptionPane;

public class Polinomio {
    int[] vector;
    int du;

    Polinomio(int[] vec) {
        int t = vec[1];
        for (int i = 1; i < vec.length; i = i + 2) {
            if (t < vec[i]) {
                t = vec[i];
            }
        }
        this.vector = new int[t + 2];
        this.vector[0] = t;
        this.du = t + 1;
        Llenado(vec);
    }

    Polinomio(int g) {

        this.vector = new int[g + 2];
        this.vector[0] = g;
        this.du = g + 1;
    }

    private void Llenado(int[] vec) {
        for (int i = 1; i < vec.length; i = i + 2) {
            vector[du - vec[i]] = vector[du - vec[i]] + vec[i - 1];
        }
    }

    void MostrarVector() {
        String s = "";
        for (int i = 1; i < vector.length; i++) {
            s = s + "[" + vector[i] + "]";
        }
        JOptionPane.showMessageDialog(null, "   *** El vector Es ***   \n" + s);
    }

    String MostrarNatural() {
        String s = "";
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] != 0) {
                if (vector[i] > 0 & i != 1) {
                    s = s + "+" + vector[i];
                } else {
                    s = s + vector[i];
                }

                if (du - i == 1) {
                    s = s + "x";
                } else if (du - i == 0) {
                    continue;
                } else {
                    s = s + "x^" + (du - i);
                }

            }
        }
        return s;
    }

    void Suma(Polinomio poli) {
        int g;
        if (vector[0] > poli.vector[0]) {
            g = vector[0];

        } else {
            g = poli.vector[0];
        }
        Polinomio suma = new Polinomio(g);

        for (int i = 1; i < g + 2; i++) {
            if (i < vector.length) {
                int exp = du - i;
                suma.vector[suma.du - exp] = suma.vector[suma.du - exp] + vector[i];
            }
            if (i < poli.vector.length) {
                int exp = poli.du - i;
                suma.vector[suma.du - exp] = suma.vector[suma.du - exp] + poli.vector[i];
            }
        }

        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural() + "\n   *** El polinomio 2 es: ***   \n"
                        + poli.MostrarNatural() + "\n   *** La suma es: ***   \n" + suma.MostrarNatural());

    }

    void Restar(Polinomio poli) {
        int g;
        if (vector[0] > poli.vector[0]) {
            g = vector[0];

        } else {
            g = poli.vector[0];
        }
        Polinomio resta = new Polinomio(g);

        for (int i = 1; i < g + 2; i++) {
            if (i < vector.length) {
                int exp = du - i;
                resta.vector[resta.du - exp] = resta.vector[resta.du - exp] + vector[i];
            }
            if (i < poli.vector.length) {
                int exp = poli.du - i;
                resta.vector[resta.du - exp] = resta.vector[resta.du - exp] - poli.vector[i];
            }
        }

        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural() + "\n   *** El polinomio 2 es: ***   \n"
                        + poli.MostrarNatural() + "\n   *** La resta es: ***   \n" + resta.MostrarNatural());

    }

    void Evaluar() {
        int x = 0, coeficiente = 0, Exponente = 0, Resultado = 0;
        x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que tendrá la X"));
        for (int i = 1; i <= du; i++) {
            coeficiente = vector[i];
            Exponente = du - i;
            Resultado = Resultado + (coeficiente * Potencia(x, Exponente));
        }
        JOptionPane.showMessageDialog(null, "   *** El polinomio Es:***  \n " + MostrarNatural() + "\nLa ´X´ Es: " + x
                + "\nEl resultado es: " + Resultado);
    }

    private int Potencia(int x, int Exponente) {
        if (Exponente == 0) {
            return 1;
        } else if (Exponente < 0) {
            return (Potencia(x, Exponente + 1)) / x;
        } else {
            return x * Potencia(x, Exponente - 1);
        }

    }

    void Multiplicar(Polinomio poli) {
        int g = vector[0] + poli.vector[0];
        Polinomio multiplicar = new Polinomio(g);
        for (int i = 1; i < poli.vector.length; i++) {
            if (poli.vector[i] != 0) {
                for (int k = 1; k < vector.length; k++) {
                    if (vector[k] != 0) {
                        int exp1 = poli.du - i;
                        int exp2 = du - k;

                        multiplicar.vector[multiplicar.du
                                - (exp1 + exp2)] = multiplicar.vector[multiplicar.du - (exp1 + exp2)]
                                        + (poli.vector[i] * vector[k]);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural() + "\n   *** El polinomio 2 es: ***   \n"
                        + poli.MostrarNatural() + "\n   *** La Multiplicacion es: ***   \n"
                        + multiplicar.MostrarNatural());
    }

     Polinomio Insertar(int[] vec) {
        Polinomio nuevo = new Polinomio(vec);
        int g;
        if (nuevo.vector[0] > vector[0]) {
            g = nuevo.vector[0];
        } else {
            g = vector[0];
        }
        Polinomio todo = new Polinomio(g);

        for (int i = 1; i < g + 2; i++) {
            if (i < vector.length) {
                int exp = du - i;
                todo.vector[todo.du - exp] = todo.vector[todo.du - exp] + vector[i];
            }
            if (i < nuevo.vector.length) {
                int exp = nuevo.du - i;
                todo.vector[todo.du - exp] = todo.vector[todo.du - exp] + nuevo.vector[i];
            }
        }
        return todo;

    }

    void Ajustar() {
        int cont = 0, i = 2;
        while (i <= du && vector[i] == 0) {
            cont++;
            i++;
        }
        while (i <= du) {
            vector[i - cont] = vector[i];
            i++;
        }
        du = du - cont;
        redimencionar();
    }

    void redimencionar() {
        int[] nuevo;
        int i = 1;
        nuevo = new int[du + 1];
        while (i < du) {
            nuevo[i] = vector[i];
            i++;
        }
        Ajustar();
    }

    void Eliminar() {
        int Exponente = 0, i = 0;
        Exponente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente que desea eliminar"));
        if (vector[0] >= Exponente) {
            i++;
            while (i < du || (du - i) == Exponente) {
                i++;
                if ((du - i) == Exponente) {
                    if (vector[i] == 0) {
                        JOptionPane.showMessageDialog(null, "Posicion vacia no se puede eliminar");
                    } else {
                        vector[i] = 0;
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El grado del polinomio es menor");
        }
        i=1;
        if (vector[i]==0){
            redimencionar();
        }
    }
}
