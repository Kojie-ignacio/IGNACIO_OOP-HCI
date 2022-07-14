package Serviceconverter;
import CConverter.CurrencyConverter;
public class CCservice {
    Double convertedAmount = 0d;
	public Boolean currencyConverter(CurrencyConverter currencyConverter) {
		String currency = currencyConverter.getCurrency();
		Double amount = currencyConverter.getAmount();
		Double rate=0d;
		Boolean flag = true;
		if(currency.equalsIgnoreCase("PTD")) {
			rate=0.018;  				// 1 Peso = 0.018 USD Dollar
		}else if(currency.equalsIgnoreCase("DTP")) {
			rate=56.40;					// 1 Dollar = 56.38 Peso 
		}else if(currency.equalsIgnoreCase("PTE")) {
			rate=0.018; 				// 1 Peso = 0.018 Euro
		}else if(currency.equalsIgnoreCase("ETP")) {
			rate = 56.54;				// 1 Euro= 56.57 Peso
		}else {
			flag= false;	
			System.out.println("Currency not Supported !");
		}
		convertedAmount= amount*rate;
		return flag;
	}
	public Double getConvertedAmount() {
		return convertedAmount;
	}
}
