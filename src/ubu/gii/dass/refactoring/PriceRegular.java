package ubu.gii.dass.refactoring;

public class PriceRegular implements Price{

	@Override
	public int getPriceCode() {
		
		return Movie.REGULAR;
	}

}
