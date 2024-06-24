package ubu.gii.dass.refactoring;

public class PriceChildren implements Price{

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}
	
	@Override
	public double getCharge(Rental rental) {
		double thisAmount = 0;
		thisAmount += 1.5;
		if (rental.getDaysRented() > 3) {
			thisAmount += (rental.getDaysRented() - 3) * 1.5;
		}		
		return thisAmount;
	}


}
