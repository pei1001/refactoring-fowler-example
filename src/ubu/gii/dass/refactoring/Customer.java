package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	 private Vector<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new Vector<>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
        return generateStatement("text");
    }

    public String htmlStatement() {
    	System.out.println(generateStatement("html"));
        return generateStatement("html");
    }

    private String generateStatement(String format) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = formatHeader(format);
        
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = each.getCharge();
            frequentRenterPoints += each.getFrecuentRenterPoints();
            result += formatRentalLine(format, each, thisAmount);
            totalAmount += thisAmount;
        }

        result += formatFooter(format, totalAmount, frequentRenterPoints);
        return result;
    }

    private String formatHeader(String format) {
        if (format.equals("html")) {
            return "<H1>Rental Record for " + getName() + "</H1>";
        } else {
            return "Rental Record for " + getName() + "\n";
        }
    }

    private String formatRentalLine(String format, Rental rental, double amount) {
        if (format.equals("html")) {
            return "<H2>" + rental.getMovie().getTitle() + " " + amount + "</H2>";
        } else {
            return "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
        }
    }

    private String formatFooter(String format, double totalAmount, int frequentRenterPoints) {
        if (format.equals("html")) {
            return "<P>Amount owed is " + totalAmount + "</P>"
                 + "<P> You earned " + frequentRenterPoints + " frequent renter points </P>";
        } else {
            return "Amount owed is " + totalAmount + "\n"
                 + "You earned " + frequentRenterPoints + " frequent renter points";
        }
    }
}
