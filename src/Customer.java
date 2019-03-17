import java.util.*;

public class Customer
{
	private String name;
	private List rentals = new ArrayList();

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

	
	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator rentalIterator = rentals.iterator();
		String result = "Rentals: " + getName() + "\n";
		while (rentalIterator.hasNext())
		{
			Rental each = (Rental) rentalIterator.next();
			double thisAmount = each.charge();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += each.getDaysRented() + " days of '" + each.getMovie().getTitle() + "' $"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Total = $" + totalAmount + "\n";
		result += "Frequent renter points = " + frequentRenterPoints + "\n";
		return result + "---\n";
	}

}
