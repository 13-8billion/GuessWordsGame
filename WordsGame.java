import java.util.Random; // import random number package
// import java.util.Arrays; // import array package 


public class WordsGame
{
    // declare instance variables
    private String[] validWords; // array of valid words
    private String letters = "abcdefghijklmnopqrstuvwxyz"; // letters to get randomised 
    private String randomString; // String to hold the 12 random letters
    private String p1; // player 1 word input
    private String p2; // player 2 word input
    private boolean isValid = false; // player 1 word validation against array
    private boolean isValid2 = false; // player 1 word validation against array
    private boolean sameWords = false; // if players have the same word as
    private boolean isSame = false; //player 1 correct letters validation
    private boolean isSame2 = false; // player 2 correct letters validation
    private double point1; // player 1 points
    private double point2; // player 2 points

    // create StringBuffer object to modify "String randomString"
    StringBuffer sb = new StringBuffer();

    // create an object of Random class to randomise the letters
    Random ran = new Random();
    
    // constructor
    public WordsGame()
    {
    
        // array of valid words
        this.validWords = new String[] { "algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus",
                                         "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database",
                                         "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development", "download", "dynamic",
                                         "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon",
                                         "inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse",
                                         "mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online", "path", "process",
                                         "protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue",
                                         "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam",
                                         "screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread",
                                         "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"
                                       };
    }

// ---------- getter and setter methods ----------

    // getter method to return randomString value in app class
    public String getRandomString()
    {
        return randomString;
    }

    // getter methods to return value of boolean for word validation against array in app class
    public boolean getIsValid() 
    {
        return isValid; // player 1
    }

    public boolean getIsValid2()  
    {
        return isValid2; // player 2
    }

    // getter methods to return boolean for correct letter usage validation in app class
    public boolean getIsSame()  
    {
        return isSame; // player 1
    }

    public boolean getIsSame2()  
    {
        return isSame2; // player 2
    }

    // getter method to return unique words each round validation in app class
    public boolean getSameWords()
    {
        return sameWords;
    }

    // getter method to return value of points in app class
    public double getPoint1()  
    {
        return point1; // player 1
    }

    public double getPoint2()  
    {
        return point2; // player2
    }

    // setter methods for each player word input
    public void setP1(String p1)
    {
        this.p1 = p1; // player 1
    }
    public void setP2(String p2)
    {
        this.p2 = p2; // player 2
    }

// ------ method to generate random letters ------

    public void genLetters()
    {
        // length of random String set to 12
        int len = 12;
        for(int i = 0; i < len; i++)
        {
          
            int index = ran.nextInt(letters.length()); // generate random index number
            
            char ranChar = letters.charAt(index); // get the character specified by index
            
            sb.append(ranChar); // append the character to StringBuffer
        }
        
        // StringBuffer object converted to a String and stored in String variable randomString
        randomString = sb.toString();
        // reinitialise the StringBuffer to zero so the letters to not concatenate due to the do...while loop in app class
        sb.delete(0, sb.length());
    }

// ------ methods to check players input against array of valid words ------

    public void checkArray() 
    {
        isValid = false; // reinitialise isValid for do... while loop in app class
        for(String x : validWords) // for each String x in validWords
        {
            if(x.equals(p1)) // if String x is equal to player1 word input
            {
                isValid = true; // then player 1 word input is valid against the array of words
                break; // break the for loop
            }
        }
    }
    public void checkArray2()
    {
        isValid2 = false;
        for(String x : validWords)
        {
            if(x.equals(p2)) // player 2
            {
                isValid2 = true;
                break;
            }
        }
    }


// ------ method to calculate the points of player words ------

public void calcPoints() // player 1 method
{

    point1 = 0; // reinitialise player 1 points to zero (for do...while loop in app class)

    if (isValid != false && isSame != false) // if word matches array and the letters match the random letter output
    {
        int l = p1.length(); // store player word to int
        double points = 0; // initialise player points to zero
        for (int i = 0; i < l; i++) // traverse player 1 word from the beginning
        {

            char c = p1.charAt(i); // retrieves the current character
            if (c != 'a' && c != 'e') // if letters of word do not contain 'a' & 'e'

            {

                points = l * 1; // points = 1 per letter

            }
            else if (isValid != true || isSame != true) // if word does not match array or incorrect letters are used
            {

                points = 0;

            }
            else // else if letters of word contain 'a' & 'e'
            {

                points = 2.5; // points = 2.5 only

            }
            point1 = points; // store local variable 'points' value into the private variable 'point1'

        }
    }
}
public void calcPoints2() //player 2 method, same as above
{

    point2 = 0;

    if (isValid2 != false && (!p2.equals(p1)))
    {
        int l = p2.length();
        double points2 = 0;
        for (int i = 0; i < l; i++)
        {
            char d = p2.charAt(i);
            if (d != 'a' && d != 'e')
            {

                points2 = l * 1;

            }
            else if (isValid2 != true || isSame2 != true)
            {

                points2 = 0;

            }
            else
            {

                points2 = 2.5;

            }
            point2 = points2;

        }
    }
}
// ------ method to calculate the winner ---------

    public void winner()
    {
        if (point1 > point2 || point1 == point2 && isSame2 !=true && isValid !=false && isSame !=false) // if player 1 points are greater than payer 2 points or if points are equal but player 2 uses incorrect letters
        {
            System.out.println("PLAYER 1 WINS!");

        }
        else if (point1 < point2 && isSame2 != false) // if player 1 points are less than player 2 points and player 2 word is in array
        {
            System.out.println("PLAYER 2 WINS!");

        }
        else if (point1 == point2 && point1 != 0 && point2 != 0 && isSame2 != false) // if points are equal and not equal to zero and player 2 uses correct letters
        {
            System.out.println("IT'S A DRAW!");

        }
        else // all other scenarios mean no points have been scored
        {
            System.out.println("No points were scored this round :( ");
        }
    }

//----- methods to check letters input by user are the same as letters output by terminal -----

    public void sameLetters()
    {
    
        char[] randomStringc = randomString.toCharArray(); // convert String randomString into sequence of characters e.g char array
        char[] p1c = p1.toCharArray(); // convert player 1 input into sequence of characters e.g char array
    
        int count = 0; // initilise count to zero
    
        for (char x : p1c) // for each char x in player 1 word
            for (int i = 0; i < randomStringc.length; i++) // traverse String randomString from the beginning
            {
                if (x == randomStringc[i]) // if 'x' equals to randomString
                {
                    count++; // increment count to next character
                    isSame = true; // return boolean isSame as true
    
                    break;
                }
            }
    
        if (count != p1.length()) // if count not equals to player input
        {
            isSame = false; // return boolean isSame as false
        }
    }

  public void sameLetters2() // player 2 method, same as above
  {
  
      char[] randomStringc = randomString.toCharArray();
      char[] p2c = p2.toCharArray();
  
      int count = 0;
      for (char x : p2c)
          for (int i = 0; i < randomStringc.length; i++)
          {
              if (x == randomStringc[i])
              {
                  count++;
                  isSame2 = true;
                 
                  break;
              }
          }
  
      if (count != p2.length())
      {
          isSame2 = false;
      }
  }

 // ----- method to check if player2 uses the same word as player 2 each round -------
  
  public void sameWords()
  {
      sameWords = false; // initialise sameWords boolean to false
      if (p2.equals(p1)) // if player 2 word equals same as player 1 word
      {
          sameWords = true; // return boolean sameWords as true
      }
  }

}
    





















