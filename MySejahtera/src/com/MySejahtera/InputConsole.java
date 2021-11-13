package com.MySejahtera;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputConsole {
    // abstraction using private
    private static Scanner scanner = new Scanner(System.in);

    // validate user input is not blank, convert it to upper case to avoid any case mismatch
    public static String userInput(String prompt) {
        String value;

        while (true) {
            System.out.print(prompt + "\n-> ");
            value = scanner.nextLine();
            if (!value.isBlank())
                break;
            System.out.println("Input cannot be empty.");
        }
        // convert user input to upper case to avoid case mismatch using toUpperCase method, and to make it uniform and consistent
        return value.toUpperCase();
    }

    public static LocalDate dateInput(String prompt) {
        LocalDate date;

        while (true) {
            try {
                // get date input from user
                date = LocalDate.parse(userInput(prompt));
            } catch (DateTimeParseException e) {
                // validate if date input is in the right format
                System.out.println("Invalid date format. Please enter again.");
                continue;
            }
            break;
        }
        return date;
    }
}