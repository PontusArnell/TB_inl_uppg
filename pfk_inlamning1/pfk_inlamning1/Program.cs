using System;
using System.IO;

namespace pfk_inlamning1 { 

    class Program 
    {

        static void printMenu()
        {
            Console.WriteLine(" The Menu , (option) -> action , please type coreesponding option value hit enter for desired action");
            Console.WriteLine(" 0 -> exit software");
            Console.WriteLine(" 1 -> echo hello world");
            Console.WriteLine(" 2 -> read name surname age, echo");
            Console.WriteLine(" 3 -> See different colors in the console, no you will not be able to choose one");
            Console.WriteLine(" 4 -> print todays date");
            Console.WriteLine(" 5 -> read 2 values, echo largest");
            Console.WriteLine(" 6 -> guessing game, try to guess a number between 1 to 100 in as few attempts as possible");
            Console.WriteLine(" 7 -> läs text i console skriv till fil");
            Console.WriteLine(" 8 -> läs fil skriv till console");
            Console.WriteLine(" 9 -> läs tal få sqrt pow2 pow10");
            Console.WriteLine(" 10 -> skriv ut en multiplikationstabell, tab mellan värden");
            Console.WriteLine(" 11 -> skriv ut två talserier, en med slumptal, samma fast sorterad");
            Console.WriteLine(" 12 -> testa indata för palindrom");
            Console.WriteLine(" 13 -> läs två tal, skriv ut tal emellan");
            Console.WriteLine(" 14 -> läs tal, sortera i jämn udda");
            Console.WriteLine(" 15 -> läs tal, summera");
            Console.WriteLine(" 16 -> ge två namn, få slumpvärden på egenskaper");
        }
        static void Main(string[] args)
        {
            
            Boolean temp = true;
            while (temp) {
                printMenu();
                String str = Console.ReadLine();
                if (str.ToLower().Equals("0"))
                {
                    temp = false; // exit software
                }
                else if (str.ToLower().Equals("1") ) { 
                    printHelloWorld();    
                }
                else if (str.ToLower().Equals("2"))
                {
                    readNameSurNameAgeEcho();
                }
                else if (str.ToLower().Equals("3"))
                {
                    printColors();
                }
                else if (str.ToLower().Equals("4"))
                {
                    Console.WriteLine(DateTime.Now);   // I know not formated in human readable format.
                }
                else if (str.ToLower().Equals("5"))
                {
                    read2ValuesEchoLargest();
                }
                else if (str.ToLower().Equals("6"))
                {
                    guessingGame();
                }
                else if (str.ToLower().Equals("7"))
                {
                    readInputWriteToFile();
                }
                else if (str.ToLower().Equals("8"))
                {
                    readFileWriteToConsole();
                }
                else if (str.ToLower().Equals("9"))
                {
                    readNumberProcessSQRT_POW2_POW10();
                }
                else if (str.ToLower().Equals("10"))
                {
                    printMultiplikationTable();
                }
                else if (str.ToLower().Equals("11"))
                {
                    printRandomListAndSortedList();
                }
                else if (str.ToLower().Equals("12"))
                {
                    testIndataAsPalindrome();
                }
                else if (str.ToLower().Equals("13"))
                {
                    take2inputsWriteNumbersInBetween();
                }
                else if (str.ToLower().Equals("14"))
                {
                    readInputAndSortInOddEven();
                }
                else if (str.ToLower().Equals("15"))
                {
                    readInputAndSum();
                }
                else if (str.ToLower().Equals("16"))
                {
                    createInstancesOfCharacter();
                }
            }
        }

        private static void createInstancesOfCharacter()
        {
            Console.WriteLine("Please type name of your character: ");
            string name = Console.ReadLine();
            Character myChar = new Character(name);

            Console.WriteLine("Please type name of your opponent: ");
            string opponent = Console.ReadLine();
            Character myOpponent = new Character(opponent);

            Console.WriteLine(myChar.toString());
            Console.WriteLine(myOpponent.toString());

    }

        private static void readInputAndSum()
        {
            Console.WriteLine("type input separate with comma as 2,3,4,5....  , text will be ignored");
            String str = Console.ReadLine();
            string[] split = str.Split(",");

            int sum = 0;

            for (int i = 0; i < split.Length; i++)
            {


                try
                {
                    int result = Int32.Parse(split[i]);

                    sum += result;

                }
                catch (FormatException)
                {
                    //ignore
                }

            }

          
            Console.WriteLine("sum: " + sum);
        }

        private static void readInputAndSortInOddEven()
        {
            Console.WriteLine("type input separate with comma as 2,3,4,5....  , text will be ignored");
            String str = Console.ReadLine();
            string[] split = str.Split(",");

            string even = "";
            string odd = "";

            for (int i = 0; i < split.Length; i++)
            {


                try
                {
                    int result = Int32.Parse(split[i]);

                    if ((result % 2) == 1)
                    {
                        odd += " " + result;
                    }
                    else {
                        even += " " + result;
                    }

                }
                catch (FormatException)
                {
                    //ignore
                }

            }

            Console.WriteLine("even: "+even);
            Console.WriteLine("odd: " + odd);


        }

        private static void take2inputsWriteNumbersInBetween()
        {
            Console.WriteLine("type two values, the function will return [start [values...] stop] , where start<stop and values can be empty if start==stop");

            Console.WriteLine("Please type first inputvalue:");
            int k = readInteger();

            Console.WriteLine("Please type second inputvalue:");
            int f = readInteger(); 

            if (k > f) { // gör om så k alltid är mindre än f
                int h = f;
                f = k;
                k = h;
            } // nu är k<f om jag snurrat rätt

            int diff = f - k;

            string str = "" + k;
            for(int i = 1; i < diff; i++) { 
                str+= " "+(k+i);
            }
            str += " " + f;

            Console.WriteLine(str); // skriver ut [start [mellan..] stop] värden


        }

        private static void testIndataAsPalindrome()
        {
            Console.WriteLine("please type what you want to test as palidrome:");

            string str = Console.ReadLine();
            str = str.ToLower();

            int d = str.Length / 2; // halva längden på strängen, heltalsdivision hoppas jag, annars kolla upp, vilket gör att ojämna ord testas bara kanerna, och inte mittenbokstaven. Den behöver inte testas mot sig själv heller

            Boolean isPalindrome = true;

            for (int i = 0; ((i < d)  && isPalindrome ); i++) {
                char c = str[i];
                char f = str[str.Length - (1+i)];
                if (c != f) {
                    isPalindrome = false;
                }
            }

            Console.WriteLine( "the case that "+str + "  is a palindrome has boolean value of: " +isPalindrome);

        }

        private static void printRandomListAndSortedList()
        {
            int[] list = new Int32[10]; // det här är jag osäker på men misstänker att Int i java är samma som Int32 i c# och att man i C har större kontroll över hur mycket minne som varje int skall ta och hunr mänga som finns. Kan säkert ha unsigned med
            int[] sortedlist = new Int32[10]; // jo man kan skriva ut osorterad, sortera och sen skriva ut, men nu vill jag använda mer minne

            Random rnd = new Random();

            for (int i = 0; i < 10; i++) { // finns säkert någon foreach men gillar inte det för jag har ingen kontroll känns det som
                
                int secretNumber = rnd.Next(1, 100);

                list[i] = secretNumber;
                sortedlist[i] = secretNumber;
            }
            Array.Sort(sortedlist);

            String str = "";
            String str2 = "";
            for (int i = 0; i < 10; i++) {
                str += " " + list[i];
                str2 += " " + sortedlist[i];
            }


            Console.WriteLine(str);
            Console.WriteLine(str2);

        }

        private static void printMultiplikationTable()
        {
            for (int i = 0; i < 10; i++) {
                String str = "";
                for (int j = 0; j < 10; j++)
                {
                    str = str + i * j + "\t"; // blir en extra tab på slutet men kan ta bort på olika sätt. tänker inte göra
                }
                Console.WriteLine(str);
            }

            
        }

        private static void readNumberProcessSQRT_POW2_POW10()
        {
            Console.WriteLine("please type number as int, I will give you sqrt, pow2 ,pow10 of given number");
            int number= readInteger();
            Console.WriteLine(" number: "+number +" sqrt" +Math.Sqrt(number) +" pow2 " + Math.Pow(number, 2)+" pow10 " + Math.Pow(number, 10));
        }

        private static void readFileWriteToConsole()
        {
            string readText = File.ReadAllText("tempText.txt");
            Console.WriteLine(readText);
        }

        private static void readInputWriteToFile()
        {
            Console.WriteLine("please type text to write to file now:");
            String str = Console.ReadLine();

            System.IO.File.WriteAllText("tempText.txt", str);
        }

        private static void guessingGame()
        {
            Random rnd = new Random();
            int secretNumber = rnd.Next(1, 100);
            

            Boolean rightGuess = false;
            int tries = 0;
            while (!rightGuess) {
                Console.WriteLine("Guess a number between 1 and 100");
                Console.WriteLine("please type your guess: ");
                int guess = readInteger();
                tries++;
                if (guess == secretNumber) {
                    Console.WriteLine(" You guessed correct . Number of tries: " + tries);
                    return;
                } else if (guess<secretNumber) {
                    Console.WriteLine("your guess is lower than my secret number");
                }
                else if (guess > secretNumber)
                {
                    Console.WriteLine("your guess is higher than my secret number");
                }
            }

            return;
        }

        static int readInteger() {
            Boolean temp = true;
            while (temp)
            {
                try
                {
                    int result = Int32.Parse(Console.ReadLine());
                    
                    return result;
                }
                catch (FormatException)
                {
                    Console.WriteLine("please type a integer");
                }
            }
            return 0; // will never happen but makes compiler happy
        }

        static void read2ValuesEchoLargest()
        {
            Console.WriteLine("please type first value ");
            int first = readInteger();

            Console.WriteLine("please type second value ");
            int second = readInteger();

            if (first < second) {
                Console.WriteLine(second +" is larger than "+ first);
                return;
            }
            Console.WriteLine(first + " is larger than " + second);
        }

   

        static void printHelloWorld()
        {
            Console.WriteLine("Hello World!");
        }

        private static void readNameSurNameAgeEcho()
        {
            Console.WriteLine("Please type a name: ");
            String name = Console.ReadLine();


            Console.WriteLine("Please type a surname: ");
            String surname = Console.ReadLine();


            Console.WriteLine("Please type an age: ");
            String age = Console.ReadLine();

            Console.WriteLine("you typed: "+name+" " +surname+" "+age);
        }

        private static void printColors() {

            // copy paste from https://www.c-sharpcorner.com/article/change-console-foreground-and-background-color-in-c-sharp/

            // will not save state in this solution to the assignement as my java code does, just showing I know how to google


            // Let's go through all Console colors and set them as foreground  
            foreach (ConsoleColor color in Enum.GetValues(typeof(ConsoleColor)))
            {
                Console.ForegroundColor = color;
               
                Console.WriteLine( "Foreground color set to {color}");
            }
            Console.WriteLine("=====================================");
            Console.ForegroundColor = ConsoleColor.White;
            // Let's go through all Console colors and set them as background  
            foreach (ConsoleColor color in Enum.GetValues(typeof(ConsoleColor)))
            {
                Console.BackgroundColor = color;
                Console.WriteLine( "Background color set to {color}");
            }
            Console.WriteLine("=====================================");
            // Restore original colors  
            Console.ResetColor();
            
        }
    }
}

