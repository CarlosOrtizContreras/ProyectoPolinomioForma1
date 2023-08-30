import javax.swing.JOptionPane;

public class Polinomio {
    int [] vector;
    int du;

    Polinomio(int[] vec) {
        int t = vec[1];
        for(int i = 1; i < vec.length; i=i+2){
            if (t < vec[i]){
                t = vec[i];
            }
        }
        this.vector = new int[t+2];
        this.vector[0]= t;
        this.du = t+1;
        Llenado(vec);
    }
    Polinomio( int g) {
        
        this.vector = new int[g+2];
        this.vector[0]= g;
        this.du = g+1;
    }

    private void Llenado( int [] vec){
        for(int i = 1; i < vec.length; i = i+2 ){
            vector[du-vec[i]] = vector[du-vec[i]]+ vec[i-1];
        }
    }

    void MostrarVector (){
        String s = "";
        for (int i = 1; i < vector.length; i++ ){
            s = s +"["+ vector[i] + "]";
        }
        JOptionPane.showMessageDialog(null, "   *** El vector Es ***   \n" + s);
    }

    String MostrarNatural(){
        String s = "";
        for (int i =1; i< vector.length; i++){
            if(vector[i] !=0){
                s = s + vector[i];
                if (du - i == 1){
                    s = s + "x";
                } else if  (du-i == 0){
                    s = s + vector[i];
                }else {
                   s = s + "x^" + (du - i);
                }
                
            }
        }
        return s;
    }

    void Suma (Polinomio poli){
        int g;
        if (vector[0] > poli.vector[0]){
            g = vector[0];
            
        }else{
            g = poli.vector[0];
        }
        Polinomio suma = new Polinomio(g);

        for(int i = 1; i < g +2; i++ ){
            if (i < vector.length){
                int exp = du - i;
                suma.vector[suma.du - exp] = suma.vector[suma.du - exp]+ vector[i];
            }
            if (i < poli.vector.length){
                int exp = poli.du - i;
                suma.vector[suma.du - exp] = suma.vector[suma.du - exp]+ poli.vector[i];
            }
        }

        JOptionPane.showMessageDialog(null,"   *** El polinomio 1 es: ***   \n" + MostrarNatural() + "\n   *** El polinomio 2 es: ***   \n" + poli.MostrarNatural() + "\n   *** La suma es: ***   \n" + suma.MostrarNatural());
        
    }

    void Restar (Polinomio poli){
        int g;
        if (vector[0] > poli.vector[0]){
            g = vector[0];
            
        }else{
            g = poli.vector[0];
        }
        Polinomio resta = new Polinomio(g);

        for(int i = 1; i < g +2; i++ ){
            if (i < vector.length){
                int exp = du - i;
                resta.vector[resta.du - exp] = resta.vector[resta.du - exp]+ vector[i];
            }
            if (i < poli.vector.length){
                int exp = poli.du - i;
                resta.vector[resta.du - exp] = resta.vector[resta.du - exp]- poli.vector[i];
            }
        }

        JOptionPane.showMessageDialog(null,"   *** El polinomio 1 es: ***   \n" + MostrarNatural() + "\n   *** El polinomio 2 es: ***   \n" + poli.MostrarNatural() + "\n   *** La resta es: ***   \n" + resta.MostrarNatural());
        
    }
}
