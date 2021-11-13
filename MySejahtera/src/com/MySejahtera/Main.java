/*
Name: Tan Lik Wei
Student ID: 20208762
OWA Email: hfylt4
 */

package com.MySejahtera;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Covid-19 Social Bubble!");
        System.out.println("Please enter your information accordingly.\n------------------------------------------");

        // user input
        var passenger1 = new MovementAndRisk();

        System.out.println("\n------------Details------------");
        System.out.println("Name: " + passenger1.firstName + " " + passenger1.lastName);
        System.out.println("Phone Number: " + passenger1.phoneNumber);
        System.out.println("Country Departed from: " + passenger1.departureCountry);
        System.out.println("Quarantine Period: " + passenger1.quarantineFor);
        System.out.println("Date of Departure: " + passenger1.departureDate);
        System.out.println("Date of Arrival: " + passenger1.arrivalDate);
        System.out.println("End of Quarantine: " + passenger1.arrivalDate.plusDays(passenger1.quarantineFor));
        System.out.println("Place to Visit: " + passenger1.destination);
        System.out.println("Total Risk Level from 1-10: " + passenger1.riskLevel);
        System.out.println("Permission to Travel: " + passenger1.allowed);

        // send alert message to user
        JFrame frame = new JFrame("Covid-19 Social Bubble");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,250);
        if (passenger1.allowed.equals("NO")) {
            JButton button = new JButton("Your Risk Level is " + passenger1.riskLevel + "/10 .\n" + " You are NOT allowed to travel.");
            frame.getContentPane().add(button);
            // adds button to content pane of frame
            frame.setVisible(true);
        }
    }
}
