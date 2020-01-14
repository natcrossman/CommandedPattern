
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandPatternDriver {
	static final String TABS_Center = "\t\t\t";
	public static void main(String[] args) throws IOException {
		 run();
	}

	/**
	 * Launch the program
	 */
	public static void run() {
		CommandStore listOfCommandStore = CommandStore.getInstance();
		MyStringBuilder stringObj = new MyStringBuilder(); //My strength current instance
		
		while (true) {
			System.out.println("\nThe Current String: " + ((stringObj.isEmpty()) ? "Is Empty" : stringObj.toString()));
			switch (menu()) {
			case 1:
				listOfCommandStore.runCommand(new AppendCommand(stringObj, menuAppend()));
				break;
			case 2:
				if(!stringObj.isEmpty()) {
					System.out.println("Remove First Item");
					listOfCommandStore.runCommand(new DeleteFirstLetterCommand(stringObj));
				}else {
					System.out.println("Error The Current String Is Empty");
				}
				
				break;
			case 3:
				if(!stringObj.isEmpty()) {
					System.out.println("Remove Last Item");
					listOfCommandStore.runCommand(new DeleteLastLetterCommand(stringObj));
				}else {
					System.out.println("Error The Current String Is Empty");
				}

				break;
			case 4:
				if(!stringObj.isEmpty()) {
					String message = "Thanks For Choosing to Capitalize A Letter At Any Index";
					listOfCommandStore.runCommand(new CapitalizeCommand(stringObj, menuForIndex(message,stringObj.size()-1)));
					
				}else {
					System.out.println("Error The Current String Is Empty");
				}
									
				break;
			case 5:
				if(!stringObj.isEmpty()) {
					String message = "Thanks For Choosing to Lower Case A Letter At Any Index";
					listOfCommandStore.runCommand(new LowerCaseCommand(stringObj, menuForIndex(message,stringObj.size()-1)));
					
				}else {
					System.out.println("Error The Current String Is Empty");
				}
				break;
			case 6:
				if(!stringObj.isEmpty()) {
					System.out.println("Change to Tilte Case");
					listOfCommandStore.runCommand(new TitleCaseCommand(stringObj));
					
				}else {
					System.out.println("Error The Current String Is Empty");
				}
				break;
			case 7:
				System.out.println("UNDO");
				listOfCommandStore.undo();
				
				break;
			case 8:
				System.out.println("REDO");
				if (!listOfCommandStore.redo()) {
					System.out.println("Error: Nothing to redo!");
				}
				break;
			case 9:
				System.out.println(TABS_Center + "Good Bye");
				System.exit(0);
				break;
			case 10:
				cls();
				System.out.println(TABS_Center + "CLS");
				
				break;
			}

		}

	}
	
	/**
	 * First Menu
	 * @return int:choice
	 */
	public static int menu() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		int input = 0;
		do {
			System.out.println("************************************************************************************");
			System.out.println(TABS_Center +"Main Menu");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("1.  Append A Letter To A String");
			System.out.println("2.  Delete A Letter From The Start Of A String");
			System.out.println("3.  Delete A Letter From The End Of A String");
			System.out.println("4.  Capitalize A Letter At Any Index Within A String");
			System.out.println("5.  Set Any Letter To Lower Case At Any Index Within A String");
			System.out.println("6.  Set Whole String to Title Case");
			System.out.println("7.  Undo Last Command");
			System.out.println("8.  Redo Last Command");
			System.out.println("9.  Quit ");
			System.out.println("10. CLS ");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.print("Enter Choice:");
			try {
				choice = in.readLine();
				input = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				input = 0;
				choice = "";
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
				input = 0;
				choice = "";
			}
			if (input < 1 || input > 10) {
				for (int i = 0; i < 100; i++) {
					System.out.println("\n\n\n");
					if (i == 99)
						System.out.println(TABS_Center + "-- Error: Bad Entry.. --");
				}
			}

		} while (input < 1 || input > 10);

		return input;
	}

	
	/**
	 * This menu gets the Char 
	 * @return char :choice
	 */
	public static char menuAppend() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		do {
			System.out.println("\n\n------------------------------------------------------------------------------------");
			System.out.println("Thanks For Choosing to Append A Letter");
			System.out.println("At This Time, You Can Only Type One Letter");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.print("Enter Letter:");
			try {
				choice = in.readLine();
				
				if ((choice.toCharArray()).length == 1) {
					return choice.charAt(0);
				} else {
					for (int i = 0; i < 100; i++) {
						System.out.println("\n\n\n");
						if (i == 99) {
							System.out.println( TABS_Center +"-- Error: Bad Entry.. -- \n" + "\t\t\t-- You Entered: " + choice + " --");
							System.out.println(TABS_Center + "-- Retry.. --");
						}
							
						
					}
				}

			} catch (IOException e) {
				System.out.print("Error:");
				e.getStackTrace();
				
			}catch (NullPointerException e) {
				System.out.print("Error:");
				e.getStackTrace();
		
	}

		} while (true);
	}
	
	
	

	/**
	 * This menu gets the index 
	 * @return char :choice
	 */
	public static int menuForIndex(String message, int sizeOfObj) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		int input = -1;
		do {
			System.out.println("\n\n------------------------------------------------------------------------------------");
			System.out.println(message);
			System.out.println("Enter A Index from 0 to " + sizeOfObj);
			System.out.println("------------------------------------------------------------------------------------");
			System.out.print("Enter Number:");
			try {
				choice = in.readLine();
				input = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				input = -1;
				choice = "";
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
				input = -1;
				choice = "";
			}
			if (input < 0 || input > sizeOfObj) {
				for (int i = 0; i < 100; i++) {
					System.out.println("\n\n\n");
					if (i == 99)
						System.out.println(TABS_Center + "-- Error: Bad Entry.. --");
						System.out.println(TABS_Center + "-- Only Enter Numbers from 0 - " + sizeOfObj);
				}
			}

		} while (input < 0 || input > sizeOfObj);
		return input;
	}

	
	/**
	 * Clears the consul
	 * Used primarily for debugging
	 */
	public static void cls() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\n\n\n");
		}
	}
}
