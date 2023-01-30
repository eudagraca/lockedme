package lockedme.com;

import java.util.Scanner;
import models.Developer;
import service.FileOperationService;

public class ApplicationScreen {
	FileOperationService service = new FileOperationService();
	Scanner scanner = new Scanner(System.in);

	void displayWelcomeMessage(Developer developer, String applicationName) {

		System.out.println("\n\t\tWelcome to ".concat(applicationName).concat("\n\t\t  ---------------- \n"));
		System.out.println("\tDesigned with passion by "
				.concat(developer.getFirstName().concat(" ").concat(developer.getLastName())));
		System.out.println("\tGit profile: ".concat(developer.getGitProfile()));
		System.out.println("\t\tCompany: ".concat(developer.getCompanyName()));
		System.out.println("\n\t\t Press Enter to continue");
	}

	void fileMenuExecution() {

		System.out.println("Please, select an option");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 0 -> {
			appMenuOption();
			appMenuExecution();
			break;

		}
		case 1 -> {

			service.createFolderIfNotExists();
			System.out.println("Enter a file name you want to add: ");
			String fileName = scanner.nextLine();

			if (!fileName.isEmpty()) {
				service.addFile(scanner, fileName);
				System.out.println("");
				appMenuOption();
				appMenuExecution();
			}

			break;
		}

		case 2 -> {
			System.out.println("Enter a name you want to delete: ");

			String name = scanner.nextLine();
			if (!name.isEmpty()) {
				service.deleteFile(name);
				System.out.println("");
				appMenuOption();
				appMenuExecution();
			}
		}
		case 3 -> {
			System.out.println("Enter a name you want to search: ");
			String name = scanner.nextLine();

			if (!name.isEmpty()) {
				service.searchFile(name);
				System.out.println("");
				appMenuOption();
				appMenuExecution();
			}
			break;
		}

		default -> {
			System.out.println("Unexpected value: " + option);
			fileMenuExecution();

		}

		}
	}

	void fileMenuOption() {
		System.out.println("1. Add new file");
		System.out.println("2. Delete file");
		System.out.println("3. Search file");
		System.out.println("0. Return to the menu");
	}

	void appMenuOption() {
		System.out.println("1. Retrieve all files");
		System.out.println("2. Operations on files");
		System.out.println("0. Close App");
	}

	void appMenuExecution() {
		System.out.println("Please, select an option");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 0 -> {
			System.out.println("Bye...");
			System.exit(option);

		}
		case 1 -> {
			service.allFiles();
			System.out.println("");
			appMenuOption();
			appMenuExecution();
			break;
		}
		case 2 -> {
			fileMenuOption();
			fileMenuExecution();
			break;
		}
		default -> {
			System.out.println("Unexpected value: " + option);
			appMenuExecution();
		}
		}
	}

}
