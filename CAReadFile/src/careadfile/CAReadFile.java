/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package careadfile;

// classes imported from java.io to read file and handle errors 
import java.io.BufferedReader; //Reads files, wraps FileReader
import java.io.FileReader; //Reads files
import java.io.IOException; //Handles exception and throw error message

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
        
          // Defining the file path as string to be read 
              String filePath = "/Users/gustavobrito22icloud.com/customers/customers.txt";
       
      /* Using try-catch to read the file with Buffered wraping FileReader and throw error in case of failure */   
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
          
          String line; // Variable created to store each line of the read file.
   
          /* "While loop" will read each line of the file if it is not equal to null,
           untill there is no line using readLine() */  
          while ((line = br.readLine()) != null){
              System.out.println(line);// Prints the line to the console.
          }
       // Catch will handle exceptions.
      } catch (IOException e) {
          // printStackTrace will print the IO exceptions if occur.
          e.printStackTrace();
      }
    }
    
}
