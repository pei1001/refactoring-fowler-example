package ubu.gii.dass.refactoring;

public class PriceNewRelease implements Price{

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

}
