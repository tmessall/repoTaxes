import java.util.Scanner;

public class taxCode{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int salary;
		int dependents;
		int age;


		System.out.println("What is your annual salary?");
		salary = scan.nextInt();
		System.out.println("How many child dependents do you have?");
		dependents = scan.nextInt();
		System.out.println("How old are you?");
		age = scan.nextInt();


		int dependentsReturns;
		if (dependents > 2.5){
			dependentsReturns = 1000 + 500 * (dependents - 1);
		} else if (dependents > 0){
			dependentsReturns = 1000;
		} else {
			dependentsReturns = 0;
		}


		if (salary < 10000){
			System.out.println("You get $" + dependentsReturns + " in welfare.");
		}


		double marginalTaxes = 0;
		boolean tier5 = false;
		boolean tier4 = false;
		boolean tier3 = false;
		boolean tier2 = false;
		if (salary > 250000){
			marginalTaxes = .5 * (salary - 250000);
			salary = salary - (salary - 250000);
			tier5 = true;
		} 
		if (salary > 75000){
			marginalTaxes = marginalTaxes + .3 * (salary - 75000);
			salary = salary - (salary - 75000);
			tier4 = true;
		}
		if (salary > 25000){
			marginalTaxes = marginalTaxes + .2 * (salary - 25000);
			salary = salary - (salary - 25000);
			tier3 = true;
		}
		if (salary > 10000){
			marginalTaxes = marginalTaxes + .1 * (salary - 10000);
			salary = salary - (salary - 10000);
			tier2 = true;
		}


		double dependentsTaxes = marginalTaxes - dependentsReturns;
		double finalTaxes;

		if (age >= 81){
			finalTaxes = 0;
		} else if (age >= 73){
			finalTaxes = .66 * dependentsTaxes;
		} else if (age >= 64){
			finalTaxes = .33 * dependentsTaxes;
		} else if (age >= 22){
			finalTaxes = dependentsTaxes;
		} else if (age >= 16){
			finalTaxes = .25 * dependentsTaxes;
		} else {
			finalTaxes = .5 * dependentsTaxes;
		}


		if (tier5){
			if (finalTaxes < 25000){
				finalTaxes = 25000;
			}
		} else if (tier4){
			if (finalTaxes < 10000){
				finalTaxes = 10000;
			}
		} else if (tier3){
			if (finalTaxes < 5000){
				finalTaxes = 5000;
			}
		} else if (tier2){
			if (finalTaxes < 500){
				finalTaxes = 500;
			}
		}

		System.out.println("Your final tax is: $" + finalTaxes);
	}
}