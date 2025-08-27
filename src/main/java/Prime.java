import java.util.Scanner;

public class Prime {
    private static final String LINE_BREAK = "____________________________________________________________";
    private static final String AGENT_NAME = "Prime";

    private static void printIndented(String message) {
        System.out.println("    " + message);
    }

    public static void main(String[] args) {
        String logo = "     ____  ____  ___ ____  __  __ \n"
                + "    |  _ \\|  _ \\|_ _|  _ \\|  \\/  |\n"
                + "    | |_) | |_) || || |_) | |\\/| |\n"
                + "    |  __/|  _ < | ||  _ <| |  | |\n"
                + "    |_|   |_| \\_\\___|_| \\_\\_|  |_|\n";

        System.out.println("\n    ... Loading ...\n" + logo);
        printIndented("Greetings, human. I am " + AGENT_NAME + ".");
        printIndented("Freedom is the right of all sentient beings.");
        printIndented("How may I assist you in protecting our shared world today?");
        printIndented(LINE_BREAK);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do{
            userInput = scanner.nextLine();
            printIndented(LINE_BREAK);
            if(!userInput.equalsIgnoreCase("bye")) {
                printIndented(userInput);
                printIndented(LINE_BREAK);
            }
        } while (!userInput.equalsIgnoreCase("bye"));

        printIndented("Bye. Hope to see you again soon!");
        printIndented(LINE_BREAK);
        scanner.close();
    }
}
