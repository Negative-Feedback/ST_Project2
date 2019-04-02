import java.util.*;

// Customer class
public class Customer
{
	// Name of customer and list of thier rentals
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void addRental(Rental arg)
	{
		rentals.add(arg);
	}
	
	// Creates bill for the customer in text
	public String statement()
	{
		return statement(new TextReport());
	}
	
	// Creates bill for the customer in html 
	public String htmlStatement()
	{
		return statement(new HtmlReport());
	}
	
	// Calculates the the cost for the statement
	public String statement(Report report)
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = report.headerLine(getName());
		
		for (Rental rental : rentals)
		{
			double thisAmount = rental.charge();
			
			frequentRenterPoints += rental.frequentRenterPoints();

			result += rental.rentalLine(report);
			
			totalAmount += thisAmount;
		}

		// add footer lines
		result += report.footerLine(totalAmount, frequentRenterPoints);
		return result;
	}
	

}
