import java.util.Scanner; // import scanner class to read input from the user

public class WordsGameApp
{
    public static void main(String args[]) // declare main method
    {

        // declare variables
        String p1, p2; // player 1 and player 2 input
        String replay = null; // replay game input option
        boolean isSame = false; // correct letters used validation
        boolean isValid = false; // word matches array of valid words validation

        // create object of type WordsGame
        WordsGame obj = new WordsGame();

        // create object of type Scanner
        Scanner input = new Scanner(System.in);

// ---------- do... while loop to loop the entire game process while player input equals to "yes" --------
        do
        {
            // how to play, game rules, points rules....
            System.out.println(".......................................");
            System.out.println(" "); // empty space to make game outline more readable
            System.out.println("   WELCOME TO THE COMPUTER WORDS GAME");
            System.out.println(" ");
            System.out.println(".......................................");
            System.out.println(" ");
            System.out.println("             HOW TO PLAY:");
            System.out.println(" ");
            System.out.println("Players must guess computer related words using 12 randomly selected letters");
            System.out.println(" ");
            System.out.println("              GAME RULES:");
            System.out.println(" ");
            System.out.println("1. Letters used much match the random letters given");
            System.out.println("2. A letter can only be used as frequently as it appears in the random letter seclection");
            System.out.println("3. Players can not use the same words as eachother (per round)");
            System.out.println(" ");
            System.out.println("             POINTS RULES: ");
            System.out.println(" ");
            System.out.println("1. If word contains 'a' AND 'e' POINTS: 2.5 points ONLY");
            System.out.println("2. If word contains all other letters (not including 'a' AND 'e') POINTS: 1 point per letter");
            System.out.println("3. Points are not awarded for invalid words");
            System.out.println(" ");
            System.out.println(".......................................");
            System.out.println(" ");
            System.out.println("              GAME BEGINS!");
            System.out.println(" ");
            System.out.println(".......................................");
            System.out.println(" ");
            obj.genLetters(); //call generate random letters method from instantiable class (I.C)
            String randomString = obj.getRandomString(); // call getter method for the random string and store in variable randomString
            System.out.println("The 12 random letters are: " + randomString); // display random letters to user
            System.out.println(" ");

// --------------- PLAYER 1 INPUT -----------------
            System.out.println("PLAYER 1 enter your word: ");
            p1 = input.next().toLowerCase(); // player 1 input convert all letters to lower case
            obj.setP1(p1); // set player 1 input to I.C
            obj.sameLetters(); // call method from I.C to validate correct letter usage
            obj.checkArray(); // call method from I.C to validate player word against array of valid words
            obj.calcPoints(); // call method from I.C to calculate the points of player word
            isSame = obj.getIsSame(); // call getter method from I.C to retrieve letters validation and store in boolean isSame
            isValid = obj.getIsValid(); // call getter method from I.C to retrieve word validation and store in boolean isValid

            if (isValid != false && isSame != false) // if player 1 word is valid and correct letters are used
            {
                System.out.println("CORRECT! '" + p1 + "' is a valid word.");
                double points = obj.getPoint1(); // call getter method from I.C to retrieve player 1 points for valid word
                System.out.println("POINTS for '" + p1 + "': " + points);
            }
            else if (isSame != true) // else if letters to do not match the output letters
            {
                System.out.println("Letters do not match!"); 
          
            }
            else // else the above statements do not meet the requirements then player word must be invalid
            {

                System.out.println("WRONG! '" + p1 + "' is not a valid word.");
                // double points = obj.getPoint1(); // call getter method from I.C to retrieve player 1 points for valid word
                // System.out.println("POINTS for '" + p1 + "': " + points);

            }

// --------------- PLAYER 2 INPUT same as above, with two more methods added (see below)-----------------
            System.out.println(" ");
            System.out.println("PLAYER 2 enter your word: ");
            p2 = input.next().toLowerCase();
            obj.setP2(p2);
            obj.sameWords(); // call method from I.C to check if player 2 word is the same as player 1 word per round
            obj.checkArray2();
            obj.calcPoints2();
            obj.sameLetters2();
            isSame = obj.getIsSame2();
            isValid = obj.getIsValid2();
            boolean sameWords = obj.getSameWords();

            if (sameWords != false) // if player 2 word is same as player 1 word
            {
                System.out.println("WHOOPS! This word has already been used, try again!");
                System.out.println(" ");
                obj.winner(); // call method from I.C to display the winner of the round

            }
            else if (isValid != false && isSame != false && sameWords != true)
            {

                System.out.println("CORRECT! '" + p2 + "' is a valid word.");
                double points = obj.getPoint2();
                System.out.println("POINTS for '" + p2 + "': " + points);
                System.out.println(" ");
                obj.winner();  // call method from I.C to display the winner of the round

            }
            else if (isSame != true)
            {
                System.out.println("Letters do not match!");
                System.out.println(" ");
                obj.winner();  // call method from I.C to display the winner of the round

            }
            else
            {

                System.out.println("WRONG! '" + p2 + "' is not a valid word.");
                System.out.println(" ");
                obj.winner();  // call method from I.C to display the winner of the round
            }

            System.out.println(" ");
            System.out.println("PLAY AGAIN? (yes/no)"); // ask players if they want another round
            replay = input.next().toLowerCase(); // convert player input to lower case
        }
        while (replay.equals("yes")); // if player input equals to yes: perform the do.. while loop

    }
}