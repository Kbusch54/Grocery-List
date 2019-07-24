package co.gc;

import java.util.ArrayList;

//@author Kevin Busch

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryList {

	public static void main(String[] args) {
//display items and prices
		Scanner scan = new Scanner(System.in);
		ArrayList<String> itemsOrdered = new ArrayList<String>();
		ArrayList<Double> itemPrice = new ArrayList<Double>();
		System.out.println("Welcome to Guenther's Market!");
		Map<String, Double> items = new HashMap<>();
		items.put("apple", 0.99);
		items.put("banana", 0.76);
		items.put("carrots", 1.23);
		items.put("milk", 2.19);
		items.put("yogurt", 0.64);
		items.put("ketchup", 2.19);
		items.put("bread", 3.50);
		items.put("tomato", 1.83);
		items.put("lettuce", 4.67);
		System.out.println("Item\t\t\t\tPrice");
		System.out.println("=====================================");
		String choice;
		boolean valid = false;
		boolean valid2 = false;
		while (!valid2) {
			while (!valid) {
				System.out.println(displayMenu(items));
//get user input/choice

				System.out.println("What item would you like to record");
				choice = scan.nextLine();
				if (items.containsKey(choice)) {

					itemsOrdered.add(choice);
					itemPrice.add(items.get(choice));
					System.out.println("Adding " + choice + " at $" + items.get(choice));

//add to cart/order

					valid = true;
				} else {
					System.out.println("Sorry that item is unavailble");
					valid = false;
				}
			}
//prompt user to continue/ add more items 
			System.out.println(displayMenu(items));
			boolean valid3;
			System.out.println("Would you like anything else? (Yes/No");
			do {
				String choice2 = scan.nextLine();
				if (choice2.equalsIgnoreCase("no")) {
					valid3 = true;
					valid2 = true;
				} else if (choice2.equalsIgnoreCase("yes")) {
					valid3 = true;
					valid = false;

				} else {
					System.out.println("Please type in yes or no");
					valid3 = false;
				}
			} while (!valid3);
//display items and prices
		}
//end loop here?
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got");
//get user selection
		System.out.printf("\n" + itemsOrdered + "\t\t\t\t $" + itemPrice + "\n");
//display cart

//display avg
		System.out.println("Average price for items ordered was: $" + avgPrice(itemPrice));
		System.out.println();

		scan.close();
	}

	public static Double avgPrice(ArrayList<Double> itemPrice) {
		double sum = 0.0;
		double avg = 0.0;
		for (double i = 0.0; i < itemPrice.size(); i++) {
			sum += itemPrice.get((int) i);
			avg = (sum) / itemPrice.size();

		}
		return avg;
	}

	public static String displayMenu(Map<String, Double> items) {
		StringBuilder result = new StringBuilder();
		for (String key : items.keySet()) {
			result.append(key + "\t\t\t\t$" + items.get(key) + "\n");
		}
		return result.toString();
	}

}
