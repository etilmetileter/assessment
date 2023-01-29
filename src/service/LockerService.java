package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LockerService {

    public static void menu() {
        printMainMenu();
        Scanner x = new Scanner(System.in);
        try {
            switch (x.nextInt()) {
                case 1:
                    listing();
                    break;
                case 2:
                    businessMenu();
                    break;
                case 3:
                    System.exit(66);
                    break;
                default:
                    System.out.println("[!]   Please enter a valid number!\n");
                    break;
            }
        } catch (Exception e) {
            System.out.println("[!]   Please type number!\n");
            menu();
        }
    }

    private static void businessMenu() {
        printMenu();
        Scanner x = new Scanner(System.in);
        try {
            switch (x.nextInt()) {
                case 1:
                    addFile();
                    break;
                case 2:
                    deleteFile();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("[!]   Please enter a valid number!\n");
                    break;
            }
        } catch (Exception e) {
            System.out.println("[!]    Please type number!\n");
            menu();
        }
    }

    private static void listing() {
        for (File listOfFile : list()) {
            if (listOfFile.isFile()) {
                System.out.println("File : " + listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                System.out.println("Dir  : " + listOfFile.getName());
            }
        }
        System.out.println(" ");
    }

    private static File[] list() {
        File folder = new File(getWorkingDir());
        return folder.listFiles();
    }

    private static void addFile() {
        System.out.print("[>]   Please enter a name for file : ");
        Scanner name = new Scanner(System.in);
        String fileNameForConsole = name.nextLine();
        String fileNameForSystem = pathFinder(fileNameForConsole);
        File file = new File(fileNameForSystem);
        if (file.exists()) {
            System.out.println("[!]   There is a existing file already !\n");
        } else {
            try {
                new FileWriter(fileNameForSystem).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[!]   File created with following name : " + fileNameForConsole + "\n");
        }
    }

    private static void deleteFile() {
        System.out.print("[>]   Pls enter a file name to delete : ");
        Scanner name = new Scanner(System.in);
        String fileNameForConsole = name.nextLine();
        String fileNameForSystem = pathFinder(fileNameForConsole);
        File file = new File(fileNameForSystem);

        if (file.exists()) {
            String asis = null;
            for (File listOfFile : list()) {
                if (file.getName().equalsIgnoreCase(listOfFile.getName())) {
                    file.delete();
                    System.out.println("[!]   File is deleted : " + listOfFile.getName() + "\n");
                }
            }
        } else {
            System.out.println("[!]   File not found!\n");
        }
    }

    private static void search() {
        System.out.print("[>]   Please enter the file name that you looking for : ");
        Scanner name = new Scanner(System.in);
        String fileNameForConsole = name.nextLine();
        String fileNameForSystem = pathFinder(fileNameForConsole);
        File file = new File(fileNameForSystem);

        String asis = null;
        for (File listOfFile : list()) {
            if (file.getName().equalsIgnoreCase(listOfFile.getName())) {
                asis = listOfFile.getName();
                System.out.println("[!]   File is found : " + asis + "\n");
            }
        }
        if (!file.exists()) {
            System.out.println("[!]   File not found \n");
        }
    }

    private static void printMainMenu() {
        System.out.println("[>]   Select an operation in menu down below \n");
        System.out.println("[1] - List Current File Names From Root Directory");
        System.out.println("[2] - Go To Detailed Business User Interface");
        System.out.println("[3] - Close The Locker");
    }

    private static void printMenu() {
        System.out.println("[>]   Select an operation in menu down below \n");
        System.out.println("[1] - Add File To Root Directory");
        System.out.println("[2] - Delete File From Root Directory");
        System.out.println("[3] - Search File On Root Directory");
        System.out.println("[4] - Return To Main Menu");
    }

    private static String pathFinder(String fileName) {
        return getWorkingDir().concat("\\" + fileName);
    }

    private static String getWorkingDir() {
        return System.getProperty("user.dir").concat("\\rootDirectory");
    }
}


