package ubu.gii.dass.refactoring;

public class PriceNewRelease implements Price{

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	public double getCharge(Rental rental) {
		double thisAmount = 0;
		thisAmount += rental.getDaysRented() * 3;
		return thisAmount;
	}
	
	@Override
	public int getFrecuentRenterPoints(Movie movie, int _daysRented) {
		// add frequent renter points
		int frequentRenterPoints=1;
		// add bonus for a two day new release rental
		if (_daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}


}
