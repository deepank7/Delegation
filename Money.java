package transactionHandler;
enum Currency { 
	USD, EURO;
	public double conversionRateTo(Currency target) {return 10;}
}

public class Money {
	private double value;
	private Currency currency;
	public Money(double value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	public double getValue() { return value; }
	public void setValue(double value) {
		this.value = value;
	}
	public Currency getCurrency() {
		return this.currency;
	}	
}

// "Getters and Setters are evil", When we expose this code to the client. It makes the code less maintainable.
class Test {
	private static void dispenseFunds(Money amount) {}
	public static void test () {
		Money balance  = new Money(1.0, Currency.EURO);
		Money request = new Money(3.0, Currency.USD);
		double normalizedBalance = balance.getValue() * balance.getCurrency().conversionRateTo(Currency.USD);
		double normalizesRequest = request.getValue() * balance.getCurrency().conversionRateTo(Currency.USD);
		if(normalizedBalance > normalizesRequest) {
			dispenseFunds(request);
		}
	}
}
