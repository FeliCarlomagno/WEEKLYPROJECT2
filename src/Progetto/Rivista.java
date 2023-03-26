package Progetto;

public class Rivista extends ElementoCatalogo {
	
	private Periodicità periodicità;
	
	public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
	    this.periodicità = periodicità;
	}
	
	//GETTERS:
	public Periodicità getPeriodicità() {
	    return periodicità;
	}
	
	//SETTER:
    public void setPeriodicita(Periodicità periodicità) {
	        this.periodicità = periodicità;
	    }
	
	@Override
    public String toString() {
        return super.toString() + ", Periodicità: " + periodicità;
    }
}
