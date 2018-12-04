//Main Method of Final Project 
import java.util.Scanner; 
import java.io.IOException;
import java.io.File;
import java.util.Arrays; 
import java.io.*; 
import java.util.ArrayList; 

public class Final {
  public static void main (String [] args) 
         throws IOException { 
        
        /*String[] q1Choices = {"1.Saint Nick and Kris Kringle", "2.Santa Claus"}; 
        String[] q2Choices = {"1.Sandy", "2.Cupid"}; 
        Question q1 = new Question("What are two other names for Santa Claus?", 0, q1Choices); 
        Question q2 = new Question("One of Santa's reindeer shares a name with a famous symbol of Valentine's Day. Which Reindeer is that?", 1, q2Choices); 
        Question[] questions = new Question[]{q1, q2}; */
        
        Scanner in = new Scanner(System.in); 
 
        ArrayList<Question> read = readQuestions("questionAnswer.txt"); //readQuestions from text file 
        System.out.println("\t\t\t\t---Welcome to 12 Questions of Christmas!---"); //directions 
        System.out.println("\t\tDirections: When the question appears on the screen, \n\ttype the right number the corresponds to the right answer."); 
        System.out.print("\nPlease Enter your Player Name: "); //enters player name 
        String name = in.nextLine(); 
        int score = 0; 
                
        for (Question q : read) {
            System.out.println(q.getQuestion() + "\n" + Arrays.toString(q.getChoices()));
            int userInput = in.nextInt(); 
   
            if (isCorrectAnswer(q, userInput)) { //if the user chooses the correct answer 
               System.out.println("Hooray! You have entered the correct answer"); 
               score++; //score increments 
            } else {
               System.out.println("You have entered the wrong answer"); 
               score--; //score decrements
               if(score < 0) { //so score does not go negative 
                  score = 0;
               }
                
            } 
            System.out.println(name + ", your Score is: " + score); //prints out score
         } 
         System.out.println("\n\n" + name + ", your Total Score is: " + score); //prints out score 
         System.out.println("\nThank you " + name + " for playing 12 Questions of Christmas!");  
               
  } //end of main method
  
  
  public static ArrayList<Question> readQuestions (String fileName) throws IOException {
    ArrayList<Question> q = new ArrayList<Question>(); 
    
    File file = new File(fileName); //Stores File    
    Scanner inputFile = new Scanner(file); //open files

    while(inputFile.hasNext()) {
      //prints question from file 
      String line = inputFile.nextLine(); //reads question 
      int correctIndex = inputFile.nextInt(); 
      int numOptions = inputFile.nextInt(); 
      inputFile.nextLine(); // clears buffer
      String[] options = new String[numOptions]; 
      for (int i = 0; i < options.length; i++) {
         String reader = inputFile.nextLine(); 
         options[i] = reader; 
      }
      Question question = new Question(line, correctIndex,options); 
      q.add(question); //appends questions to arraylist    
     }
     inputFile.close(); //close file
     return q; 
  } //end of readQuestion method 
     
  public static boolean isCorrectAnswer (Question q, int userInput) { //determines if answer is correct or not 
     if (userInput == (q.getAnswer() + 1)) {
         return true; 
      } else {
         return false; 
      }
         
  } //end of correct method 
  
} //end of class


  
