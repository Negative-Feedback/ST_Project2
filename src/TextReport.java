// implementation of Report interface
public class TextReport implements Report
{
	// Empty constructor
	public TextReport()
	{
	}
	
	
	public String headerLine(String name)
	{
		return "Rentals: " + name + "\n";
	}
	
	public String footerLine(double total, int fPoints)
	{
		return "Total = $" + total + "\n" + "Frequent renter points = " + fPoints + "\n" + "---\n";
	}
	
	public String rentalLine(int daysRented, String movieTitle, double charge)
	{
		return daysRented + " days of '" + movieTitle + "' $" + charge + "\n";
	}
}
