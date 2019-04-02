// Rental class
public class Rental
{
	// movie and the # of days rented
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented)
	{
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public double charge()
	{
		return movie.charge(daysRented);
	}
	
	// calculates points for rental
	public int frequentRenterPoints()
	{
		int points = 1;
		
		if (movie.isNewRelease() && daysRented > 1)
		{
			points++;
		}
		
		return points;
	}
	
	public String rentalLine(Report report)
	{	
		 return report.rentalLine(daysRented, movie.getTitle(), charge());
	}
}
