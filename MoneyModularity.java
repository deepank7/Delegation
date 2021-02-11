package transactionHandler;
enum CurrencyMod { 
	USD, EURO;
	public double conversionRateTo(CurrencyMod target) {return 10;}
}
public class MoneyModularity {
	private double value;
	private CurrencyMod currency;
	public MoneyModularity(double value, CurrencyMod currency) {
		this.value = value;
		this.currency = currency;
	}
	public double getValue() { return value; }
	public void setValue(double value) {
		this.value = value;
	}
	public CurrencyMod getCurrency() {
		return this.currency;
	}	
	private double normalized() {
		return currency == CurrencyMod.USD 
				? value : value * currency.conversionRateTo(CurrencyMod.USD);
	}
	
	public boolean isGreaterThan (MoneyModularity op) {
		return (normalized() > op.normalized());
	}
}
// Here the concept of Delegation is implemented. The object that has the information handles the work.
class Client {
	private static void dispenseFunds(MoneyModularity amount) {}
	public static void test () {
		MoneyModularity balance  = new MoneyModularity(1.0, CurrencyMod.EURO);
		MoneyModularity request = new MoneyModularity(3.0, CurrencyMod.USD);
		if(balance.isGreaterThan(request)) {
			dispenseFunds(request);
		}
	}
}

