package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import lockedme.com.FileOperation;
import utils.Utils;

public class FileOperationService extends FileOperation {

	Path path;

	@Override
	public Boolean createFolderIfNotExists() {

		File file = new File(Utils.applicationName());
		/*
		 * Check if folder exists
		 */
		if (!file.exists()) {
			/*
			 * Create folder
			 */
			file.mkdir();
		}
		return file.exists();
	}

	@Override
	public String addFile(Scanner scanner, String fileName) {
		path = Paths.get(getPath() + fileName);
		try {
			Files.createDirectories(path.getParent());
			Files.createFile(path);
			System.out.println(fileName.concat(" created successfully"));

		} catch (IOException e) {
			System.out.println("Failed creating the file " + fileName);
			System.out.println(e.getMessage());
		}
		return fileName;
	}

	@Override
	public void deleteFile(String fileName) {
		File file = new File(getPath() + fileName);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println(fileName.concat(" deleted successfully"));
			} else {
				System.out.println("Error on deleting ".concat(fileName));
			}
		}else {
			System.out.println("File not Foud : ( ".concat(fileName).concat(" )"));

		}
	}

	@Override
	public void searchFile(String fileName) {

		ArrayList<String> allFiles = new ArrayList<String>();
		File directory = new File(Paths.get(getPath()).toString());
		if (createFolderIfNotExists()) {

			System.out.println("\n--------------------------------------------------------------");
			System.out.println(String.format("Displaying Files ( %s ) from the directory : %s", fileName, directory));
			System.out.println("--------------------------------------------------------------");

			if (directory.listFiles().length > 0) {
				for (File file : directory.listFiles()) {
					if (file.getName().toLowerCase().contains(fileName.toLowerCase())) {
						System.out.println(file.getName());
						allFiles.add(file.getName());
					}
				}
			} else {
				System.out.println("--------   File Not Found");
			}
			System.out.println("--------------------------------------------------------------");

		}
	}

	String getPath() {
		return "./" + Utils.applicationName() + "/";
	}

	@Override
	public void allFiles() {
		File directory = new File(Paths.get(getPath()).toString());
		Set<String> files = new TreeSet<String>();
		if (createFolderIfNotExists()) {

			System.out.println("\n--------------------------------------------------------------");
			System.out.println(String.format("Displaying all Files from the directory : %s", directory));
			System.out.println("--------------------------------------------------------------");

			if (directory.listFiles().length > 0) {

				for (File file : directory.listFiles()) {
					files.add(file.getName());
				}

				for (String file : files) {
					System.out.println(file);
				}

			} else {

				System.out.println("--------   File Not Found");

			}

		}
	}
}
