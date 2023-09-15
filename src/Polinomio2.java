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
        Llenadof2(vector, mayor);
    }

    public Polinomio2(int t) {
        this.vector = new int[t * 2 + 1];
        this.vector[0] = t;
        this.du = (t * 2);
    }

    private void Llenadof2(int[] vec, int mayor) {
        int exponente = 0;
        int k=1;
        while (mayor >= 0) {
            for (int i = 1; i < vec.length; i = i + 2) {
                exponente = vec[i];
                if (exponente==mayor){
                    vector[k]=vector[k]+vec[i-1];
                    vector[k+1]=vec[i];
                }
            }
            mayor=mayor-1;
            k=k+2;
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
        Polinomio2 suma = new Polinomio2(t);
        while (i < vector.length && i < Poli.vector.length) {
            if (vector[i] > Poli.vector[i]) {
                suma.vector[k] = vector[i - 1];
                k++;
                suma.vector[k] = vector[i];
                k++;
            } else if (Poli.vector[i] > vector[i]) {
                suma.vector[k] = Poli.vector[i - 1];
                k++;
                suma.vector[k] = Poli.vector[i];
                k++;
            } else if (Poli.vector[i] == vector[i]) {
                suma.vector[k] = Poli.vector[i - 1] + vector[i - 1];
                k++;
                suma.vector[k] = Poli.vector[i];
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
        if (i < Poli.vector.length) {
            while (i < Poli.vector.length) {
                suma.vector[k] = Poli.vector[i - 1];
                k++;
                suma.vector[k] = Poli.vector[i];
                k++;
                i++;
            }
        }
        int cont = 0;
        for (i = 2; i < suma.vector.length; i = i + 2) {
            if (suma.vector[i - 1] != 0) {
                cont = cont + 1;
            }
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
        int i = 1, k = 1;
        nuevo = new int[t * 2 + 1];
        nuevo[0] = t;
        while (i < t * 2 + 1) {
            if (i % 2 != 0 && vector[k] == 0) {
                k = k + 2;
            } else {
                nuevo[i] = vector[k];
                i++;
                k++;
            }

        }
        vector = nuevo;
    }

    void EvaluarF2() {
        int x = 0, coeficiente = 0, Exponente = 0, Resultado = 0;
        x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que tendrá la X"));
        for (int i = 1; i <= du; i = i + 2) {
            coeficiente = vector[i];
            Exponente = vector[i + 1];
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

    void EliminarF2() {
        int Exponente = 0, i = 2;
        boolean Encontrado = false;
        Exponente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente que desea eliminar"));
        for (i = 2; i < du || vector[i] == Exponente; i = i + 2) {
            if (vector[i] == Exponente) {
                vector[i - 1] = 0;
                vector[i] = 0;
                Encontrado = true;
            }
        }
        if (Encontrado) {
            int cont = vector[0] - 1;
            Redimensionar(cont);
        } else {
            JOptionPane.showMessageDialog(null, "   *** Coeficiente no encontrado***  \n ");
        }
        JOptionPane.showMessageDialog(null, "   *** Coeficiente eliminado con exito***  \n ");
    }

    Polinomio2 Insertar(int[] vec) {
        int t = (vector[0] + 1) * 2;
        int[] resultante = new int[t];
        for (int i = 0; i < vec.length; i++) {
            resultante[i] = vec[i];
        }
        int k = 2;
        for (int j = 1; j < vector.length; j++) {
            resultante[k] = vector[j];
            k++;
        }
        Polinomio2 nuevo = new Polinomio2(resultante);
        return nuevo;
    }

    void Multiplicarf2(Polinomio2 poli) {
        int g = vector[0] * poli.vector[0];
        int vec[] = new int[g * 2];
        int u = 0;
        for (int i = 1; i < poli.vector.length; i = i + 2) {
            if (poli.vector[i] != 0) {
                for (int k = 1; k < vector.length; k = k + 2) {
                    if (vector[k] != 0) {
                        vec[u] = poli.vector[i] * vector[k];
                        u++;
                        vec[u] = poli.vector[i + 1] + vector[k + 1];
                        u++;
                    }
                }
            }
        }
        Polinomio2 Multiplicar = new Polinomio2(vec);
        JOptionPane.showMessageDialog(null,
                "   *** El polinomio 1 es: ***   \n" + MostrarNatural2() + "\n   *** El polinomio 2 es: ***   \n"
                        + poli.MostrarNatural2() + "\n   *** La Multiplicacion es: ***   \n"
                        + Multiplicar.MostrarNatural2());
    }
}
