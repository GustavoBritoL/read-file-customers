/* URL for github repository below:
https://github.com/GustavoBritoL/read-file-customers */ 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package careadfile;

// classes imported from java.io to read file and handle errors. 
import java.io.BufferedReader; // Reads files, wraps FileReader,
import java.io.FileReader; // Reads files,
import java.io.IOException; // Handles exception and throw error message,
import java.util.ArrayList;// Class ArrayList to store objetcs for each customer,
import java.util.List; // Interface List.

/**
 *
 * @author gustavobrito22icloud.com
 */
public class CAReadFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // TODO code application logic here
        
      // Array List to store Customer objects
      List<Customer> customers = new ArrayList<>();
        
      // Defining the file path as string to be read 
      String filePath = "/Users/gustavobrito22icloud.com/customers/customers.txt";
       
      // Using try-catch to read the file with Buffered wraping FileReader and throw error in case of failure. 
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
          
          String line; // Variable created to store each line of the read file.
   
          //"While loop" will read each line of the file using readLine() until there is no more line.
          while ((line = br.readLine()) != null){
                // Block code to read and store data into variables creating a new costumer object.
                try {
                    // Splitting the full name into first and second name. 
                    String[] fullName = line.split(" ");
                    if (fullName.length != 2) {
                        throw new IllegalArgumentException("Invalid name format.");
                    }

                    String firstName = fullName[0]; // Stores first name in index 0 of String[] fullname.
                    String secondName = fullName[1]; // Stores second name in index 1 of String[] fullname.

                    // Reads and validates the purchase amount (must be double).
                    line = br.readLine();
                    // Method parseDouble to convert/store in variable double purchaseAmount.
                    double purchaseAmount = Double.parseDouble(line); 
                   

                    // Reads and stores customer class.
                    line = br.readLine();
                    // Method parseInt to convert/store in variable int customerClass.
                    int customerClass = Integer.parseInt(line); 
                  

                    // Reads and stores the year of the last purchase.
                    line = br.readLine();
                    int lastPurchaseYear = Integer.parseInt(line);

                    // Cria o objeto Customer e define os atributos usando setters

                    Customer customer = new Customer();
                    customer.setFirstName(firstName);
                    customer.setsecondName(secondName);
                    customer.setPurchaseAmount(purchaseAmount);
                    customer.setCustomerClass(customerClass);
                    customer.setLastPurchaseYear(lastPurchaseYear);

                    // Adiciona o cliente à lista
                    customers.add(customer);
                   

                } catch (Exception e) {
                    System.out.println("Error reading customer data: " + e.getMessage());
                }
           
          }
       // Catch will handle exceptions.
      } catch (IOException e) {
          // printStackTrace will print the IO exceptions if occur.
          e.printStackTrace();
      }
      
        // For Loop to display information for all valid customers.
        for (Customer customer : customers) {
            customer.displayCustomerInfo();
        }
    }
    
}
