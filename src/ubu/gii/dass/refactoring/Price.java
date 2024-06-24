package ubu.gii.dass.refactoring;

public interface Price {
	int getPriceCode();

	int getFrecuentRenterPoints(Movie movie, int _daysRented);

	double getCharge(Rental rental);
}
