package Lockmefiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lockme {
	
	static final String errorMessage = " If Some error occured please contact admin: admin@LockedMe.Com";
	static final String projectFilesPath = "D:/";


	public static void displayMenu() {
		System.out.println("\t=================================");
		System.out.println("\tWelcome to Locked-Me");
		System.out.println("\t=================================");
		System.out.println("\tDeveloped by:- Mohammed Adil Siddique");
		System.out.println("\t1. Display all Files, Folders.");
		System.out.println("\t2. To add a new file.");
		System.out.println("\t3. To Delete a file.");
		System.out.println("\t4. To Search a file.");
		System.out.println("\t5. To Exit from Application.");
		System.out.println("\t=================================");
	}

	public static boolean fileNamevalidation(String ch) {
		
		boolean t = true;
		String pat = "^[a-zA-Z](?:[a-zA-Z0-9 ._-]*[a-zA-Z0-9])?\\.[a-zA-Z0-9_-]+$";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(ch);
		if (m.matches() == true) {
			t = false;
		} else {
			System.out.println(" please enter proper file name eg abc.txt");
			t = true;
		}
		return t;
	}

	
public static void getAllFiles() {
	try {
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length == 0) {
			System.out.println("No Files exist");
		} else {

			Arrays.sort(listOfFiles, Collections.reverseOrder());
			for (var l : listOfFiles) {
				System.out.println(l.getName());
			}
		}
	} catch (Exception Ex) {
		System.out.println(errorMessage);
	}

}

public static void createFiles() throws IOException {
	try {

		Scanner obj = new Scanner(System.in);
		String fileName;

System.out.println("Enter the filename: ");
		fileName = obj.nextLine();
		String newpath = (projectFilesPath + "\\" + fileName);
		boolean b = fileNamevalidation(fileName);
		while (b) {
			b = false;
			createFiles();
		}
		File F1 = new File(newpath);

		if (F1.exists()) {
			System.out.println(" The given filename name already present, give new file name.");
			createFiles();
		} else {
			F1.createNewFile();
			System.out.println("File " + fileName + " created Sucessfully.");
			WriteToFiles(newpath);
		}
	

	} catch (Exception ex) {
		System.out.println("Some error has occcured");
	}
}


private static void WriteToFiles(String newpath) {

	
}
public static void deleteAllFiles() {
	Scanner obj = new Scanner(System.in);
	try {
		String fileName;
		System.out.println("Enter the file name to be deleted");
		fileName = obj.nextLine();
		File file = new File(projectFilesPath + "\\" + fileName);

		if ((file.exists() == true) && (fileName != "null")) {
			file.delete();
			System.out.println("File " + fileName + " deleted SuccessFully : ");
		} else {
			System.out.println("File do not exists or you are entering space");
		}
	} catch (Exception ex) {
		System.out.println(errorMessage);
	} finally {
		
	}
}

public static void searchFiles() {
	Scanner obj = new Scanner(System.in);
	try {
		String fileName;

		System.out.println("Enter the file name to be Searched");
		fileName = obj.nextLine();
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		LinkedList<String> filenames = new LinkedList<String>();
		for (var l : listOfFiles)
			filenames.add(l.getName());
		if (filenames.contains(fileName))
			System.out.println("File " + fileName + "is available at " + folder.getAbsolutePath());
		else
			System.out.println("File " + fileName + "is not available");
	} catch (Exception ex) {
		System.out.println(errorMessage);
	} finally {
		// obj.close();
	}
}

public static boolean numbervalidation(String ch) {

	boolean t = true;
	String pat = "[1-5]";
	Pattern p = Pattern.compile(pat);
	Matcher m = p.matcher(ch);
	if (m.matches() == true) {
		t = false;
	} else {
		System.out.println("You are not entering number bewteen 1 to 5");
		t = true;
	}

	return t;
}
public static void loopme() {
	displayMenu();
	boolean flag = true;
	String ch = null;
	do {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your number Choice :- ");
		ch = obj.next();
		flag = numbervalidation(ch);
	} while (flag == true);
	int cha = Integer.parseInt(ch);
	switch (cha) {
	case 1:
		getAllFiles();
		System.out.println("****************************************");
		loopme();
		break;
	case 2:
		try {
			createFiles();
		} catch (IOException e) {
			System.out.println(errorMessage);
			e.printStackTrace();
		}
		System.out.println("****************************************");
		loopme();
		break;
	case 3:
		deleteAllFiles();
		System.out.println("****************************************");
		loopme();
		break;
	case 4:
		searchFiles();
		System.out.println("****************************************");
		loopme();
		break;
	case 5:
		System.out.println("Thanks for selecting Lockme application");
		System.out.println("****************************************");
		System.exit(0);
	}
}
public static void main(String[] args) {

	try {
		loopme();
	} catch (Exception e) {
		System.out.println(errorMessage);
	}
}
}
