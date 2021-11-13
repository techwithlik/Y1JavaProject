package com.MySejahtera;
import java.time.LocalDate;

// Extends keyword is used to inherit a class
public class MovementAndRisk extends IncomingPassenger {
    public String destination, allowed;
    public int riskLevel;

    // initialize the places, featuring Abstraction using Private but modifiable by admin
    private static String[] hospitals = {"SUNGAI BULOH HOSPITAL", "KAJANG HOSPITAL", "PANTAI HOSPITAL"};
    private static String[] malls = {"PAVILION", "SUNWAY PYRAMID", "MID VALLEY"};
    private static String[] groceries = {"TESCO SEMENYIH", "JAYA GROCER PEARL", "AEON CHERAS"};

    public MovementAndRisk() {
        // display places in each category using For loop
        System.out.println("\nPlaces to Visit:");
        // length method used to get the length of the string
        for (int i=0; i<hospitals.length; i++){
            System.out.println(" -" + hospitals[i]);
        }
        for (int i=0; i<malls.length; i++){
            System.out.println(" -" + malls[i]);
        }
        for (int i=0; i<groceries.length; i++){
            System.out.println(" -" + groceries[i]);
        }

        // get user input on where user wants to visit
        destination = InputConsole.userInput("\nWhere do you plan on Visiting?");
        riskLevel = calculateRisk();
        allowed = checkAllowed();
    }

    // calculate total risk level of the user based on the zone of the country the user is from and the place visiting
    private int calculateRisk() {
        // calculate risk based on the zone of the country
        loop1:
        while (true) {
            // loop through the countries in the zone using For
            for (String zone : redZone) {
                // if a match was found, increase risk level by 5
                if (departureCountry.equals(zone)) {
                    riskLevel += 5;
                    break loop1;
                }
            }
            for (String zone : yellowZone) {
                if (departureCountry.equals(zone)) {
                    riskLevel += 3;
                    break loop1;
                }
            }
            // if no match was found, increase risk level by 1
            riskLevel += 1;
            break;
        }

        // calculate risk based on the place the user wishes to visit
        loop2:
        while (true) {
            // loop through the places stated using For
            for (String place : hospitals) {
                // .equalsIgnoreCase method used to compare the strings while ignoring any case differences
                if (destination.equalsIgnoreCase(place)) {
                    // if a match was found, increase risk level by 5
                    riskLevel += 5;
                    break loop2;
                }
            }
            for (String place : malls) {
                if (destination.equalsIgnoreCase(place)) {
                    riskLevel += 4;
                    break loop2;
                }
            }
            for (String place : groceries) {
                if (destination.equalsIgnoreCase(place)) {
                    riskLevel += 3;
                    break loop2;
                }
            }
            // if no match was found, increase risk level by 1
            riskLevel += 1;
            break;
        }

        return riskLevel;
    }

    // determine if user is allowed to travel
    private String checkAllowed() {
        // user is allowed to travel if their total risk level is below 7 AND that their quarantine is over
        return arrivalDate.plusDays(quarantineFor).compareTo(LocalDate.now()) < 0 && riskLevel < 7 ? "YES" : "NO";
    }
}