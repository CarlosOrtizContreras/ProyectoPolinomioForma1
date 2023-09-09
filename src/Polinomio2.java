import javax.swing.JOptionPane;

public class Polinomio2 {
    int[] vector;
    int du;

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
    }

    Polinomio2(int[] vector) {
        int t = 0, mayor = -1, exp = 0, k = 0;
        boolean Encontrado = false;
        int[] Nuevo = new int[vector.length / 2];
        for (int i = 1; i < vector.length; i = i + 2) {
            Nuevo[k] = vector[i];
            k++;
        }
        for (int j = 0; j < Nuevo.length; j++) {
            if (mayor < Nuevo[j]) {
                mayor = Nuevo[j];
            }
        }
        while (exp <= mayor) {
            for (int i = 0; i < Nuevo.length; i++) {
                if (Nuevo[i] == exp) {
                    Encontrado = true;
                }
            }
            if (Encontrado == true) {
                t = t + 1;
            }
            exp = exp + 1;
            Encontrado = false;
        }
        this.vector = new int[t * 2 + 1];
        this.vector[0] = t;
        this.du = t * 2;
        Llenadof2(vector);
    }

    public Polinomio2(int t) {
        this.vector = new int[t * 2 + 1];
        this.vector[0] = t;
        this.du = (t * 2);
    }

    private void Llenadof2(int[] vec) {
        int Posicion = 0;
        for (int i = 1; i < vec.length; i = i + 2) {
            Posicion = du - 1 - vec[i];
            if (vec[i] == 0) {
                vector[Posicion] = vector[Posicion] + vec[i - 1];
                Posicion = Posicion + 1;
                vector[Posicion] = vec[i];
            } else {
                vector[Posicion - 1] = vector[Posicion - 1] + vec[i - 1];
                vector[Posicion] = vec[i];
            }
        }

    }

    void MostrarVectorf2() {
        String s = "";
        for (int i = 1; i < vector.length; i++) {
            s = s + "[" + vector[i] + "]";
        }
        JOptionPane.showMessageDialog(null, "   *** El vector forma 2 Es ***   \n" + s);
    }

    String MostrarNatural2() {
        String s = "";
        for (int i = 1; i < vector.length; i = i + 2) {
            if (vector[i] != 0) {
                if (vector[i] > 0 & i != 1) {
                    s = s + "+" + vector[i];
                } else {
                    s = s + vector[i];
                }

                if (du - vector[i + 1] == 1) {
                    s = s + "x";
                } else if (du - vector[i + 1] == 0) {
                    continue;
                } else {
                    s = s + "x^" + vector[i + 1];
                }

            }
        }
        return s;
    }

    void SumaF2(Polinomio2 Poli) {
        int t = vector[0] + Poli.vector[0], k = 1, i = 2;
        int[] Aux = new int[Poli.getDu() + 1];
        Aux = getVector();
        Polinomio2 suma = new Polinomio2(t);
        while (i < vector.length && i < Aux.length) {
            if (vector[i] > Aux[i]) {
                suma.vector[k] = vector[i - 1];
                k++;
                suma.vector[k] = vector[i];
                k++;
            } else if (Aux[i] > vector[i]) {
                suma.vector[k] = Aux[i - 1];
                k++;
                suma.vector[k] = Aux[i];
                k++;
            } else if (Aux[i] == vector[i]) {
                suma.vector[k] = Aux[i - 1] + vector[i - 1];
                k++;
                suma.vector[k] = Aux[i];
                k++;
            }
            i = i + 2;
        }
        if (i < vector.length) {
            while (i < vector.length) {
                suma.vector[k] = vector[i - 1];
                k++;
                suma.vector[k] = vector[i];
                k++;
                i++;
            }
        }
        if (i < Aux.length) {
            while (i < Aux.length) {
                suma.vector[k] = Aux[i - 1];
                k++;
                suma.vector[k] = Aux[i];
                k++;
                i++;
            }
        }
        int cont = 0;
        i = suma.du - 1;
        while (i <= 0 && suma.vector[i] == 0 && suma.vector[i - 1] == 0) {
            cont++;
            i--;
        }
        suma.Redimensionar(cont);

        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural2() + "\n   *** El polinomio 2 es: ***   \n"
                        + Poli.MostrarNatural2() + "\n   *** La suma es: ***   \n" + suma.MostrarNatural2());

    }

    void RestaF2(Polinomio2 Poli) {
        int t = vector[0] + Poli.vector[0], k = 1, i = 2;
        int[] Aux = new int[Poli.getDu() + 1];
        Aux = getVector();
        Polinomio2 resta = new Polinomio2(t);
        while (i < vector.length && i < Aux.length) {
            if (vector[i] > Aux[i]) {
                resta.vector[k] = vector[i - 1];
                k++;
                resta.vector[k] = vector[i];
                k++;
            } else if (Aux[i] > vector[i]) {
                resta.vector[k] = Aux[i - 1];
                k++;
                resta.vector[k] = Aux[i];
                k++;
            } else if (Aux[i] == vector[i]) {
                resta.vector[k] = vector[i - 1] - Aux[i - 1];
                k++;
                resta.vector[k] = Aux[i];
                k++;
            }
            i = i + 2;
        }
        if (i < vector.length) {
            while (i < vector.length) {
                resta.vector[k] = vector[i - 1];
                k++;
                resta.vector[k] = vector[i];
                k++;
                i++;
            }
        }
        if (i < Aux.length) {
            while (i < Aux.length) {
                resta.vector[k] = Aux[i - 1];
                k++;
                resta.vector[k] = Aux[i];
                k++;
                i++;
            }
        }
        int cont = 0;
        i = resta.du - 1;
        while (i <= 0 && resta.vector[i] == 0 && resta.vector[i - 1] == 0) {
            cont++;
            i--;
        }
        resta.Redimensionar(cont);

        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural2() + "\n   *** El polinomio 2 es: ***   \n"
                        + Poli.MostrarNatural2() + "\n   *** La Resta es: ***   \n" + resta.MostrarNatural2());

    }
    void Redimensionar(int t) {
        int[] nuevo;
        int i = 1;
        nuevo = new int[du - t];
        while (i < du) {
            nuevo[i] = vector[i];
            i++;
        }

    }
    
    void EvaluarF2 (){
        int x = 0, coeficiente = 0, Exponente = 0, Resultado = 0;
        x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que tendrá la X"));
        for (int i = 1; i <= du; i=i+2) {
            coeficiente = vector[i];
            Exponente = vector[i+1];
            Resultado = Resultado + (coeficiente * Potencia(x, Exponente));
        }
        JOptionPane.showMessageDialog(null, "   *** El polinomio Es:***  \n " + MostrarNatural2() + "\nLa ´X´ Es: " + x
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

}
