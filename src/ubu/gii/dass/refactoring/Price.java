package ubu.gii.dass.refactoring;

public interface Price {
	int getPriceCode();

	default int getFrecuentRenterPoints(Movie movie, int _daysRented) {
		// add frequent renter points
		int frequentRenterPoints=1;
		// add bonus for a two day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	default double getCharge(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
}
