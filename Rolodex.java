import java.io.*;
import java.util.Scanner;

import javax.security.auth.callback.ChoiceCallback;

public class Rolodex {
	public static void main(String args[]) {
		/**
		 * reading in the .txt file Had to use split function given in the notes
		 * 
		 * @param fileName this is the txt file
		 * @return array returns txt file 2d array
		 */
		File input = new File("contacts.txt");
		String file = "";
		LinkedList contacts = new LinkedList();
		try {

			Scanner contacts1 = new Scanner(new File("contacts.txt"));

			do {

				file = contacts1.nextLine();

				String[] token = file.split(",");

				contacts.add( new Contact(token[0], token[1], token[2], token[3], token[4], token[5]));

				

			} while (contacts1.hasNextLine());
			
		} catch (FileNotFoundException fnf) {
			System.out.println("That file was not found.");
		}
		int userInput = 0;
		int subInput = 0;

		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Search");
		System.out.println("4. Update");
		System.out.println("5. Print ");
		System.out.println("6. Quit ");
		System.out.println("Please enter between 1-6");
		userInput = CheckInput.getIntRange(1, 6);
		while (userInput != 6) {
			if (userInput == 1) {

				System.out.println("You selected add");
				System.out.print("First Name: ");
				String firstName = CheckInput.getString();
				System.out.print("Last Name: ");
				String lastName = CheckInput.getString();
				System.out.print("Phone Number: ");
				String phoneNumber = CheckInput.getString();
				System.out.print("Adress: ");
				String adress = CheckInput.getString();
				System.out.println("City: ");
				String city = CheckInput.getString();
				System.out.print("Zip Code: ");
				String zipCode = CheckInput.getString();
				System.out.println("Adding....");
				contacts.add(new Contact(firstName, lastName, phoneNumber, adress, city, zipCode));
				System.out.println("added to the end");
				System.out.println("");
				System.out.println("Enter 1 - 6 again");
				userInput = CheckInput.getIntRange(0, 6);
			} else if (userInput == 2) {
				System.out.println("You selected remove");
				System.out.println("a. Remove by first and last name");
				System.out.println("b.Remove by Index");
				System.out.println("Enter an a or a b: ");
				subInput = CheckInput.getSub();
				if (subInput == 1) {
					System.out.println("You selected to remove by first and last name.");
					System.out.print("First Name:");
					String firstName1 = CheckInput.getString();
					System.out.print("Last Name: ");
					String lastName1 = CheckInput.getString();
					System.out.println("Removing .... ");
					contacts.remove(firstName1, lastName1);
					System.out.print("Removed");
					System.out.println("");
					System.out.println("Enter 1 - 6 again");
					userInput = CheckInput.getIntRange(0, 6);

				} else if (subInput == 2) {
					System.out.println("You selected to remove by Index");
					System.out.print("Index:");
					int Index = CheckInput.getIntRange(1, contacts.size());
					int Index1 = Index - 1;

					System.out.println("Removing .... ");
					contacts.remove(Index1);
					System.out.print("Removed");
					System.out.println("");
					System.out.println("Enter 1 - 6 again");
					userInput = CheckInput.getIntRange(0, 6);
				}
			} else if (userInput == 3) {
				System.out.println("You selected to search. ");
				System.out.println("a. Search by Full name ");
				System.out.println("b. Search by last name ");
				System.out.println("c. Search by zip code ");
				System.out.println("Enter an a , b, or a c: ");
				int subInput1 = CheckInput.getSub2();
				if (subInput1 == 1) {
					System.out.println("You selected to search by full Name: ");
					System.out.print("First name: ");
					String firstName3 = CheckInput.getString();
					System.out.print("Last name: ");
					String lastName3 = CheckInput.getString();
					int full = contacts.search(firstName3, lastName3);
					System.out.println("Searching ....");
					if (full==-1) {
						System.out.println("Contact doesnt exist ");
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(0, 6);
					} else {
						for (int i = 0; i < contacts.size(); i++) {
							System.out.print(contacts.get(i).toString());
						}
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(0, 6);
					}
				 
				} else if (subInput1 == 2) {
					System.out.println("You selected to search by last name: ");
					System.out.print("Last name: ");
					String lastName3 = CheckInput.getString();
					LinkedList last = contacts.search(lastName3);
					System.out.println("Searching ....");
					if (last.isEmpty()) {
						System.out.println("Contact doesnt exist ");
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(1, 6);
					} else {
						for (int i = 0; i < last.size(); i++) {
							System.out.print(last.get(i).toString());
						}
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(0, 6);

					}
				} else if (subInput1 == 3) {
					System.out.println("You selected to search by Zip Code. ");
					System.out.print("Zip Code : ");
					int zipCode3 = CheckInput.getInt();
					LinkedList zip = contacts.search(zipCode3);
					System.out.println("Searching ....");
					if (zip.isEmpty()) {
						System.out.println("Contact doesnt exist ");
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(1, 6);
					} else {
						for (int i = 0; i < zip.size(); i++) {
							System.out.print(zip.get(i).toString());
						}
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(0, 6);
					}
					}

				} else if (userInput == 4) {
					System.out.println("You selected to Udpate. ");
					System.out.print("First name: ");
					String firstName4 = CheckInput.getString();
					System.out.print("Last Name: ");
					String lastName4 = CheckInput.getString();
					int full1 = contacts.search(firstName4, lastName4);
					if (full1>=0) {
						System.out.println("Contact doesnt exist ");
						System.out.println("");
						System.out.println("Enter 1 - 6 again");
						userInput = CheckInput.getIntRange(1, 6);

					} else {
						
						System.out.println("Update what?");
						System.out.println("1. First Name?");
						System.out.println("2. Last Name?");
						System.out.println("3. Phone number ");
						System.out.println("4. Address?");
						System.out.println("5. City? ");
						System.out.println("6. Zip Code? ");
						System.out.println("Please enter between 1-6");
						int subInput3 = CheckInput.getIntRange(1, 6);
						if (subInput3==1) {
							System.out.print("Change first Name: ");
							String firstName5 = CheckInput.getString();
							contacts.get(full1+1).setfirstName(firstName5);
							System.out.println("First name updated" );
							System.out.println("");
							System.out.println("Enter 1 - 6 again");
							userInput = CheckInput.getIntRange(1, 6);
						}else if(subInput3==2){
							System.out.print("Change the last Name: ");
							String lastName5= CheckInput.getString();
							contacts.get(full1).setlastName(lastName5);
						}else if(subInput3==3) {
							System.out.print("Change the Phone number: ");
							String phoneNumber5= CheckInput.getString();
							contacts.get(full1).setphoneNumber(phoneNumber5);
						}else if(subInput3==4) {
							System.out.print("Change the address: ");
							String address5= CheckInput.getString();
							contacts.get(full1).setaddress(address5);
						}else if(subInput3==5) {
							System.out.print("Change the city: ");
							String city5 = CheckInput.getString();
							contacts.get(full1).setcity(city5);
						}else if (subInput3==6) {
							System.out.print("Change the zip Code: ");
							String zipCode5 = CheckInput.getString();
							contacts.get(full1).setzipCode(zipCode5);
						}
						
					}
				} else if (userInput == 5) {
					System.out.println("Here is the contacts");
					for ( int i = 0; i < contacts.size ( ); i++ ) { 
						if ( i < 9 ) { 
							System.out.println ( " " + ( i + 1 ) + ". " + contacts.get ( i ).toString ( ) );
							
						} else {
							System.out.println ( ( i + 1 ) + ". " + contacts.get ( i ).toString ( ) );
						}
					}
					System.out.println ( " " );
					System.out.println("Please enter between 1-6");
					userInput = CheckInput.getIntRange(1, 6); 
				}
		}System.out.println("You quit ");
		try {
            PrintWriter writer = new PrintWriter ( "contacts.txt" );
            for ( int row = 0; row < contacts.size ( ); row++ ) {
            	String line = contacts.get ( row ).getfirstName ( ) + "," + contacts.get ( row ).getlastName ( ) + "," + contacts.get ( row ).getphoneNumber ( ) 
            			+ "," + contacts.get ( row ).getaddress ( ) + "," + contacts.get ( row ).getcity ( ) + "," + contacts.get ( row ).getzipCode ( );
                writer.println ( line );
            }
            writer.close();
        } catch ( FileNotFoundException fnf ) {
            System.out.println("File was not found.");
        }
	}
		
	}


		/*
		 * /** reading in the .txt file Had to use split function given in the notes
		 * 
		 * @param fileName this is the txt file
		 * 
		 * @return array returns txt file 2d array
		 * 
		 * File input = new File("contacts.txt"); String file = ""; LinkedList contacts
		 * = new LinkedList(); try {
		 * 
		 * Scanner contacts1 = new Scanner(input);
		 * 
		 * do {
		 * 
		 * file = contacts1.nextLine();
		 * 
		 * String[] token = file.split(",");
		 * 
		 * Contact m = new Contact(token[0], token[1], token[2], token[3], token[4],
		 * token[5]);
		 * 
		 * contacts.add(m);
		 * 
		 * } while (contacts1.hasNext()); contacts1.close(); } catch
		 * (FileNotFoundException fnf) { System.out.println("That file was not found.");
		 * }
		 */

	


