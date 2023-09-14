public class Nodo {
   private Nodo liga;
    private int coeficiente;
    private int exponente;
    
    public Nodo(int coeficiente, int exponente) {
        this.liga = null;
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    public Nodo getLiga() {
        return liga;
    }
    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    public int getCoeficiente() {
        return coeficiente;
    }
    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }
    public int getExponente() {
        return exponente;
    }
    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    
}
