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

	double getCharge(Rental rental);
}
