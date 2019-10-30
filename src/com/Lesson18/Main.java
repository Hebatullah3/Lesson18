package com.Lesson18;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) throws CheckingPhoneNumber, InvalidStudentInfoException, CheckingGame {
        // write your code here
      /*  Scanner scan = new Scanner(System.in);


       // System.out.println("Please inter the phone number..the phone number should begin with '+' sign");

        //String output = scan.nextLine();
        //checkingNumber(output);

      //  System.out.println("Please inter your email");
        //String output2 = scan.nextLine();
        //CheckingEmail(output2); */

     /*   System.out.println("please enter your first name");
        String firstName = scan.nextLine();
        System.out.println("please enter your second name");
        String lastName= scan.nextLine();
        System.out.println("please enter your age");
        int age= Integer.parseInt(scan.nextLine());
        System.out.println("please enter your selected course");
        String course= scan.nextLine();

        //checkingNumber(output);
        validatingName(firstName);
        validatingName(lastName);
        validatingAge(age);
        validatingName(course);

        System.out.println( "your name is: " +firstName + "\n your lastName: " +lastName+ "\n your age is :"+ age+ "\nyou applied for: "+ course + " Course.");

*/


        Scanner scan = new Scanner(System.in);
        System.out.println("Please inter your play R for rock , P for paper and S for Scissor");
        String userInput = scan.nextLine();
        System.out.println("The result is :" + gamevalidating(userInput));


    }

    static String gettingComputerPlay() {
        ArrayList<String> computerPlay = new ArrayList<String>();
        computerPlay.add("S");
        computerPlay.add("R");
        computerPlay.add("P");
        Random r = new Random();
        int index = r.nextInt(3);
        return computerPlay.get(index);


    }

    public static boolean isValidUserInput(String test) {
        for (UserInput c : UserInput.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


    static String gamevalidating(String userValue) throws CheckingGame {
        String computerSelection = gettingComputerPlay();
        String result = "";


        if (!Main.isValidUserInput(userValue)) {
            throw new CheckingGame("the entered value: " + userValue + " is not valid !");
        } else {
            String userInput = String.valueOf(UserInput.valueOf(userValue.toUpperCase()));
            if (userInput.equalsIgnoreCase(computerSelection)) {
                result = "Draw! ";
            } else if (userInput.equals("P")) {
                if (computerSelection.equals("S")) {
                    result = "Computer wins";
                } else if (computerSelection.equals("R")) {
                    result = "You win";
                }

            } else if (userInput.equals("R")) {
                if (computerSelection.equals("S")) {
                    result = "You win";
                } else if (computerSelection.equals("P")) {
                    result = "computer wins";
                }
            } else if (userInput.equals("S")) {
                if (computerSelection.equals("R")) {
                    result = "computer wins ";

                } else if (computerSelection.equals("P")) {
                    result = "You win";
                }
            }
        }
        System.out.println("the computer Play is: " + computerSelection);


        return result;

    }


    static void validatingName(String value) throws InvalidStudentInfoException {

        if (value.length() < 3) {
            throw new InvalidStudentInfoException("the entered value: " + value + " length is too short");
        }

    }

    static void validatingAge(int age) throws InvalidStudentInfoException {
        if (age < 0 && age > 150) {
            throw new InvalidStudentInfoException("invalid Age " + age);
        }

    }


    static void checkingNumber(String phoneNumber) throws CheckingPhoneNumber {

        String regex = "(0/91)?[7-9][0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            System.out.println("Valid phone number format, your phone number is : " + phoneNumber);
        } else {
            throw new CheckingPhoneNumber("invalid  phone number");

        }
    }

    static void CheckingEmail(String email) throws CheckingPhoneNumber {
        {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                System.out.println("Valid email format, your email is : " + email);
            } else {
                throw new CheckingPhoneNumber("invalid  email format");

            }

        }


    }

}
