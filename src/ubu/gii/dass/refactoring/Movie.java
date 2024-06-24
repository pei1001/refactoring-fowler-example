package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	Price _priceCode;
	

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _priceCode.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg){
		case REGULAR: 
			_priceCode = new PriceRegular();
			break;
		case CHILDRENS:
			_priceCode = new PriceChildren();
			break;
		case NEW_RELEASE:
			_priceCode = new PriceNewRelease();
			break;

		default:
			throw new IllegalArgumentException("Incorrect PriceCode");            
		}
	}

	public String getTitle() {
		return _title;
	}

	public int getFrecuentRenterPoints(int _daysRented) {
		return _priceCode.getFrecuentRenterPoints(this, _daysRented);
	}
}
