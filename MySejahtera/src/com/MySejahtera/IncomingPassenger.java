package com.MySejahtera;
import java.time.LocalDate;
import java.util.Scanner;

public class IncomingPassenger {
    public String firstName, lastName, departureCountry;
    // Get current date as date of arrival
    public LocalDate departureDate, arrivalDate;
    public int quarantineFor;
    public String phoneNumber;

    // initialize countries and zones
    public String[] redZone = {"UNITED STATES", "INDIA", "BRAZIL"};
    public String[] yellowZone = {"RUSSIA", "UNITED KINGDOM", "FRANCE"};
    // quarantine period in days
    private int[] quarantinePeriod = {14, 12, 10};

    public IncomingPassenger () {
        // user input: name, country
        firstName = InputConsole.userInput("What is your First Name?");
        lastName = InputConsole.userInput("What is your Last Name/Family Name?");
        phoneNumber = InputConsole.userInput("What is your Phone Number?");
        departureCountry = InputConsole.userInput("From which Country did you Depart from?");
        departureDate = InputConsole.dateInput("What was your Date of Departure? (YYYY-MM-DD)");
        arrivalDate = InputConsole.dateInput("What was your Date of Arrival? (YYYY-MM-DD)");

        quarantineFor = quarantineCalculator();
    }

    // calculate the quarantine period based on what zone the country of the user was from
    private int quarantineCalculator(){
        // loop till the end of the list
        for (String zone : redZone) {
            // if a match was found, return the relevant quarantine period which is 14
            if (departureCountry.equalsIgnoreCase(zone))
                // match by index
                return quarantinePeriod[0];
        }
        for (String zone : yellowZone) {
            if (departureCountry.equalsIgnoreCase(zone))
                return quarantinePeriod[1];
        }
        // if their country is not part of the countries in the zones, the quarantine period will be 10 days
        return quarantinePeriod[2];
    }
}
