package MIDTERMS_HANDSON;
import java.util.Scanner;

import CConverter.CurrencyConverter;
import Serviceconverter.CCservice;

public class Application {


	int ch;
	String again;
	Scanner sc= new Scanner(System.in);

	public void displayMenu(){
	
		System.out.println("---------------main menu----------------");
	
		System.out.println("	1. Instruction					 ");
		System.out.println("	2. Converter	 				 ");
		System.out.println("	3. Exit	 				 		 ");
		System.out.println("---------------reminder-----------------");
		System.out.println("the instructions are very important so\nplease read");
		System.out.println("----------------------------------------");
		System.out.println("What do you pick?");
	}


	public void order()
	{
		while(true){
			System.out.print("Enter a Number: ");
			ch = sc.nextInt();
			switch (ch){
				case 1://Instruction
				System.out.println("instructions*");
				System.out.println("you have to type which code from the converter to use waht conversion wou will use ");
				break;

				case 2://Converter
				System.out.println("currency converter");
				System.out.println("Convert your money to \nPeso to Dollar(PTD)\nDollar to Peso(DTP)\nPeso to Euro(PTE)\nEuro to Peso(ETP)");
				System.out.println("Select Currency to convert:");
				String currency = sc.next();
				

				System.out.println("Enter Amount:");
				Double amount = sc.nextDouble();
				
				CurrencyConverter converter = new CurrencyConverter(currency,amount);
				CCservice converterService = new CCservice();
				
				Boolean flag= converterService.currencyConverter(converter);
				
				if(flag)
				System.out.println("Converted Amount : "+converterService.getConvertedAmount()+" "+currency);
				break;

	

				case 3://Exit
				System.exit(1);
				break;

				default:
					break;
			}
			System.out.println();
			System.out.println("Do you wish to pick again? (Y/N) : ");
			again = sc.next();
			if(again.equalsIgnoreCase("Y"))
			{order();}
			else if (again.equalsIgnoreCase("N"))
			{
			System.exit(1);}
			else{System.out.println("Invalid Choice");}
		}
	}
}




