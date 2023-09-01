
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Polinomio funcional = new Polinomio(Coeficiente_Exponente());
        boolean controlMenu = true;

        do {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "   ***** Bienvenido al Menu de Polinomios *****   \n         Que accion desea ejecutar?          \n"
                            + "1. Mostrar Forma Vector \n"
                            + "2. Mostrar Forma Natural\n"
                            + "3. Operaciones con Polinomios\n"
                            + "4. Evaluar Polinomio\n"
                            + "5. Insertar Monomio\n"
                            + "6. Salir"));

            switch (opcion) {
                case 1:
                    funcional.MostrarVector();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "   *** El polinomio es: ***   \n" + funcional.MostrarNatural());
                    break;

                case 3:
                    Polinomio poli = new Polinomio(Coeficiente_Exponente());
                    boolean controlOperaciones = true;
                    do {
                        int opcionOp = Integer.parseInt(JOptionPane.showInputDialog(
                                "     ***** Bienvenido al Menu Operaciones *****     \n            Que Operacion desea Realizar?          \n"
                                        + "1. Suma de Polinomios \n"
                                        + "2. Resta de Polinomios\n"
                                        + "3. Multiplicacion de Polinomios\n"
                                        + "4. Salir"));

                        switch (opcionOp) {
                            case 1:
                                funcional.Suma(poli);
                                break;

                            case 2:
                                funcional.Restar(poli);
                                break;

                            case 3:
                                funcional.Multiplicar(poli);
                                break;

                            case 4:
                                controlOperaciones = false;
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                break;

                        }
                    } while (controlOperaciones);
                    break;
                case 4:
                    funcional.Evaluar();
                    break;

                case 5:
                    funcional = funcional.Insertar(Coeficiente_Exponente());
                    break;

                case 6:
                    controlMenu = false;
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema: ");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una Opcion Valida: ");
                    break;
            }
        } while (controlMenu);

    }

    static int[] Coeficiente_Exponente() {
        boolean controlPoli = true;
        String cadena = "";
        do {
            cadena = "-7x^4+2x+2";
            if (cadena != "") {
                controlPoli = false;
            }
        } while (controlPoli);

        String s = "";
        int k = 0;
        char[] vectorCaracter = cadena.toCharArray();
        String[] vectorString = new String[vectorCaracter.length * 2];

        for (int i = 0; i < vectorCaracter.length; i++) {
            if (Character.isDigit(vectorCaracter[i]) | vectorCaracter[i] == '-' | vectorCaracter[i] == '+') {
                if (s != "" && (vectorCaracter[i] == '+' | vectorCaracter[i] == '-')) {
                    vectorString[k] = s;
                    k++;
                    vectorString[k] = "0";
                    k++;
                    s = "";

                    s = s + vectorCaracter[i];

                } else {
                    s = s + vectorCaracter[i];
                    if (i == vectorCaracter.length - 1) {
                        vectorString[k] = s;
                        k++;
                        vectorString[k] = "0";
                    }
                }

            } else if (vectorCaracter[i] == 'x') {

                if (s == "-" || s == "+") {
                    s = s + "1";
                }
                vectorString[k] = s;
                k++;

                s = "";
                if (vectorCaracter[i] == 'x' & i == vectorCaracter.length - 1) {
                    vectorString[k] = "1";
                } else if (vectorCaracter[i] == 'x' & vectorCaracter[i + 1] == '^') {
                    i = i + 2;

                    s = s + vectorCaracter[i];
                    while (Character.isDigit(vectorCaracter[i + 1])) {
                        i++;
                        s = s + vectorCaracter[i];
                    }
                    vectorString[k] = s;
                    s = "";
                    k++;
                } else {
                    vectorString[k] = "1";
                    k++;
                }
            }

        }

        int cont = 0;
        for (String dato : vectorString) {
            if (dato != null) {
                cont++;
            }
        }
        int[] vector = new int[cont];

        for (int i = 0; i < cont; i++) {

            if ((vectorString[i].indexOf("-") != -1 || vectorString[i].indexOf("+") != -1)
                    && vectorString[i].length() == 1) {
                if (vectorString[i] == "-") {
                    vector[i] = -1;
                } else {
                    vector[i] = 1;
                }

            } else {
                vector[i] = Integer.parseInt(vectorString[i]);
            }
        }
        return vector;
    }

}