import java.util.Scanner;

public class Alarm 
{

	public static void main(String[] args) 
	{
	   // Do not edit the main program
	  Scanner keyboard = new Scanner(System.in);
      int day = keyboard.nextInt();
      boolean snooze = keyboard.nextBoolean();
      
      System.out.print (alarm(day, snooze));
	}
	public static String alarm(int day, boolean snooze) 
	{
      if (day >= 1 && day <= 5) {
    	  if (snooze == true) {
    		  return "8:05"; 
    	  }
    	  else {  
    		  return "8:00";
    	  }
      }
      else if (day == 0 || day == 6) {
    	  if (snooze == true) {
    		  return "10:45";
    	  }
    	  else {
    		  return "10:30";
    	  }
      }
      else {
    	  return "invalid day"; 
      }
	}
}
	

