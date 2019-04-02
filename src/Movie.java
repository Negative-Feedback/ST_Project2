// Movie class
public class Movie
{
	// Rental costs
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	// title and price of movie
	private String title;
	private int priceCode;

	// Movie constructor
	public Movie(String title, int priceCode)
	{
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode()
	{
		return priceCode;
	}

	public void setPriceCode(int arg)
	{
		priceCode = arg;
	}

	public String getTitle()
	{
		return title;
	}
	
	public boolean isNewRelease()
	{
		if(priceCode == NEW_RELEASE)
		{
			return true;
		}
		
		return false;
	}
	
	// calculates cost of rental
	public double charge(int daysRented)
	{
		double charge = 0;
		// determine amounts for each line

		switch (priceCode)
		{
			case Movie.REGULAR:
				charge += 2;
				if (daysRented > 2)
					charge += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				charge += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				charge += 1.5;
				if (daysRented > 3)
					charge += (daysRented - 3) * 1.5;
				break;
		}
		
		return charge;
	}
	
}
