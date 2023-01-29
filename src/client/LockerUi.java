package client;

import static service.LockerService.menu;

public class LockerUi {

    public static void main(String[] args) {
        getIntro();
        while (true){
            menu();
        }

    }

    private static void getIntro(){

        System.out.println("" +
                "\n" +
                "  _                _            _ __  __      \n" +
                " | |              | |          | |  \\/  |     \n" +
                " | |     ___   ___| | _____  __| | \\  / | ___ \n" +
                " | |    / _ \\ / __| |/ / _ \\/ _` | |\\/| |/ _ \\\n" +
                " | |___| (_) | (__|   <  __/ (_| | |  | |  __/\n" +
                " |______\\___/ \\___|_|\\_\\___|\\__,_|_|  |_|\\___|\n" +
                "                                              \n");
        System.out.println(
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@                  LockedMe.com                   @\n" +
                "@               @Author Mert Sever                @\n" +
                "@ All rights reserved by Company Lockers Pvt. Ltd @\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

    }
}
