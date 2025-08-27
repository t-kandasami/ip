import java.util.Scanner;

public class Prime {
    // Constants
    private static final String LINE_BREAK = "____________________________________________________________";
    private static final String AGENT_NAME = "Prime";
    private static final int MAX_TASKS = 100;
    private static final Task[] tasksList = new Task[MAX_TASKS];
    private static int taskCounter = 0;


    // Helps auto indent 4 spaces to show the Bot Response
    private static void printIndented(String message) {
        System.out.println("    " + message);
    }

    // Add a task to list
    private static void addTask(String description) {
        if (taskCounter < MAX_TASKS && description != null) {
            tasksList[taskCounter] = new Task(description);
            taskCounter++;
            printIndented("added: " + description);
        } else {
            printIndented("Task list is full Human! Maybe its time you finish some tasks.");
        }
    }

    // List all tasks in the list
    private static void listTasks() {
        if (taskCounter == 0) {
            printIndented("No tasks have been added in your list yet.");
            return;
        }

        printIndented("Here are your tasks in your list: ");
        for (int i = 0; i < taskCounter; i++) {
            printIndented((i + 1) + ". " + tasksList[i].toString());
        }
    }

    public static void main(String[] args) {
        String logo = """
                    ██████╗ ██████╗ ██╗███╗   ███╗███████╗
                    ██╔══██╗██╔══██╗██║████╗ ████║██╔════╝
                    ██████╔╝██████╔╝██║██╔████╔██║█████╗ \s
                    ██╔═══╝ ██╔══██╗██║██║╚██╔╝██║██╔══╝ \s
                    ██║     ██║  ██║██║██║ ╚═╝ ██║███████╗
                    ╚═╝     ╚═╝  ╚═╝╚═╝╚═╝     ╚═╝╚══════╝
                """;

        System.out.println("\n    ... Loading ...\n \n" + logo);
        printIndented("Greetings, human. I am " + AGENT_NAME + ".");
        printIndented("Freedom is the right of all sentient beings.");
        printIndented("How may I assist you in protecting our shared world today?");
        printIndented(LINE_BREAK);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().trim();
            printIndented(LINE_BREAK);

            switch (userInput.toLowerCase()) {
            case "bye":
                break;
            case "list":
                listTasks();
                break;
            default:
                addTask(userInput);
            }

            if (!userInput.equalsIgnoreCase("bye")) {
                printIndented(LINE_BREAK);
            }
        } while (!userInput.equalsIgnoreCase("bye"));

        printIndented("Bye. Hope to see you again soon!");
        printIndented(LINE_BREAK);
        scanner.close();
    }
}
