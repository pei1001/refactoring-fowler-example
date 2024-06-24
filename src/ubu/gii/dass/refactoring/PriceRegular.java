package ubu.gii.dass.refactoring;

public class PriceRegular implements Price{

	@Override
	public int getPriceCode() {
		
		return Movie.REGULAR;
	}
	
	@Override
	public double getCharge(Rental rental) {
		double thisAmount = 0;		
		thisAmount += 2;
		if (rental.getDaysRented() > 2) {
				thisAmount += (rental.getDaysRented() - 2) * 1.5;			
		}
		return thisAmount;
	}

}
