package lockedme.com;

import java.util.Scanner;
import models.Developer;
import service.FileOperationService;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		Developer developer = new Developer();
		developer.setFirstName("Euclidio");
		developer.setLastName("Venancio");
		developer.setGitProfile("www.github.com/eudagraca");
		developer.setCompanyName("Lockers.Pvt");
		ApplicationScreen app = new ApplicationScreen();
		app.displayWelcomeMessage(developer, "LockedMe");
		
		if (scanner.hasNextLine()) {
			app.appMenuOption();
			app.appMenuExecution();
		}
	}
}
