/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmeringsuppgift1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pontus arnell, pontus.arnell@gmail.com
 */
public class Programmeringsuppgift1 {

// stolen from internet didnt know how to do color in console java way 20210114   
// https://www.codegrepper.com/code-examples/java/java+console+text+color
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

// my code
    // the inputreader
    static BufferedReader reader;

    // color options for visual output
    static String myTextColor = TEXT_BLACK;
    static String myBackgroundColor = ANSI_WHITE_BACKGROUND;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        Boolean exit = false;
        while (!exit) {
            printOptions();

            String input;
            try {
                input = reader.readLine();
                exit = doAction(input);
            } catch (IOException ex) {
                colorOutput(" handled exception, exit gracefully, cleaning up");
                exit = true;

                try {
                    reader.close();
                } catch (IOException ex1) {
                    colorOutput(" shit happened, cant clean, exit anyway hope operating system  or JVM cleans");
                    Logger.getLogger(Programmeringsuppgift1.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(Programmeringsuppgift1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * just prints the options menu
     */
    private static void printOptions() {
        colorOutput(" type one of the following options: (option) -> action");
        colorOutput(" 0 -> exit");
        colorOutput(" 1 -> print hello world");
        colorOutput(" 2 -> type in name surname age either on one row separated by space or each value on its own by pressing enter 3 times , values will be echoed");
        colorOutput(" 3a -> choose text color");
        colorOutput(" 3b -> choose background color");
        colorOutput(" 4 -> prints todays date on the system as UNIX date");
        colorOutput(" 5 -> type in two values, largest will be echoed ");
        colorOutput(" 6 -> guess a number between 1 and 100");
        colorOutput(" 7 -> type a line of text thats then saved to file");
        colorOutput(" 8 -> read the file you created and wrote to in option 7");
        colorOutput(" 9 -> reads a number, prints sqrt, power of 2, power of 10");
        colorOutput(" 10 -> Prints choosen multiplication table");
        colorOutput(" 11 -> creates two arrays x long, one sorted ascending ");
        colorOutput(" 12 -> test if a word is a palindrome");
        colorOutput(" 13 -> prints integer values between number 1 and number 2");
        colorOutput(" 14 -> type in values separated by comma, will be sorted odd/even outputs ");
        colorOutput(" 15 -> type in values separated by comma, they will be summed up");
        colorOutput(" 16 -> name player, opponent, basic properties will be randomized");
    }

    /**
     * actions are handled here, big actios have thier own methods started from
     * this method
     *
     * @param input
     * @return
     */
    private static boolean doAction(String input) throws IOException {
        if ("0".equalsIgnoreCase(input)) {
            // user wants to exit
            colorOutput("Exit you choose, exit you shall, bye! :)");
            return true;
        } else if ("1".equalsIgnoreCase(input)) {
            // user wants to print Hello World
            colorOutput("Hello World");
        } else if ("2".equalsIgnoreCase(input)) {
            // user wants to type in name surname age
            typeInNameSurnameAge();
        } else if ("3a".equalsIgnoreCase(input)) {
            // user wants to change text color
            colorOutput("please dont choose same color as background as it may hinder your visual experience");
            chooseTextColor();
        } else if ("3b".equalsIgnoreCase(input)) {
            // user wants to change background color
            colorOutput("please dont choose same color as text as it may hinder your visual experience");
            chooseBackgroundColor();
        } else if ("4".equalsIgnoreCase(input)) {
            // user wants to print todays date
            colorOutput("your systems UNIX date: " + System.currentTimeMillis());
            // not specified but when/if customer want human readable format add/switch to following:
            // (new SimpleDateFormat("yyyy-MM-dd" 'at' HH:mm:ss z")).format(new Date(System.currentTimeMillis())); 
        } else if ("5".equalsIgnoreCase(input)) {
            // user choose to type 2 number , largest returned
            echoLargestNumber();
        } else if ("6".equalsIgnoreCase(input)) {
            // user want to guess number between 1 and 100, if right print number of attempts else 
            // print if guess was to big or to small
            playGuessingGame();
        } else if ("7".equalsIgnoreCase(input)) {
            // skriv text, spara till fil
            saveTextToFile();
        } else if ("8".equalsIgnoreCase(input)) {
            // läs in fil och skriv rad till console
            readFileToConsole();
        } else if ("9".equalsIgnoreCase(input)) {
            // läs tal, gör uträkningar och printa
            readNumberDoSQRT_PW2_PW10();
        } else if ("10".equalsIgnoreCase(input)) {
            // be om multiplikationstabell och skriv ut den med tab "\t"
            choosePrintMultplicationTable();
        } else if ("11".equalsIgnoreCase(input)) {
            // be om längd, skapa array, sortera stigande, printa båda
            printArraysWithNumbers();
        } else if ("12".equalsIgnoreCase(input)) {
            // se om input är palindrom
            palindromTester();
        } else if ("13".equalsIgnoreCase(input)) {
            // printa heltals nummer mellan värde 1 och värde 2
            printNumbersFromVal1Toval2();
        } else if ("14".equalsIgnoreCase(input)) {
            // sortera comma separerad input i jämn och udda output
            sortCommaSeparatedInputOddEven();
        } else if ("15".equalsIgnoreCase(input)) {
            // summera input som integers , ignore bad inputs
            sumCommaSeparatedInput();
        } else if ("16".equalsIgnoreCase(input)) {
            // namge karaktär och motståndare, få  grundegenskaper slumpmässigt
            createCharacters();
        }

        return false;
    }

    private static void typeInNameSurnameAge() throws IOException {

        // the idea is to let user type in values, separated by space, 
        // if not 3 values are gathered , keep asking, I dont bother
        // with sanitizing data at this stage ie check that hames or
        // ages make sense.
        colorOutput("please type in name surname age, either all in one go or one item on each line");
        String[] values = new String[3];
        int pos = 0;

        while (pos < 3) {

            String input = reader.readLine();
            String[] temp = input.split(" ");
            int innerpos = 0;
            if (temp.length > 0) {
                while (pos < 3 && innerpos < temp.length) {
                    values[pos] = temp[innerpos];
                    pos++;
                    innerpos++;
                }
            }
        }
        colorOutput("echoing [name, surname, age] : " + values[0] + " " + values[1] + " " + values[2]);

    }

    /**
     * just handles all output with choosen colors
     *
     * @param output
     */
    private static void colorOutput(String output) {
        System.out.println(myBackgroundColor + " " + myTextColor + output + TEXT_RESET);

    }

    private static void chooseTextColor() throws IOException {
        String tempColor = myTextColor; // printar varje möjlighet som egen färg
        colorOutput(" type in corresponding number for the color you want the text to appear in ");
        myTextColor = TEXT_BLACK;
        colorOutput(" 1 -> black");
        myTextColor = TEXT_RED;
        colorOutput(" 2 -> red");
        myTextColor = TEXT_GREEN;
        colorOutput(" 3 -> green");
        myTextColor = TEXT_YELLOW;
        colorOutput(" 4 -> yellow");
        myTextColor = TEXT_BLUE;
        colorOutput(" 5 -> blue");
        myTextColor = TEXT_PURPLE;
        colorOutput(" 6 -> purple");
        myTextColor = TEXT_CYAN;
        colorOutput(" 7 -> cyan");
        myTextColor = TEXT_WHITE;
        colorOutput(" 8 -> white");
        myTextColor = tempColor; // återställer till orginal
        boolean colorChoosen = false;
        while (!colorChoosen) {
            String input = reader.readLine();

            // vet att det finns switch case även för strings men gillar if else bättre 
            if (input.equalsIgnoreCase("1")) {
                myTextColor = TEXT_BLACK;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("2")) {
                myTextColor = TEXT_RED;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("3")) {
                myTextColor = TEXT_GREEN;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("4")) {
                myTextColor = TEXT_YELLOW;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("5")) {
                myTextColor = TEXT_BLUE;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("6")) {
                myTextColor = TEXT_PURPLE;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("7")) {
                myTextColor = TEXT_CYAN;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("8")) {
                myTextColor = TEXT_WHITE;
                colorChoosen = true;
            }
        }
    }

    private static void chooseBackgroundColor() throws IOException {
        String tempColor = myBackgroundColor; // printar varje möjlighet som egen färg
        colorOutput(" type in corresponding number for the color you want the text to appear in ");
        myBackgroundColor = ANSI_BLACK_BACKGROUND;
        colorOutput(" 1 -> black");
        myBackgroundColor = ANSI_RED_BACKGROUND;
        colorOutput(" 2 -> red");
        myBackgroundColor = ANSI_GREEN_BACKGROUND;
        colorOutput(" 3 -> green");
        myBackgroundColor = ANSI_YELLOW_BACKGROUND;
        colorOutput(" 4 -> yellow");
        myBackgroundColor = ANSI_BLUE_BACKGROUND;
        colorOutput(" 5 -> blue");
        myBackgroundColor = ANSI_PURPLE_BACKGROUND;
        colorOutput(" 6 -> purple");
        myBackgroundColor = ANSI_CYAN_BACKGROUND;
        colorOutput(" 7 -> cyan");
        myBackgroundColor = ANSI_WHITE_BACKGROUND;
        colorOutput(" 8 -> white");
        myBackgroundColor = tempColor; // återställer till orginal
        boolean colorChoosen = false;
        while (!colorChoosen) {
            String input = reader.readLine();

            // vet att det finns switch case även för strings men gillar if else bättre 
            if (input.equalsIgnoreCase("1")) {
                myBackgroundColor = ANSI_BLACK_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("2")) {
                myBackgroundColor = ANSI_RED_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("3")) {
                myBackgroundColor = ANSI_GREEN_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("4")) {
                myBackgroundColor = ANSI_YELLOW_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("5")) {
                myBackgroundColor = ANSI_BLUE_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("6")) {
                myBackgroundColor = ANSI_PURPLE_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("7")) {
                myBackgroundColor = ANSI_CYAN_BACKGROUND;
                colorChoosen = true;
            } else if (input.equalsIgnoreCase("8")) {
                myBackgroundColor = ANSI_WHITE_BACKGROUND;
                colorChoosen = true;
            }
        }
    }

    /**
     * reads string, transform to double and ask for input until number is read
     *
     * @return
     * @throws IOException
     */
    private static double readDouble() throws IOException {
        boolean isNumber = false;
        double val = 0;
        while (!isNumber) {
            colorOutput("Please type a number");
            String input = reader.readLine();
            try {
                val = Double.valueOf(input);
                isNumber = true;
            } catch (NumberFormatException e) {
                colorOutput("value typed examined, not a number , please try again human! :P");
            }
        }
        return val;
    }

    private static void echoLargestNumber() throws IOException {
        colorOutput("please type in two values , one on each line, largest will be returned");
        double value1 = readDouble();
        double value2 = readDouble();

        if (value1 > value2) {
            colorOutput("The numbers you have given me , hm, simple, but it is of course: " + value1);
            // branchpredicting  by cpu will more often choose this alternative, therefore I guess simple
        } else {
            colorOutput("The numbers you have given me , hm, hard, but it is of course: " + value2);
        }

    }

    private static void playGuessingGame() throws IOException {
        double secretNumber = Math.ceil((Math.random() * 100.0));
        colorOutput("Let the game Start! I have allready choosen my secret number!");
        colorOutput("Have the best guess and you shall recieve infite cheers and cookies from your office collegues!");

        boolean rightAnswer = false;

        int numberOfAttempts = 0;
        while (!rightAnswer) {
            double guess = Math.ceil(readDouble());
            numberOfAttempts++;
            if (guess == secretNumber) {
                colorOutput("You guessed correct. Number of tries: " + numberOfAttempts);
                rightAnswer = true;
            } else {
                String temp = "larger";
                if (guess > secretNumber) {
                    temp = "smaller";
                }
                colorOutput("FOOL! thats not the right answer, it is of course a " + temp + " number that I have choosen as a secret!");
            }
        }

    }

    private static void saveTextToFile() throws IOException {
        colorOutput("please type text to save to file: tempFile.txt");
        String input = reader.readLine();
        PrintWriter out = new PrintWriter("tempFile.txt");

        // har inte tänkt igenom , kan ju bli io exception när man skriver till fil och nu kastas det upp bara...
        out.println(input);
        out.close();

    }

    private static void readFileToConsole() throws IOException {
        try {
            FileReader fileReader = new FileReader("tempFile.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String fileLine = br.readLine();
            colorOutput("File read, line: ");
            colorOutput(fileLine);
        } catch (FileNotFoundException ex) {
            colorOutput("FileNotFound, try create a file first by choosing option 7 in the menu");
            Logger.getLogger(Programmeringsuppgift1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void readNumberDoSQRT_PW2_PW10() throws IOException {
        double val = readDouble();
        colorOutput("Typed number is: " + val + ", this number will be transformed to a vector sqrt(num), pow(num, 2), pow( num, 10)");
        colorOutput(Math.sqrt(val) + ", " + Math.pow(val, 2) + ", " + Math.pow(val, 10));
    }

    private static void choosePrintMultplicationTable() throws IOException {
        colorOutput("please type a number, this will be the multiplication table start number");
        double val = readDouble(); // vet  att det inte är integer. kul med 3.14 multiplikationstabell va?
        // ja, fixar inte till att vissa doubles kommer printas med flera decimaler.

        String str = "table nbr:" + val + ", ten first numbers: ";
        for (int i = 1; i < 11; i++) {
            str = str + "\t" + i * val;
        }
        colorOutput("Multiplication table created:");
        colorOutput(str);
    }

    private static void printArraysWithNumbers() throws IOException {

        int val = (int) Math.ceil(readDouble());
        while (val < 1) { // visst integer nu, men kanske negativ eller noll
            colorOutput("Please type a positive integer greater than 0");
            val = Integer.parseInt(" " + Math.ceil(readDouble()));
        }

        Double[] doubleArray = new Double[val];
        Double[] sortedArray = new Double[val];
        for (int i = 0; i < val; i++) {
            doubleArray[i] = Math.random();
            sortedArray[i] = doubleArray[i];
        }

        Arrays.sort(sortedArray);

        String array = "";
        String sorted = "";
        for (int i = 0; i < val; i++) {
            array = array + " " + doubleArray[i];
            sorted = sorted + " " + sortedArray[i];
        }
        colorOutput("array with length: " + val);
        colorOutput(array);
        colorOutput("same array but sorted in ascending order: ");
        colorOutput(sorted);
    }

    private static void palindromTester() throws IOException {
        colorOutput("Please typa a word or sentence, it will be palindrome tested.");
        String input = reader.readLine();

        input = input.trim();
        input = input.toLowerCase();

        boolean isPalindrome = true;
        int i = 0;
        while (isPalindrome && i < (input.length() / 2)) {
            char charAt0 = input.charAt(i);
            char charAt1 = input.charAt(input.length() - (1 + i));
            isPalindrome = (charAt0 == charAt1);
            i++;
        }
        if (isPalindrome) {
            colorOutput("the statement " + input + " is a palindrome");
            return;
        }
        colorOutput("the statement " + input + " is not a palindrome");
    }

    private static void printNumbersFromVal1Toval2() throws IOException {

        int val0 = (int) Math.ceil(readDouble());
        int val1 = (int) Math.ceil(readDouble());

        if (val0 < val1) {
            int t = val1;
            val1 = val0;
            val0 = t;
        }
        //val0 > val1 nu, 

        int diff = val0 - val1;

        String str = "";

        for (int i = 0; i <= diff; i++) {
            int k = (val1 + i);
            str = str + " " + k;
        }
        colorOutput("numbers between " + val1 + " and " + val0 + ", both included for clarity");
        colorOutput(str);

    }

    private static void sortCommaSeparatedInputOddEven() throws IOException {
        colorOutput("plese type input the following way : number, number, number.... , numbers not a number will be discarded");
        String input = reader.readLine();
        String[] split = input.split(",");
        String even = "even: ";
        String odd = " odd:";
        String notANumber = "not a number: ";

        // jo man kan göra sånt här med java 8 stream syntax , men det går fortare för mig att bara göra tyvärr på gammalt hederligt vis
        for (int i = 0; i < split.length; i++) {
            try {
                int k = Integer.parseInt(split[i]);
                if (k % 2 == 0) {
                    even = even + " " + split[i];
                } else {
                    odd = odd + " " + split[i];
                }
            } catch (NumberFormatException e) {
                // ignore move on, or?
                notANumber = notANumber + " " + split[i];
            }

        }
        colorOutput(even);
        colorOutput(odd);
        colorOutput(notANumber);

    }

    private static void sumCommaSeparatedInput() throws IOException {
        colorOutput("plese type input the following way : number, number, number.... , numbers not a number will be discarded");

        String input = reader.readLine();
        String[] split = input.split(",");

        int sum = 0;

        for (int i = 0; i < split.length; i++) {
            try {
                int k = Integer.parseInt(split[i]);
                sum += k;
            } catch (NumberFormatException e) {
                // ignore move on, or?
            }
        }
        colorOutput("the sum is: " + sum);
    }

    private static void createCharacters() throws IOException {
        colorOutput("please give your character a name: ");
        String name = reader.readLine();
        colorOutput("please name your opponent: ");
        String opponent = reader.readLine();
        
         Character me = new Character(name);
         Character opp = new Character(opponent);
        
         colorOutput(me.toString());
         colorOutput(opp.toString());
        
    }
}


     class Character{
    
        private String name;
        private double health;
        private double strength;
        private double luck;
        
        public Character(String name){
            this.name=name;
            health= Math.random();
            strength= Math.random();
            luck= Math.random();
        }

        
        public String getName(){
            return name;
        }
        
        public double getHealth(){
            return health;
        }
        
        public double getStrength(){
            return strength;
        }
        
        public double getLuck(){
            return luck;
        }
        
        @Override
        public String toString(){
            return "Name: "+getName()+", Health: "+getHealth()+", Strength: "+getStrength()+", Luck: "+getLuck();
        }
        
    }


