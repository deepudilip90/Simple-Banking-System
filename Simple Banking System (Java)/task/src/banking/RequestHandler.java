package banking;

import java.util.Scanner;

class RequestHandler {

    public RequestHandler(){
    }
    public static void showLandingPage(){
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit account");
    }
    public Integer getUserInput(){
        Scanner reader = new Scanner(System.in);
        try {
            return reader.nextInt();
        } finally {
            reader.close();
        }

    }
}
