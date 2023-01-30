package lockedme.com;

import java.util.Scanner;

public abstract class FileOperation {

	public abstract Boolean createFolderIfNotExists();
	public abstract String addFile(Scanner scanner, String fileName);
	public abstract void deleteFile(String fileName);
	public abstract void searchFile(String fileName);
	public abstract void allFiles();
}
