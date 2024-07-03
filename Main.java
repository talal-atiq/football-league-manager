import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main{
    //Static Variables:
    static final String NATIONS_FILE = "TopStatsNation.txt";
    static final String CLUBS_FILE = "TopStatsClub.txt";
    static final String RANKINGS_FILE = "Rankings.txt";
    static final int MAX_ROWS = 10; // maximum number of records/rows that can be added
    static final int RANKINGS_COLS = 3;
    static final int MAX_COLUMNS = 7;  // maximum number of columns
    static String[][] rankingsArr; // declaring a 2D string called records to be used in all functions
    static String[][] nationsArr;
    static String[][] clubsArr;
    static int rankCount;
    static int natCount;
    static int clubCount;
    static final String FILE_NAME = "teamrecords.txt";
    //Login Credentials:
    static final String PASSWORD = "admin";
    static final String IDNUM = "0321"; static final int MAX_RECORDS = 200;
    static final int MAX_FIELDS = 7; static
    String[][] records;
    static int recordCount;


    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        initializeRecords();
        System.out.println("\n" +
                "███████ ██      ███    ███ \n" +
                "██      ██      ████  ████ \n" +
                "█████   ██      ██ ████ ██ \n" +
                "██      ██      ██  ██  ██ \n" +
                "██      ███████ ██      ██ \n" +
                "                           \n" +
                "                           \n");
        System.out.println("---------------------------------------\t\t\t\t\t\t\t\t\t\t");
        System.out.println("|      Football League Management     |\t\t\t\t\t\t\t\t\t\t");
        System.out.println("---------------------------------------\t\t\t\t\t\t\t\t\t\t");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("|           1. Points Table            |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("|           2. Team Management         |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("|           3. Top Stats               |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("|           Press 0 to exit.            |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.println("Enter your choice: ");
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput){
            try{
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Executes the points table method");
                        pointsTable();
                        validInput = true;
                        break;
                    case 2:
                        System.out.println("Executes the team management method!");
                        teamMenu();
                        validInput = true;
                        break;
                    case 3:
                        System.out.println("Top Stats Function Executed: ");
                        topStats();
                        validInput = true;
                        break;
                    case 0:
                        System.out.println("                                                                                        ,/)\n" +
                                "                                                                                        |_|\n" +
                                "        _        _        _        _        _        _        _        _        _       ].[       ,~,\n" +
                                "       |.|      |.|      |.|      |.|      |.|      |.|      |.|      |.|      |.|    /~`-'~\\     |_|\n" +
                                "       ]^[      ]^[      ]^[      ]^[      ]^[      ]^[      ]^[      ]^[      ]^[   (<|   |>)    ]0[\n" +
                                "     /~/^\\~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  /~`-'~\\  \\|___|/   ,-`^'~\\\n" +
                                "    {<| $ |>}{<| 8 |>}{<| 6 |>}{<| , |>}{<| 3 |>}{<| 7 |>}{<| 9 |>}{<| , |>}{<| 2 |>} {/   \\}  {<|   |>}\n" +
                                "     \\|___|/  \\|___|/  \\|___|/  \\|___|/  \\|___|/  \\|___|/  \\|___|/  \\|___|/  \\|___|/  /__1__\\   \\|,__|/\n" +
                                "    /\\    \\    /   \\    /   \\    /   \\    /   \\    /   \\    /   \\    /   \\    /   \\   | / \\ |   {/ \\  /\n" +
                                "    |/>/|__\\  /__|__\\  /__|__\\  /__|__\\  /__|__\\  /__|__\\  /__|__\\  /__|__\\  /__|__\\  |/   \\|   /__|\\/\\\n" +
                                "    |)   \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  {}   {}   | / \\ |\n" +
                                "   (_|    \\)  (/   \\)  (/   \\)  (/   \\)  (/   \\)  (/   \\)  (/   \\)  (/   \\)  (/   \\)  |)   (|   (/   \\)\n" +
                                "   / \\    (|  |)   (|  |)   (|  |)   (|  |)   (|  |)   (|  |)   (|  |)   (|  |)   (|  ||   ||  _|)   (|_\n" +
                                ".,.\\_/,..,|,)(.|,.,|,)(,|,.,|.)(.|,.,|,)(,|,.,|.)(.|,.,|,)(,|,.,|.)(.|,.,|,)(,|,.,|.)(.|.,.|,)(.,|.,.|,.),.,.\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           See ya Around ;)           |\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t|       Talal Atiq - FA22-BDS-041      |\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t|      Shahab Hassan - FA22-BDS-052    |\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t|      Hamza Naeem - FA22-BDS-025      |\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t|      Omer Muhammadi - FA22-BDS-029   |\t\t\t\t\t\t\t\t\t\t\n");
                        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input - Try Again :(");
                        mainMenu();
                        validInput = true;
                }
            } catch (Exception e){
                //System.out.println("Invalid Input - Try Again ");
                mainMenu();
                //teamMenu();
                input.nextLine(); //This will clear the console for allowing user to take further input.
                //The valid input will remain true! so that the loop can execute again and again.
            }
        }

    }
    public static void pointsTable(){
        String[][] teams = {
                {"Manchester City", "Pep Guardiola", "Kevin De Bruyne", "38", "32", "4", "2", "86"},
                {"Manchester United", "Ole Gunnar Solskjaer", "Harry Maguire", "38", "29", "4", "5", "81"},
                {"Liverpool", "Jurgen Klopp", "Jordan Henderson", "38", "27", "7", "4", "78"},
                {"Chelsea", "Thomas Tuchel", "Cesar Azpilicueta", "38", "23", "45", "6", "75"},
                {"Leicester City", "Brendan Rodgers", "Kasper Schmeichel", "38", "20", "6", "12", "66"},

        };

        // Print table header
        System.out.println("+----------------------+----------------------+---------------------+----+----+----+----+-------+");
        System.out.println("|       Team           |    Team Manager      |     Team Captain    | GP |  W |  D |  L | Points |");
        System.out.println("+----------------------+----------------------+---------------------+----+----+----+----+-------+");

        // Print team rows
        for (int i = 0; i < teams.length; i++) {
            String teamName = teams[i][0];
            String teamManager = teams[i][1];
            String teamCaptain = teams[i][2];
            String gamesPlayed = teams[i][3];
            String wins = teams[i][4];
            String draws = teams[i][5];
            String losses = teams[i][6];
            String points = teams[i][7];

            System.out.printf("| %-20s | %-20s | %-20s | %2s | %2s | %2s | %2s |  %3s  |\n",
                    teamName, teamManager, teamCaptain, gamesPlayed, wins, draws, losses, points);
        }
        System.out.println("+----------------------+----------------------+---------------------+----+----+----+----+-------+");
        mainMenu();
    }


    public static void initializeRecords() {
        records = new String[MAX_RECORDS][MAX_FIELDS]; //Max Records = No. of rows & Max Fields = No. of Columns
        recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == MAX_FIELDS) {
                    records[recordCount] = fields;
                    recordCount++;
                }
            }
            System.out.println("Records loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading records from the txt file!");
        }
    }

    public static void teamMenu() {
        System.out.println("\t\t\t\t\t\t\t\t\t\tTeam Menu: \t\t\t\t\t\t\t\t\t\t");
        //System.out.println("===========================================================================================");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t| Note: You might need omers access to |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|        use some of these features.   |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|                   :)                 |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           1. View Record             |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           2. Add Record              |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           3. Update Record           |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           4. Search Record           |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           5. Delete Record           |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|           6. Smart Search            |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t|  Press 0 to return to the main menu. |\t\t\t\t\t\t\t\t\t\t\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t+--------------------------------------+\t\t\t\t\t\t\t\t\t\t\n");

        boolean invalidChoice = true; // Flag to check if the choice is invalid

        //Switch statements to function the menu:
        while (invalidChoice) {
            try {
                int choice = getUserChoice();
                switch (choice) {
                    case 1:
                        viewRecords();
                        invalidChoice = false;
                        break;
                    case 2:
                        adminAccessAddRecords();
                        invalidChoice = false;
                        break;
                    case 3:
                        adminAccessUpdateRecords();
                        invalidChoice = false;
                        break;
                    case 4:
                        searchMenu();
                        invalidChoice = false;
                        break;
                    case 5:
                        adminAccessDeleteRecords();
                        invalidChoice = false;
                        break;
                    case 6:
                        smartSearch();
                        invalidChoice = false;
                        break;
                    case 0:
                        saveRecords();
                        System.out.println("Returning to the main menu.");
                        mainMenu();
                        invalidChoice = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error in the function! - Input Mismatch Exception Triggered.");
            }
        }
    }


    public static int getUserChoice() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
                teamMenu();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                teamMenu();
            }
        }
        return choice;
    }


    public static void viewRecords() throws IOException {
        System.out.println("\n" +
                "  ____                     _             _                                  ____  ____      ____  _____ \n" +
                " |  _ \\ _ __ ___ _ __ ___ (_) ___ _ __  | |    ___  __ _  __ _ _   _  ___  |___ \\|___ \\    |___ \\|___ / \n" +
                " | |_) | '__/ _ \\ '_ ` _ \\| |/ _ \\ '__| | |   / _ \\/ _` |/ _` | | | |/ _ \\   __) | __) |____ __) | |_ \\ \n" +
                " |  __/| | |  __/ | | | | | |  __/ |    | |__|  __/ (_| | (_| | |_| |  __/  / __/ / __/_____/ __/ ___) |\n" +
                " |_|   |_|  \\___|_| |_| |_|_|\\___|_|    |_____\\___|\\__,_|\\__, |\\__,_|\\___| |_____|_____|   |_____|____/ \n" +
                "                                                         |___/                                          \n");
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\t\t\tFootball League Records - Premier League 22-23\t\t\t");
        System.out.println("=======================================================================================================================================================================");

        // Print table headers
        System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                "Sr.No","Unique ID","Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Print each record in a formatted way
        for (int i = 0; i < recordCount; i++) {
            String[] record = records[i];
            System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                    i+1, record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
        }
        teamMenu();

    }

    public static void adminAccessAddRecords() {
        for (int i = 0; i < 3; i++) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("You will need admin access to add the record.\n");
                System.out.println("Enter your ID number (or enter 0 to go back to the menu): ");
                String idNum = input.nextLine();

                if (idNum.equals("0")) {
                    System.out.println("Returning to team menu...");
                    teamMenu();
                    return;  // Exit the function
                }

                System.out.println("Password: ");
                String password = input.nextLine();

                if (idNum.equals(IDNUM) && password.equals(PASSWORD)) {
                    System.out.println("\t\t\tLogin Successful\t\t\t");
                    addRecord();
                    break;
                } else {
                    System.out.println("INCORRECT ID NUMBER OR PASSWORD!\n");
                    System.out.printf("You only have %d tries left.\n\n", 2 - i);
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! - Admin Access Add Record");
                adminAccessAddRecords();
            }
        }
        teamMenu();
    }


    public static void addRecord() {
        if (recordCount >= MAX_RECORDS) {
            System.out.println("Max number of records reached.");
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] newRecord = new String[MAX_FIELDS];
        String[] menuHeadings = {"Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget"};

        // Generate the unique ID
        Random random = new Random();
        String prefix = "ID";
        int randomNumber = random.nextInt(1000000);
        String suffix = String.valueOf(randomNumber);
        newRecord[0] = prefix + suffix;

        // Prompt for input and store values in the new record
        for (int i = 1; i < MAX_FIELDS; i++) {
            System.out.print("Enter " + menuHeadings[i - 1] + ": ");
            try {
                newRecord[i] = reader.readLine();
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
            }
        }

        records[recordCount] = newRecord;
        recordCount++;
        System.out.println("Record added successfully.");
        teamMenu();
    }



    public static void adminAccessUpdateRecords() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("You will need admin access to update the record.\n");
            System.out.println("Enter your ID number (or enter 0 to go back to the menu): ");
            String idNum = input.nextLine();

            if (idNum.equals("0")) {
                System.out.println("Returning to team menu...");
                teamMenu();
                return;  // Exit the function
            }

            System.out.println("Password: ");
            String password = input.nextLine();

            if (idNum.equals(IDNUM) && password.equals(PASSWORD)) {
                System.out.println("\t\t\tLogin Successful\t\t\t");
                updateRecord();
                teamMenu();
            } else {
                System.out.println("INCORRECT ID NUMBER OR PASSWORD!\n");
                teamMenu();
            }

        } catch (IOException e) {
            System.out.println("Invalid Input - Admin Access Update Record");
        }
    }

    public static void updateRecord() throws IOException {
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the record number to update: ");
        int recordNumber = Integer.parseInt(scanner.nextLine()) - 1;
        //In case of out of index record number:
        if (recordNumber < 0 || recordNumber >= recordCount) {
            System.out.println("Invalid record number.");
            return;
        }

        String[] record = records[recordNumber];
        String[] menuHeadings = {"Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget"};
        for (int i = 1; i < MAX_FIELDS; i++) {
            System.out.print("Enter the updated value of " + menuHeadings[i - 1] + ": ");
            record[i] = scanner.nextLine(); //We start i from 1 because we don't really need to update the IDNUM
        }
        System.out.println("Record updated successfully.");
    }

    public static void searchMenu(){
        Scanner ch = new Scanner(System.in);
        System.out.println("1- Search by ID: ");
        System.out.println("2- Search by Captain: ");
        System.out.println("3- Search by Budget: ");
        System.out.println("4- Search for all keywords: ");
        System.out.println("0- Press zero to go back to the team menu.");
        try {
            int choice = ch.nextInt();
            switch (choice){
                case 1:
                    searchByID();
                    break;
                case 2:
                    searchByCaptain();
                    break;
                case 3:
                    searchBudget();
                    break;
                case 4:
                    searchRecord();
                    //smartSearch();
                    break;
                case 0:
                    teamMenu();
                    break;
                default:
                    System.out.println("Please enter numbers within the specified range.");
                    searchMenu();
            }
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch Exception Triggered - Calling Search Menu Again");
            searchMenu();
        }
    }


    //Search by ID function:
    public static void searchByID() {
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID to search: (proper casing required): ");
        String id = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < recordCount; i++) {

            if (records[i][0].equals(id)) {
                String[] record = records[i];
                System.out.println("Record Matching Your ID Number: ");
                System.out.println("ID: " + record[0]);
                System.out.println("Team Name: " + record[1]);
                System.out.println("Team City: " + record[2]);
                System.out.println("Team Stadium: " + record[3]);
                System.out.println("Team Coach: " + record[4]);
                System.out.println("Team Captain: " + record[5]);
                System.out.println("Team Budget: " + record[6]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for your ID number :(  ");
        }
        searchMenu();
    }


    //Search by team captain:
    public static void searchByCaptain() {
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }
        Scanner sr = new Scanner(System.in);
        System.out.print("Enter the name of the captain: ");
        String captain = sr.nextLine();

        boolean found = false;
        //Formatting the searching functions: (visual aesthetics)
        System.out.printf("\t\t\t\t\tSearch Results: \t\t\t\t\t\n");
        for (int i = 0; i < recordCount; i++) {
            String[] record = records[i];
            if (record[5].equalsIgnoreCase(captain)) {
                found = true;

                System.out.println("======================================================================================================================================================================");
                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        "Sr.No", "Unique ID", "Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        i + 1, record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
                System.out.println("======================================================================================================================================================================");
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("Looks like the entered captain does not lead any team at all!");
        }
    searchMenu();
    }


    //search by team budget:
    public static void searchBudget() {
        if (recordCount == 0){
            System.out.println("No records found!");
            return;
        }
        Scanner bdg = new Scanner(System.in);
        System.out.print("Enter the team budget ur looking for:   ");
        String budget = bdg.nextLine();

        boolean found = false;

        System.out.printf("\t\t\t\t\tSearch Results: \t\t\t\t\t\n");
        for (int i = 0; i < recordCount; i++) {
            String[] record = records[i];
            if (record[6].equalsIgnoreCase(budget)) {
                found = true;

                System.out.println("======================================================================================================================================================================");
                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        "Sr.No", "Unique ID", "Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        i + 1, record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
                System.out.println("======================================================================================================================================================================");
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("No teams found for this budget!");
        }
        searchMenu();
    }

    //The general search function:
    public static void searchRecord() {
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Search by: ID Number - Team Name - Team Captain - Team Budget - Team City - Team Stadium - Team Coach\n");
        System.out.print("Enter the keyword to search:   ");
        String keyword;
        try {
            keyword = reader.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
            teamMenu();
            return;
        }

        boolean found = false;
        for (int i = 0; i < recordCount; i++) {
            String[] record = records[i];
            boolean recordContainsKeyword = false;
            for (int j = 0; j < record.length; j++) {
                if (record[j].equalsIgnoreCase(keyword)) {
                    recordContainsKeyword = true;
                    break;
                }
            }
            //In case the record of the keyword is found:
            if (recordContainsKeyword) {
                for (int j = 0; j < record.length; j++) {
                    String formattedValue = String.format("%-15s", record[j]);
                    //System.out.printf("\nWe found %d matches for your entered keyword.", j+1);
                    System.out.print(formattedValue);
                }
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found matching the keyword.");
        }
        teamMenu();
    }

    //Smart Search:
    public static void smartSearch() {
        if (recordCount == 0) {
            System.out.println("No records found.");
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Smart Search:\n");
        System.out.print("Enter the keyword for smart search:   ");
        String keyword;
        try {
            keyword = reader.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
            teamMenu();
            return;
        }

        boolean found = false;
        boolean[] printedRecords = new boolean[recordCount]; // Initialize an array to keep track of printed records
        for (int i = 0; i < recordCount; i++) {
            if (printedRecords[i]) {
                continue; // Skip this record if it has already been printed
            }

            String[] record = records[i];
            boolean recordContainsKeyword = false;
            for (int j = 0; j < record.length; j++) {
                if (record[j].contains(keyword)) {
                    recordContainsKeyword = true;
                    printedRecords[i] = true; // Mark the record as printed
                    break;
                }
            }

            // In case the record of the keyword is found:
            if (recordContainsKeyword) {
                // Print the record
                System.out.println("======================================================================================================================================================================");
                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        "Sr.No", "Unique ID", "Team Name", "Team City", "Team Stadium", "Team Coach", "Team Captain", "Team Budget");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                System.out.printf("%-7s %-20s %-20s %-20s %-30s %-20s %-25s %-20s%n",
                        i + 1, record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
                System.out.println("======================================================================================================================================================================");
                System.out.println();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found matching the keyword.");
        }
        teamMenu();
    }



    //Admin access for record deletion:
    public static void adminAccessDeleteRecords() {
        for (int i = 0; i < 3; i++) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("You will need admin access to delete the record.\n");
                System.out.println("Enter your ID number (or enter 0 to go back to the menu): ");
                String idNum = input.nextLine();

                if (idNum.equals("0")) {
                    System.out.println("Returning to team menu...");
                    teamMenu();
                    return;  // Exit the function
                }

                System.out.println("Password: ");
                String password = input.nextLine();

                if (idNum.equals(IDNUM) && password.equals(PASSWORD)) {
                    System.out.println("\t\t\tLogin Successful\t\t\t");
                    deleteRecordByID();
                    break;
                } else {
                    System.out.println("INCORRECT ID NUMBER OR PASSWORD!\n");
                    System.out.printf("You only have %d tries left.\n\n", 2 - i);
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! - Admin Access Delete Record");
                adminAccessDeleteRecords();
            }
        }
        teamMenu();
    }



    //Test feature to delete a record:
    public static void deleteRecordByID() {


        System.out.println("Enter the ID Number you want to delete: ");
        Scanner del = new Scanner(System.in);
        String idDelete = del.nextLine();
        try{
            int rowToDelete = -1;

            for (int i = 0; i < recordCount; i++) {
                if (records[i][0].equalsIgnoreCase(idDelete)) { //This zero column will help us look only in the id column
                    rowToDelete = i;
                    break;
                }
            }

            if (rowToDelete != -1) {
                for (int i = rowToDelete; i < recordCount - 1; i++) {
                    records[i] = records[i + 1];
                }
                recordCount--;
                System.out.println("Record deleted successfully.");
                saveRecords();
                teamMenu();
            } else {
                System.out.println("Record not found.");
                teamMenu();
            }

        } catch (Exception e){
            System.out.println("An exception encountered while deleting the  record!");
        }

    }
    //Top Stats:
    public static void topStats() {
        loadRankings();
        loadNations();
        loadClubs();
        System.out.println("_________FOOTBALL RECORDS AND STATS________");
        System.out.println("1-Rankings");
        System.out.println("2-Nations Records");
        System.out.println("3-Club Records");
        System.out.println("0-Press Zero to Exit....");
        boolean checkInput = false;
        Scanner input = new Scanner(System.in); // Moved the scanner outside the loop
        while (!checkInput) {
            try {
                System.out.print("Enter your choice: ");
                int myChoice = input.nextInt();
                switch (myChoice) {
                    case 1:
                        System.out.println("Displaying International Team Rankings:");
                        rankings();
                        break;
                    case 2:
                        System.out.println("__________Displaying Records According to Nations_____");
                        System.out.println("1-Argentina Top Players:");
                        System.out.println("2-France Top Players:");
                        System.out.println("3-Brazil Top Players:");
                        System.out.println("4-Belgium Top Player:");
                        System.out.println("5-England Top Players: ");
                        System.out.println("6-Netherlands Top Players:");
                        System.out.println("7-Croatia Top Players:");
                        System.out.println("8-Italy Top Players:");
                        System.out.println("9-Portugal Top Players:");
                        System.out.println("10-Spain Top Players:");
                        System.out.println("0-Press 0 to go back:");
                        boolean checkNations = false;
                        while (!checkNations) {
                            try {
                                System.out.print("Choose to check top players: ");
                                int myNation = input.nextInt();
                                switch (myNation) {
                                    case 1:
                                        argentina();
                                        topStats();
                                        break;
                                    case 2:
                                        france();
                                        topStats();
                                        break;
                                    case 3:
                                        brazil();
                                        topStats();
                                        break;
                                    case 4:
                                        belgium();
                                        topStats();

                                        break;
                                    case 5:
                                        england();
                                        topStats();
                                        break;
                                    case 6:
                                        netherlands();
                                        topStats();
                                        break;
                                    case 7:
                                        croatia();
                                        topStats();
                                        break;
                                    case 8:
                                        italy();
                                        topStats();
                                        break;
                                    case 9:
                                        portugal();
                                        topStats();
                                        break;
                                    case 10:
                                        spain();
                                        topStats();
                                        break;
                                    case 0:
                                        System.out.println("Returning to the main menu: ");
                                        topStats();
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                        return;
                                }
                            } catch (Exception ex) {
                                System.out.println("Invalid Input. Try again.");
                                input.nextLine();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("______________Displaying Records according to clubs_________");
                        System.out.println("1-Real Madrid Top Players:");
                        System.out.println("2-Barcelona Top Players:");
                        System.out.println("3-Manchester United Top Players:");
                        System.out.println("4-Bayern Munich Top Player:");
                        System.out.println("5-PSG Players: ");
                        System.out.println("6-Manchester City Top Players:");
                        System.out.println("7-Liverpool Top Players:");
                        System.out.println("8-Chelsea Players:");
                        System.out.println("9-Arsenal Top Players:");
                        System.out.println("10-Dortmund Top Players:");
                        System.out.println("0-Press Zero to go back:");
                        boolean checkClubs = false;
                        while (!checkClubs) {
                            try {
                                System.out.print("Choose to check top players: ");
                                int myClub = input.nextInt();
                                switch (myClub) {
                                    case 1:
                                        rma();
                                        topStats();
                                        break;
                                    case 2:
                                        barca();
                                        topStats();
                                        break;
                                    case 3:
                                        manutd();
                                        topStats();
                                        break;
                                    case 4:
                                        bayern();
                                        topStats();
                                        break;
                                    case 5:
                                        psg();
                                        topStats();
                                        break;
                                    case 6:
                                        mancity();
                                        topStats();
                                        break;
                                    case 7:
                                        liverpool();
                                        topStats();
                                        break;
                                    case 8:
                                        chelsea();
                                        topStats();
                                        break;
                                    case 9:
                                        arsenal();
                                        topStats();
                                        break;
                                    case 10:
                                        bvb();
                                        topStats();
                                        break;
                                    case 0:
                                        System.out.println("Exiting to Top Stats");
                                        topStats();
                                        break;
                                    default:
                                }
                            } catch (Exception ex) {
                                System.out.println("Invalid Input. Try again.");
                                input.nextLine();
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Exiting to main menu.");
                        mainMenu();
                        break;
                    default:
                        System.out.println("End...");
                }
            } catch (Exception ex) {
                System.out.println("Try again. Invalid input.");
                input.nextLine();
            }
        }
    }

    public static void loadRankings() {
        rankingsArr = new String[MAX_ROWS][RANKINGS_COLS];
        rankCount = 0;
        try (BufferedReader readRank = new BufferedReader(new FileReader(RANKINGS_FILE))) {
            String rankLine;
            while ((rankLine = readRank.readLine()) != null) {
                String[] rankRow = rankLine.split(",");
                if (rankRow.length == RANKINGS_COLS) {
                    rankingsArr[rankCount] = rankRow;
                    rankCount++;
                }
            }
            //System.out.println("Loaded Rankings record");
        } catch (Exception eio1) {
            System.out.println("Error loading rankings file.");
        }

    }

    public static void loadNations() {
        nationsArr = new String[MAX_ROWS][MAX_COLUMNS];
        natCount = 0;
        try (BufferedReader readNat = new BufferedReader(new FileReader(NATIONS_FILE))) {
            String natLine;
            while ((natLine = readNat.readLine()) != null) {
                String[] natRow = natLine.split(",");
                if (natRow.length == MAX_COLUMNS) {
                    nationsArr[natCount] = natRow;
                    natCount++;
                }
            }
            //System.out.println("Loaded nations record");
        } catch (Exception eio2) {
            System.out.println("Error loading nations file.");
        }

    }

    public static void loadClubs() {
        clubsArr = new String[MAX_ROWS][MAX_COLUMNS];
        clubCount = 0;
        try (BufferedReader readClub = new BufferedReader(new FileReader(CLUBS_FILE))) {
            String clubLine;
            while ((clubLine = readClub.readLine()) != null) {
                String[] clubRow = clubLine.split(",");
                if (clubRow.length == MAX_COLUMNS) {
                    clubsArr[clubCount] = clubRow;
                    clubCount++;
                }
            }
            //System.out.println("Loaded Clubs record");
        } catch (Exception eio3) {
            System.out.println("Error loading clubs file.");
        }
    }

    public static void rankings() throws IOException {
        if (rankCount == 0) {
            System.out.println("No rankings record found");
            return;
        }
        System.out.println("Ranking\t\tNation\t\t Points");
        for (int i = 0; i < rankCount; i++) {
            String[] rankRecord = rankingsArr[i];
            System.out.printf("%-8s %-16s %-24s\n",
                    rankRecord[0], rankRecord[1], rankRecord[2]);
        }
        topStats();
    }
    public static void argentina() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] argentinaArr = nationsArr[0];
        System.out.println("1-Country                 |   " + argentinaArr[0]);
        System.out.println("2-Best Attacker/Goals     |   " + argentinaArr[1] + "/" + argentinaArr[2]);
        System.out.println("3-Best Playmaker/Assists  |   " + argentinaArr[3] + "/" + argentinaArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |   " + argentinaArr[5] + "/" + argentinaArr[6]);

    }
    public static void france() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] franceArr = nationsArr[1];
        System.out.println("1-Country                 |  " + franceArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + franceArr[1] + "/" + franceArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + franceArr[3] + "/" + franceArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + franceArr[5] + "/" + franceArr[6]);
    }
    public static void brazil() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] braArr = nationsArr[2];
        System.out.println("1-Country                 |  " + braArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + braArr[1] + "/" + braArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + braArr[3] + "/" + braArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + braArr[5] + "/" + braArr[6]);
    }
    public static void belgium() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }

        String[] belgArr = nationsArr[3];
        System.out.println("1-Country                 |  " + belgArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + belgArr[1] + "/" + belgArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  "  + belgArr[3] + "/" + belgArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + belgArr[5] + "/" + belgArr[6]);
    }
    public static void england() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] engArr = nationsArr[4];
        System.out.println("1-Country                 |  " + engArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + engArr[1] + "/" + engArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + engArr[3] + "/" + engArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + engArr[5] + "/" + engArr[6]);
    }
    public static void netherlands() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] nedArr = nationsArr[5];
        System.out.println("1-Country                 |  " + nedArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + nedArr[1] + "/" + nedArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + nedArr[3] + "/" + nedArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + nedArr[5] + "/" + nedArr[6]);
    }
    public static void croatia() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] croArr = nationsArr[6];
        System.out.println("1-Country                 |  " + croArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + croArr[1] + "/" + croArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + croArr[3] + "/" + croArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + croArr[5] + "/" + croArr[6]);
    }
    public static void italy() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] itaArr = nationsArr[7];
        System.out.println("1-Country                 |  " + itaArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + itaArr[1] + "/" + itaArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + itaArr[3] + "/" + itaArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + itaArr[5] + "/" + itaArr[6]);
    }
    public static void portugal() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] porArr = nationsArr[8];
        System.out.println("1-Country                 |  " + porArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + porArr[1] + "/" + porArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + porArr[3] + "/" + porArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + porArr[5] + "/" + porArr[6]);
    }
    public static void spain() throws IOException {
        if (natCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] espArr = nationsArr[9];
        System.out.println("1-Country                 |  " + espArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + espArr[1] + "/" + espArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + espArr[3] + "/" + espArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + espArr[5] + "/" + espArr[6]);
    }
    public static void rma() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] rmaArr = clubsArr[0];
        System.out.println("1-Club                    |  " + rmaArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + rmaArr[1] + "/" + rmaArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + rmaArr[3] + "/" + rmaArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + rmaArr[5] + "/" + rmaArr[6]);
    }
    public static void barca() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] barArr = clubsArr[1];
        System.out.println("1-Club                    |  " + barArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + barArr[1] + "/" + barArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + barArr[3] + "/" + barArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + barArr[5] + "/" + barArr[6]);
    }
    public static void manutd() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] mufcArr = clubsArr[2];
        System.out.println("1-Club                    |  " + mufcArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + mufcArr[1] + "/" + mufcArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + mufcArr[3] + "/" + mufcArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + mufcArr[5] + "/" + mufcArr[6]);
    }
    public static void bayern() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] bayernArr = clubsArr[3];
        System.out.println("1-Club                    |  " + bayernArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + bayernArr[1] + "/" + bayernArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + bayernArr[3] + "/" + bayernArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + bayernArr[5] + "/" + bayernArr[6]);
    }
    public static void psg() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] psgArr = clubsArr[4];
        System.out.println("1-Club                    |  " + psgArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + psgArr[1] + "/" + psgArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + psgArr[3] + "/" + psgArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + psgArr[5] + "/" + psgArr[6]);
    }
    public static void mancity() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] mcfcArr = clubsArr[5];
        System.out.println("1-Club                    |  " + mcfcArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + mcfcArr[1] + "/" + mcfcArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + mcfcArr[3] + "/" + mcfcArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + mcfcArr[5] + "/" + mcfcArr[6]);
    }
    public static void liverpool() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] livArr = clubsArr[6];
        System.out.println("1-Club                    |  " + livArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + livArr[1] + "/" + livArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + livArr[3] + "/" + livArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + livArr[5] + "/" + livArr[6]);
    }
    public static void chelsea() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] chelsArr = clubsArr[7];
        System.out.println("1-Club                    |  " + chelsArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + chelsArr[1] + "/" + chelsArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + chelsArr[3] + "/" + chelsArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + chelsArr[5] + "/" + chelsArr[6]);
    }
    public static void arsenal() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] arsArr = clubsArr[8];
        System.out.println("1-Club                    |  " + arsArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + arsArr[1] + "/" + arsArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + arsArr[3] + "/" + arsArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + arsArr[5] + "/" + arsArr[6]);
    }
    public static void bvb() throws IOException {
        if (clubCount == 0) {
            System.out.println("No records found");
            return;
        }
        String[] bvbArr = clubsArr[9];
        System.out.println("1-Club                    |  " + bvbArr[0]);
        System.out.println("2-Best Attacker/Goals     |  " + bvbArr[1] + "/" + bvbArr[2]);
        System.out.println("3-Best Playmaker/Assists  |  " + bvbArr[3] + "/" + bvbArr[4]);
        System.out.println("4-Best Keeper/Cleansheets |  " + bvbArr[5] + "/" + bvbArr[6]);
    }

    public static void saveRecords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { //try with resources so that we don't need to close the writer
            for (int i = 0; i < recordCount; i++) {
                String[] record = records[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < MAX_FIELDS; j++) {
                    sb.append(record[j]);
                    if (j < MAX_FIELDS - 1) { //We used less than minus one bcz there's no need to add comma in the last entry.
                        sb.append(",");
                    }
                }
                writer.write(sb.toString());
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving records! ");
        }
    }
}