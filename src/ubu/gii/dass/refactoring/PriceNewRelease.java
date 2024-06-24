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

}
