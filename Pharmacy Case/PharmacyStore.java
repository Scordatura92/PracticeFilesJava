import java.util.Scanner;

public class PharmacyStore {
Scanner scan = new Scanner(System.in);

	public PharmacyStore() {
		// Latihan Quiz UAP Pharmacy Store
		//materi UTS definisi, psuedocode, flowchart, tipe data
		int menu = 0; //0 buat antisipasi error
		String type;
		String name;
		int doses = 0;
		String address;
		int price = 0;
		int prodCost = 0;
		int payment = 0;
		int change = 0;
		
		do {
			System.out.println("Pharmacy Store");
			System.out.println("==============");
			System.out.println("1. Insert New Medicine");
			System.out.println("2. Exit Program");
			System.out.print("Choose[1-2]: ");
			
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				menu = -1;
			} scan.nextLine();
			
			switch (menu) {
			case 1:
				do {
					System.out.print("Input Medicine Type [Liquid|Capsules|Inhaler]: ");
					type = scan.nextLine();
				} while (!type.equals("Liquid") && !type.equals("Capsules") && !type.equals("Inhaler"));
				
				do {
					System.out.print("Input Medicine Name [2 words|More than 5 characters]: ");
					name = scan.nextLine();
				} while (!name.contains(" ") || name.length() <5 || name.startsWith(" ") || name.endsWith(" "));
				
				do {
					System.out.print("Input Consumption Doses per 24 hrs[1-5]: ");
					try { //use try catch in int so that the thing loops and doesnt error when some dumb mf types letters
						doses = scan.nextInt();
					} catch (Exception e) {
						doses = -1;
					} scan.nextLine();
				} while (doses < 1 || doses >5);
				
				do {
					System.out.print("Input pharmacy pickup address[End with 'Street'[Alphanumeric]: ");
					address = scan.nextLine();
				} while (!address.endsWith(" Street"));
				
				if (type.equals("Liquid")) {
					price = 10;
				} else if (type.equals("Capsules")) {
					price = 20;
				} else if (type.equals("Inhaler")) {
					price = 30;
				}
				
				prodCost = price + (doses*2000);
				
				System.out.println("");
				System.out.println("Medicine Detail");
				System.out.println("=======================");
				System.out.println("Medicine Type: " +type);
				System.out.println("Medicine Name: " +name);
				System.out.println("Medicine Dose per Day: " +doses);
				System.out.println("Medicine Pharmacy Pickup Address: " +address);
				System.out.println("=======================");
				System.out.println("Production Cost: Rp." +prodCost);
				
				do {
					System.out.println("Input Payment: ");
					try {
						payment = scan.nextInt();
					} catch (Exception e) {
						payment = -1;
					} scan.nextLine();
				} while (payment < prodCost);
				
				change = payment - prodCost;
				
				System.out.println("Change: Rp." +change);
				System.out.println();
				break;
			}
		} while (menu!=2);
		System.exit(0);
	}

	public static void main(String[] args) {
		new PharmacyStore();

	}

}
