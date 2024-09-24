import java.util.Scanner;
import java.util.ArrayList;
/**
 * Conversation with Chatbot
 * 
 * @author Bebe Cosgrove
 * @version September 2024
 */
public class Conversation {
  public static void main(String[] arguments) {
    Scanner rounds  = new Scanner(System.in);
    System.out.print("How many rounds? ");
  
    /** User inputs number for number of rounds */ 
    int numberofRounds = rounds.nextInt();
    rounds.nextLine();
    
    /** Makes an array list for the transcript */ 
    ArrayList <String> transcript = new ArrayList<String>();

    transcript.add("TRANSCRIPT:");
    String welcome_message = "Hi there!  What can I help you with?";
    System.out.println(welcome_message);
    transcript.add(welcome_message);

    /** Array of pre-made phrases to respond to non-mirrored responses */  
    String[] array = new String[]{"Interesting.", "Mhm.", "That's cool.", "Wow!"};


    /** Loops through number of times user inputed */ 
    for (int i = 0; i < numberofRounds; i++) {
      String response = rounds.nextLine();

      /** Adds response to transcript array */ 
      transcript.add(response);

      String[] wordsinResponse = response.split(" ");
      /** boolean to set whether or not response has mirrored word in it */
      boolean mirror = false; 

      /** For loop to see if each word in response has a mirrored word */ 
      for(int j = 0; j < wordsinResponse.length; j++){
        if (wordsinResponse[j].equals("I") || wordsinResponse[j].equals("i")){
          wordsinResponse[j] = "You";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("Am") || wordsinResponse[j].equals("am")){
            wordsinResponse[j] = "are";
            mirror = true;
        }
        else if (wordsinResponse[j].equals("Are") || wordsinResponse[j].equals("are")){
          wordsinResponse[j] = "am";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("You") || wordsinResponse[j].equals("you")){
          wordsinResponse[j] = "I";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("Me") || wordsinResponse[j].equals("me")){
          wordsinResponse[j] = "you";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("My") || wordsinResponse[j].equals("my")){
          wordsinResponse[j] = "your";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("Your") || wordsinResponse[j].equals("your")){
          wordsinResponse[j] = "my";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("I'm") || wordsinResponse[j].equals("i'm")){
          wordsinResponse[j] = "You're";
          mirror = true;
        }
        else if (wordsinResponse[j].equals("You're") || wordsinResponse[j].equals("you're")){
          wordsinResponse[j] = "I'm";
          mirror = true;
        }
        
    }

    /** if response contains mirrored word, print the mirrored response */ 
    if(mirror == true){
       for(int u = 0; u < wordsinResponse.length; u++){
        System.out.print(wordsinResponse[u] + " ");
      
      }
      /** Joins together words in mirrored response */
      String mirrored_response = String.join(" ", wordsinResponse);
      
      /** Adds mirrored response to transcript array */
      transcript.add(mirrored_response + "?");

      System.out.print("?");
      System.out.println();

    }
    /** if response doesn't contain mirrored word, print a randomly chosen response from array of set responses */ 
    else{
      /** Picks random element from array of responses, figured this out using something I referenced in reflection */
      int randomint = (int) Math.floor(Math.random()* array.length);
      String random_response = array[randomint];
      System.out.println(random_response);
      transcript.add(random_response);
    }

    }
    /** Prints out goodbye message */ 
    String goodbye_message = "Bye!";
    System.out.println(goodbye_message);
    System.out.println("");
    transcript.add(goodbye_message);

    /** Prints out every element in transcript on seperate line, also figured this out using a source which I referenced in reflection */
    transcript.forEach(System.out :: println);
    

    



     
    rounds.close();




  }
}


