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

    private static void addDeadline(String description, String by) {
        if (taskCounter < MAX_TASKS && description != null && by != null) {
            tasksList[taskCounter] = new Deadline(description, by);
            printIndented("Got it. I've added this task:");
            printIndented(tasksList[taskCounter].toString());
            taskCounter++;
            printIndented("Now you have " + taskCounter + " tasks in your task list.");
        } else {
            printIndented("Task list is full Human! Maybe its time you finish some tasks.");
        }
    }

    private static void addEvent(String description, String from, String to) {
        if (taskCounter < MAX_TASKS && description != null && from != null && to != null) {
            tasksList[taskCounter] = new Event(description, from, to);
            printIndented("Got it. I've added this task:");
            printIndented(tasksList[taskCounter].toString());
            taskCounter++;
            printIndented("Now you have " + taskCounter + " tasks in your task list.");
        } else {
            printIndented("Task list is full Human! Maybe its time you finish some tasks.");
        }
    }

    private static void addToDo(String description) {
        if (taskCounter < MAX_TASKS && description != null) {
            tasksList[taskCounter] = new ToDo(description);
            printIndented("Got it. I've added this task:");
            printIndented(tasksList[taskCounter].toString());
            taskCounter++;
            printIndented("Now you have " + taskCounter + " tasks in your task list.");
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
        printIndented("Here are your tasks in your list:");
        for (int i = 0; i < taskCounter; i++) {
            printIndented((i + 1) + "." + tasksList[i].toString());
        }
    }

    private static void toggleMarkTask(int taskNo) {
        if (taskNo >= 1 && taskNo <= taskCounter) {
            if (tasksList[taskNo - 1].getIsDone()) {
                tasksList[taskNo - 1].setIsDone(false);
                printIndented("Ok Human! I've marked this task as not done yet:");
            } else {
                tasksList[taskNo - 1].setIsDone(true);
                printIndented("Nice Human! I've marked this task as done:");
            }
            printIndented(tasksList[taskNo - 1].toString());
        } else {
            printIndented("Invalid task number! Please try again.");
            printIndented("You are allowed to enter a number between 1 and " + taskCounter);
        }
    }

    private static String parseTodoDescription(String command) {
        return command.substring("todo".length()).trim();
    }

    private static String parseDeadlineDescription(String command) {
        int indexOfBy = command.indexOf("/by");
        return command.substring("deadline".length(), indexOfBy).trim();
    }

    private static String parseEventDescription(String command) {
        int indexOfFrom = command.indexOf("/from");
        return command.substring("event".length(), indexOfFrom).trim();
    }

    private static int parseTaskNumber(String command, String prefix) {
        return Integer.parseInt(command.substring(prefix.length()).trim());
    }

    private static String parseBy(String command) {
        int indexOfBy = command.indexOf("/by");
        return command.substring(indexOfBy + "/by".length()).trim();
    }

    private static String parseFrom(String command) {
        int indexOfFrom = command.indexOf("/from");
        int indexOfTo = command.indexOf("/to");
        return command.substring(indexOfFrom + "/from".length(), indexOfTo).trim();
    }

    private static String parseTo(String command) {
        int indexOfTo = command.indexOf("/to");
        return command.substring(indexOfTo + "/to".length()).trim();
    }

    public static void main(String[] args) {

        // Due to some encoding issue there is an issue with comparing PRIME Logo with EXPECTED.TXT
        // System.out.println("\n    ... Loading ...\n \n" + logo);
        //System.out.println("\n    ... Loading ...\n \n");
        printIndented("Greetings, human. I am " + AGENT_NAME + ".");
        printIndented("Freedom is the right of all sentient beings.");
        printIndented("How may I assist you in protecting our shared world today?");
        printIndented(LINE_BREAK);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().trim().toLowerCase();
            printIndented(LINE_BREAK);

            if (userInput.startsWith("mark ")) {
                int taskNumber = parseTaskNumber(userInput, "mark");
                if (taskNumber > 0) {
                    toggleMarkTask(taskNumber);
                } else {
                    printIndented("Invalid format! Use: mark [taskNumber]");
                }
            } else if (userInput.startsWith("unmark ")) {
                int taskNumber = parseTaskNumber(userInput, "unmark");
                if (taskNumber > 0) {
                    toggleMarkTask(taskNumber);
                } else {
                    printIndented("Invalid format! Use: unmark [taskNumber]");
                }
            } else if (userInput.startsWith("todo ")) {
                addToDo(parseTodoDescription(userInput));
            } else if (userInput.startsWith("deadline ")) {
                addDeadline(parseDeadlineDescription(userInput), parseBy(userInput));
            } else if (userInput.startsWith("event ")) {
                addEvent(parseEventDescription(userInput), parseFrom(userInput), parseTo(userInput));
            } else {
                switch (userInput) {
                case "bye":
                    break;
                case "list":
                    listTasks();
                    break;
                case "":
                    printIndented("Human, Please enter a task number:");
                    break;
                default:
                    addToDo(userInput);
                }
            }
            if (!userInput.equalsIgnoreCase("bye")) {
                printIndented(LINE_BREAK);
            }
        } while (!userInput.equalsIgnoreCase("bye"));

        printIndented("Bye Human, I wish you a nice. Hope to see you again soon!");
        printIndented(LINE_BREAK);
        scanner.close();
    }
}
