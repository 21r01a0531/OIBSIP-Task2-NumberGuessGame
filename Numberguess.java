import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Numberguess {

	public static void main(String[] args) throws IOException {
		
		Random randomNum =  new Random();	
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String guessedNum;
		
		
		
		int points = 0;
		int aa=0;
		
		String prompt =  new String();
		
		
		do { 
			int lives = 5; //adjust lives per round
			int roundPoints = lives * 10; 
			int setPoints = lives * 10; //for line: 43
			int generatedNum = randomNum.nextInt(100) + 1;
			
			//Remove this line after testing
			System.out.println("[For testing purposes generated number = " 
											+ generatedNum +"]");
			
			
			do { 
				
				System.out.print("Enter your guess: ");
				guessedNum = br.readLine();
				
				if(Integer.toString(generatedNum).equals(guessedNum)) {
					System.out.println("You've guessed correct !!");
					System.out.println("Points scored this round = " + roundPoints 
							+ "/" + setPoints);
					points += roundPoints;
					
					
					System.out.println("Total points: " + points);
							
					System.out.println();
					System.out.println("Do you wish to play again? (y/n)");
					
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					prompt = br2.readLine();
					break;
					
				}
				
				else if(lives == 0) {
					
					System.out.println("You lost. The correct guess was " + generatedNum);
					System.out.println("Points = 0");
					System.out.println();
					System.out.println("Do you wish to play again? (y/n)");
					
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					prompt = br2.readLine();
					break;
				}

				
				
				else if (!Integer.toString(generatedNum).equals(guessedNum)) { 
					System.out.println("You guessed wrong. Try again.");
					System.out.println("Lives remaining: " + lives);
					System.out.println();
					lives--;
					roundPoints -= 10;
				}
				
							
			} while (!Integer.toString(generatedNum).equals(guessedNum));
		}while(prompt.equals("y"));
		
	

	}

}
