/* URL for github repository below:
https://github.com/GustavoBritoL/read-file-customers */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package careadfile;
/**
 *
 * @author gustavobrito22icloud.com
 */

// Class Customer created in order to create an object to each customer 
public class Customer {
    // Variables created to store data from the read file.
    private String firstName; // Variable created to store first name,
    private String secondName; // Variable created to store last name,
    private double purchaseAmount; // Variable created to store purchase amount,
    private int customerClass; // Variable created to store class of customer,
    private int lastPurchaseYear; // Variable created to store last purchse year.

    // Construtor 
    public Customer() {}

    // Getter and Setter for first name.
    public String getFirstName() { 
        return firstName;
    }

    public void setFirstName(String firstName) {
        // Statement to evaluate first name which must contain only letters.
        // "[a-zA-Z]+" will match any letter from a to z (lower case or uppercase).
        if (firstName.matches("[a-zA-Z]+")) {
            this.firstName = firstName; // "This" instance/value that will be stored in the variable secondName.
        } else {
            // Error message thorwn in case name is incorrect.  
            throw new IllegalArgumentException("First name must contain only letters.");
        }
    }

    // Getter and Setter for last name.
    public String getsecondName() {
        return secondName;
    }
    
    public void setsecondName(String secondName) {
        // Statement to evaluate last name which can be letters and/or numbers.
        // "[a-zA-Z0-9]+" will match any letter from a to z (lower case or uppercase)and any digit from 0 to 9.
        if (secondName.matches("[a-zA-Z0-9]+")) {
            this.secondName = secondName; //"This" instance/value will bee stored in the variable secondName.
        } else {
            // Error message thrown in case name is incorrect.
            throw new IllegalArgumentException("Last name must contain only letters and/or numbers.");
        }
    }

    // Getter and Setter for purchase amount.
    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        // Statement to evaluate to true if purchase amount is greater than 0.
        if (purchaseAmount > 0) {
            this.purchaseAmount = purchaseAmount;//"This" instance/value will be stored in variable purchaseAmount.
        } else {
            // Error message thrown in case the value is not positive and/or double.
            throw new IllegalArgumentException("Purchase amount must be a positive double.");
        }
    }

    // Getter and Setter for customer class.
    public int getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(int customerClass) {
        // Statement to evaluate to true if customer class is between 1 and 3.
        if (customerClass >= 1 && customerClass <= 3) {
            this.customerClass = customerClass; //"This" instance/value will be stored in variable customerClass.
        } else {
            // Error message thrown in case the value is not less than 1 or greater than 3 and display customer name.
            throw new IllegalArgumentException("Customer class must be between 1 and 3. Customer: " + firstName + " " + secondName +".");
        }
    }

    // Getter and Setter for last year purchase.
    public int getLastPurchaseYear() {
        return lastPurchaseYear;
    }

    public void setLastPurchaseYear(int lastPurchaseYear) {
        // Statement to evaluate to true if the last purchase year is a valid year.
        if (lastPurchaseYear >= 1900 && lastPurchaseYear <= 2024) {
            this.lastPurchaseYear = lastPurchaseYear; // "This" instance/value will be stored in variable lastPurchaseYear.
        } else {
            // Error message thrown in case year is not valid.
            throw new IllegalArgumentException("Last purchase year must be a valid year.");
        }
    }
    
     // Method to calculate discount.
    public double calculateDiscount() {
        // variable double to store discount calculated.
        double discount = 0.00;

        // if statement to check if custormer class is equal to 1. 
        if (customerClass == 1) {
            if (lastPurchaseYear == 2024) { // if statement to check last year of purchase is equal to 2024. 
                discount = purchaseAmount * 0.30; // Calculation for 30% of Discount.
              // else if statement to check if last year of purchase is less than 2024 and greater than or equal to 2019.
            } else if (lastPurchaseYear < 2024 && lastPurchaseYear >= 2019) { 
                discount = purchaseAmount * 0.20; // Calculation for 20% of Discount.
              // else if statement to check if last year of purchase is less than 2019.  
            } else if (lastPurchaseYear < 2019) {
                discount = purchaseAmount * 0.10; // Calculation for 10% of Discount.
            }
        } else if (customerClass == 2) { // else if statement to check if custormer class is equal to 2. 
            if (lastPurchaseYear == 2024) {
                discount = purchaseAmount * 0.15; // Calculation for 15% of Discount.
            } else if (lastPurchaseYear < 2024 && lastPurchaseYear >= 2019) {
                discount = purchaseAmount * 0.13; // Calculation for 13% of Discount.
            } else if (lastPurchaseYear <= 2019) {
                discount = purchaseAmount * 0.05; // Calculation for 5% of Discount.
            }
        } else if (customerClass == 3) { // else if statement to check if custormer class is equal to 3.
            if (lastPurchaseYear == 2024) {
                discount = purchaseAmount * 0.03; // Calculation for 3% of Discount.
            } // 0% of discount for purchases before 2024.
        }
        
        return discount;
    }


    // Method for displaying customer informations and a aplly discount for each one of them.
    public void displayCustomerInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Second Name: " + secondName);
        System.out.println("Purchase Amount: $" + purchaseAmount);
        System.out.println("Customer Class: " + customerClass);
        System.out.println("Last Purchase Year: " + lastPurchaseYear); 
        double discount = calculateDiscount(); // Calling calculationDiscount method and storing value in double discount variable.
        double finalAmount = purchaseAmount - discount; // Applying discount for each customer. 
        System.out.printf("Discount: $%.2f%n", discount); 
        System.out.printf("Final Amount after Discount: $%.2f%n", finalAmount);
        System.out.println("---------------------------");
    }
}

