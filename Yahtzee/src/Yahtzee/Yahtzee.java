package Yahtzee;
import java.util.Scanner;
import java.util.Random;

// Aarav Samal


public class Yahtzee {
	
	static int[] roles = new int[3];//Array for the dice roles
	
	static boolean selected1 = false; //boolean to make sure player only gets one score per section
	static boolean selected2 = false; 
	static boolean selected3 = false; 
	static boolean selected4 = false; 
	static boolean selected5 = false; 
	static boolean selected6 = false; 
	static boolean selectedPair = false;
	static boolean selectedThreeZee = false;
	static boolean selectedChance = false;
	static boolean selectedStraight = false;
	
	static int total_score = 0;
	static int points1;//points for each section
	static int points2;
	static int points3;
	static int points4;
	static int points5;
	static int points6;
	static int points_pair;
	static int points_ThreeZee;
	static int points_chance;
	static int points_straight;

	
	static int choice;//If the user what score they want

	
	public static void main(String[] args) {
		Scanner ask = new Scanner(System.in);
		Random rand = new Random();
		
		while(selected1 == false || selected2 == false || //contin ue playing until all sections are filled
				selected3 == false || selected4 == false || 
				selected5 == false || selected6 == false || 
				selectedPair == false || selectedThreeZee == false || 
				selectedChance == false || selectedStraight == false){	
			
			roll_dice();//rolling the dice
			scores();//getting the scores and orinting it
			
			//for(int x = 0; x < 3; x++){
				System.out.println("Would you like to \"save\" any dice? y or n");
				String save = ask.next();
				save.toLowerCase();
				
				if(save.equals("y")){
					save();
				}
				else {
					choose_points();
					add_points();
					//break;
				}
			//}
			
		}
		System.out.println("\n\n\n\n**********************************************************************\n\n\n");
		System.out.println("                           Final score board: \n");

		print_board();
		System.out.println("\nGame over. You finished with a score of: " + total_score + " points");
		
		System.out.println("\n\n\n**********************************************************************");

		

	}
	
	public static void roll_dice() {//rolling the dice
		Random rand = new Random();
		System.out.print("\n\nDice: ");
		
		
		roles[0] = rand.nextInt(5)+1;
		roles[1] = rand.nextInt(5)+1;
		roles[2] = rand.nextInt(5)+1;
		
		/*
		roles[0] = 1;
		roles[1] = 2;
		roles[2] = 3;
		*/
		
		System.out.println(roles[0] + ", " + roles[1] + ", " + roles[2]);
		
	}
	
	public static void scores() {//getting the scores and printing it
		
		System.out.print("\n\n");
		ones();
		twos();
		threes();
		fours();
		fives();
		sixes();
		pair();
		ThreeZee();
		chance();
		straight();
		print_board();
		
	}
	
	public static void choose_points() {//asking the user what score they want
		Scanner ask = new Scanner(System.in);

		System.out.println("These are the scores you are eligible for. Which one are you choosing? \n"
				+ "Enter 1, 2, 3, 4, 5, 6, 7(pair), 8(straight), 9(chnace), 10(ThreeZee) \n\n");
		choice = ask.nextInt();
		//System.out.println(choice);
		//choice = choice.toLowerCase();
	}
	
	public static void add_points() {//adding the points to the total
		//System.out.println(choice);
		
		switch (choice) {
			case 1:
				total_score += points1;
				//System.out.println("Total Score: " + total_score);
				selected1 = true;
				break;
			
			case 2:
				total_score += points2;
				//System.out.println("Total Score: " + total_score);	
				selected2 = true;
				break;
			
			case 3:
				total_score += points3;
				//System.out.println("Total Score: " + total_score);	
				selected3 = true;
				break;
			case 4:
				total_score += points4;
				//System.out.println("Total Score: " + total_score);	
				selected4 = true;
				break;
			
			case 5:
				total_score += points5;
				//System.out.println("Total Score: " + total_score);
				selected5 = true;
				break;
			
			case 6:
				total_score += points6;
				//System.out.println("Total Score: " + total_score);
				selected6 = true;
				break;
				
			case 7:
				total_score += points_pair;
				//System.out.println("Total Score: " + total_score);
				selectedPair = true;
				break;
				
			case 8:
				total_score += points_straight;
				//System.out.println("Total Score: " + total_score);
				selectedStraight = true;
				break;
			
			case 9:
				total_score += points_chance;
				//System.out.println("Total Score: " + total_score);
				selectedChance = true;
				break;
			
			case 10:
				total_score += points_ThreeZee;
				//System.out.println("Total Score: " + total_score);
				selectedThreeZee = true;
				break;
			

		}

	}
	
	public static void print_board() {
		
		String Points1 = Integer.toString(points1);//converting the int to string
		String Points2 = Integer.toString(points2);//converting the int to string
		String Points3 = Integer.toString(points3);//converting the int to string
		String Points4 = Integer.toString(points4);//converting the int to string
		String Points5 = Integer.toString(points5);//converting the int to string
		String Points6 = Integer.toString(points6);//converting the int to string
		String Points_Pair = Integer.toString(points_pair);//converting the int to string
		String Points_ThreeZee = Integer.toString(points_ThreeZee);//converting the int to string
		String Points_chance = Integer.toString(points_chance);//converting the int to string
		String Points_straight = Integer.toString(points_straight);//converting the int to string
		
		System.out.println("(*) ===> the score has already been picked and you cannot pick it again.");
		
		System.out.println("|------------|-------------|");
		
		if(selected1 == false) {//Show wether the score has been selected or not
			System.out.println("|    Ones    |      " +  points1  +    "      |");

		}
		else {
			System.out.println("|  Ones (*)  |      " +  points1  +    "      |");
		}
		
		System.out.println("|------------|-------------|");
		
		if(selected2 == false) {//Show wether the score has been selected or not
			System.out.println("|    Twos    |      " +  points2  +    "      |");
		}
		else {
			System.out.println("|  Twos (*)  |      " +  points2  +    "      |");
		}
		
		System.out.println("|------------|-------------|");
		
		if(selected3 == false) {//Show wether the score has been selected or not
			System.out.println("|   Threes   |      " +  points3  +    "      |");
		}
		else {
			System.out.println("| Threes (*) |      " +  points3  +    "      |");
		}	
		
		System.out.println("|------------|-------------|");
		
		if(selected4 == false) {//Show wether the score has been selected or not
			if(Points4.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|   Fours    |      " +  points4  +    "      |");	
			}
			else {
				System.out.println("|   Fours    |      " +  points4  +    "     |");	
			}	
		}
		else {
			if(Points4.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|  Fours (*) |      " +  points4  +    "      |");	
			}
			else {
				System.out.println("|  Fours (*) |      " +  points4  +    "     |");	
			}	
		}
			
		System.out.println("|------------|-------------|");
		
		if(selected5 == false) {//Show wether the score has been selected or not
			if(Points5.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|   Fives    |      " +  points5  +    "      |");	
			}
			else {
				System.out.println("|   Fives    |      " +  points5  +    "     |");	
			}
		}
		else {
			if(Points5.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|  Fives (*) |      " +  points5  +    "      |");	
			}
			else {
				System.out.println("|  Fives (*) |      " +  points5  +    "     |");	
			}
		}
		System.out.println("|------------|-------------|");
		
		if(selected6 == false) {//Show wether the score has been selected or not
			if(Points6.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|   Sixes    |      " +  points6  +    "      |");	
			}
			else {
				System.out.println("|   Sixes    |      " +  points6  +    "     |");	
			}
		}
		else {
			if(Points6.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|  Sixes (*) |      " +  points6  +    "      |");	
			}
			else {
				System.out.println("|  Sixes (*) |      " +  points6  +    "     |");	
			}
		}
		System.out.println("|------------|-------------|");
		
		if(selectedPair == false) {//Show wether the score has been selected or not
			if(Points_Pair.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|   Pairs    |      " +  points_pair  +    "      |");	
			}
			else {
				System.out.println("|   Pairs    |      " +  points_pair  +    "     |");	
			}
		}
		else {
			if(Points_Pair.length() == 1) {//printing the table and formating it so it is align
				System.out.println("| Pairs (*)  |      " +  points_pair  +    "      |");	
			}
			else {
				System.out.println("| Pairs (*)  |      " +  points_pair  +    "     |");	
			}	
		}
		
		System.out.println("|------------|-------------|");
		
		if(selectedStraight == false) {//Show wether the score has been selected or not
			if(Points_straight.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|  Straight  |      " +  points_straight  +    "      |");	
			}
			else {
				System.out.println("|  Straight  |      " +  points_straight  +    "     |");	
			}
		}
		else {
			if(Points_straight.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|Straight (*)|      " +  points_straight  +    "      |");	
			}
			else {
				System.out.println("|Straight (*)|      " +  points_straight  +    "     |");	
			}
		}
		
		System.out.println("|------------|-------------|");
		
		if(selectedChance == false) {//Show wether the score has been selected or not
			if(Points_chance.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|   Chance   |      " +  points_chance  +    "      |");	
			}
			else {
				System.out.println("|   Chance   |      " +  points_chance  +    "     |");	
			}
		}
		else {
			if(Points_chance.length() == 1) {//printing the table and formating it so it is align
				System.out.println("| Chance (*) |      " +  points_chance  +    "      |");	
			}
			else {
				System.out.println("| Chance (*) |      " +  points_chance  +    "     |");	
			}
		}
		
		System.out.println("|------------|-------------|");
		
		if(selectedThreeZee == false) {//Show wether the score has been selected or not
			if(Points_ThreeZee.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|  ThreeZee  |      " +  points_ThreeZee  +    "      |");	
			}
			else {
				System.out.println("|  ThreeZee  |      " +  points_ThreeZee  +    "     |");	
			}
		}
		else {
			if(Points_ThreeZee.length() == 1) {//printing the table and formating it so it is align
				System.out.println("|ThreeZee (*)|      " +  points_ThreeZee  +    "      |");	
			}
			else {
				System.out.println("|ThreeZee (*)|      " +  points_ThreeZee  +    "     |");	
			}
		}
		System.out.println("|------------|-------------|");
	}
	
	public static void save() {//Saving a dice
		Scanner ask = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("What dice do you want to save. Enter 1, 2, 3. ");
		int number = ask.nextInt();
		System.out.println("Do you want to save another dice? y or n");
		String saveMore = ask.next();
		
		if(number == 1) {
			if(saveMore.equals("y")){
				System.out.println("Which dice do you want to save?");
				int number2 = ask.nextInt();
				
				if(number2 == 2){
					roles[2] = rand.nextInt(5)+1;
				}
				else {
					roles[1] = rand.nextInt(5)+1;
				}
			}
			else {
				roles[1] = rand.nextInt(5)+1;
				roles[2] = rand.nextInt(5)+1;
			}
		}
		else if(number == 2) {
			if(saveMore.equals("y")){
				System.out.println("Which dice do you want to save?");
				int number2 = ask.nextInt();
				
				if(number2 == 1){
					roles[2] = rand.nextInt(5)+1;
				}
				else {
					roles[0] = rand.nextInt(5)+1;
				}
			}
			else {
				roles[0] = rand.nextInt(5)+1;
				roles[2] = rand.nextInt(5)+1;
			}
		}
		else if(number == 3) {
			if(saveMore.equals("y")){
				System.out.println("Which dice do you want to save?");
				int number2 = ask.nextInt();
				
				if(number2 == 2){
					roles[0] = rand.nextInt(5)+1;
				}
				else {
					roles[1] = rand.nextInt(5)+1;
				}
			}
			else {
				roles[0] = rand.nextInt(5)+1;
				roles[1] = rand.nextInt(5)+1;
			}
		}
		
		System.out.println("Dice: " + roles[0] + ", " + roles[1] + ", " + roles[2]);
		scores();
		choose_points();
		add_points();
		
	}
	
	public static void ones() {//Finding the score 

		if(selected1 == false){
			points1 = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 1) {
					 points1++;
				}
			}
			
			//System.out.println("Ones: " + points1);
		}
	}
	
	public static void twos() {//Finding the score
		
		if(selected2 == false){	
			points2 = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 2) {
					 points2+=2;
				}
			}
			
			//System.out.println("Twos: " + points2);
			
		}
	}
	
	public static void threes() {//Finding the score
		
		if(selected3 == false){	
			points3 = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 3) {
					 points3+=3;
				}
			}
			
			//System.out.println("Threes: " + points3);
			
		}
	}
	
	public static void fours() {//Finding the score
		
		if(selected4 == false){	
			points4 = 0;
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 4) {
					 points4+=4;
				}
			}
			
			//System.out.println("Fours: " + points4);
			
		}
	}
	
	public static void fives() {//Finding the score
		
		if(selected5 == false){	
			points5 = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 5) {
					 points5+=5;
				}
			}
			
			//System.out.println("Fives: " + points5);
			
		}
	}
	
	public static void sixes() {//Finding the score
		
		if(selected6 == false){	
			points6 = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				if(roles[x] == 6) {
					 points6+=6;
				}
			}
			
			//System.out.println("Six: " + points6);
			
		}
	}
	
	public static void pair() {//Finding the score
		
		if(selectedPair == false) {
			points_pair = 0; 
			
			for(int i = 0; i < roles.length; i++) {  
				for(int j = i + 1; j < roles.length; j++) {  
					if(roles[i] == roles[j]) {
			            points_pair = 20; 
			        }
			               
			    }  
			} 
			
			//System.out.println("Pair: " + points_pair);
		
			
		}
	}
	
	public static void ThreeZee() {//Finding the score
		
		if(selectedThreeZee == false) {
			points_ThreeZee = 0; 
			
			for(int i = 0; i < roles.length; i++) {  
		        for(int j = i + 1; j < roles.length; j++) {  
		        	for(int k = j + 1; k < roles.length; k++) { 
			        	if(roles[i] == roles[j] && roles[i] == roles[k]) {
			        		points_ThreeZee = 50; 
				        }
		        	} 
		        }  
		    } 
			
			//System.out.println("Three-Zee: " + points_ThreeZee);
			
					
		}
		
	}
	
	public static void chance() {//Finding the score
		
		if(selectedChance == false){	
			points_chance = 0; 
			
			for(int x = 0; x < roles.length; x++) {
				 points_chance+=roles[x];
				 //System.out.println(points_chance);
			}
			 //System.out.println(points_chance);
			
		}
	}
	
	public static void straight() {//Finding the score
		
		if(selectedStraight == false){	
			points_straight = 0; 

			if(roles[0] + 1 == roles[1] && roles[1] + 1 == roles[2]) {
				points_straight = 15; 
			}
		}
	}
}
