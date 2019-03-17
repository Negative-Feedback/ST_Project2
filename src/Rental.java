public class Rental
{

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented)
	{
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return daysRented;
	}

	public Movie getMovie()
	{
		return movie;
	}
	
	public double charge()
	{
		double charge = 0;
		// determine amounts for each line

		switch (getMovie().getPriceCode())
		{
			case Movie.REGULAR:
				charge += 2;
				if (getDaysRented() > 2)
					charge += (getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				charge += getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				charge += 1.5;
				if (getDaysRented() > 3)
					charge += (getDaysRented() - 3) * 1.5;
				break;
		}
		
		return charge;
	}
}
