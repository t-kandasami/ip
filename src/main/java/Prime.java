import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        ui.printWelcomeMessage();

        boolean isExit = false;
        while (!isExit) {
            String userInput = scanner.nextLine().trim();
            Command command = Parser.parse(userInput);
            ui.printLineBreak();

            switch (command.getType()) {
            case LIST:
                taskManager.listTasks(ui);
                break;
            case MARK:
                int markTaskNo = Integer.parseInt(command.getArguments());
                taskManager.toggleMark(markTaskNo, ui);
                break;
            case UNMARK:
                int unmarkTaskNo = Integer.parseInt(command.getArguments());
                taskManager.toggleMark(unmarkTaskNo, ui);
                break;
            case TODO:
                taskManager.addTask(new ToDo(command.getArguments()), ui);
                break;
            case DEADLINE:
                String[] deadlineParts = Parser.parseDeadline(command.getArguments());
                if (deadlineParts != null) {
                    taskManager.addTask(new Deadline(deadlineParts[0], deadlineParts[1]), ui);
                } else {
                    ui.printIndented("Invalid deadline format! Use: deadline [desc] /by [time]");
                }
                break;
            case EVENT:
                String[] eventParts = Parser.parseEvent(command.getArguments());
                if (eventParts != null) {
                    taskManager.addTask(new Event(eventParts[0], eventParts[1], eventParts[2]), ui);
                } else {
                    ui.printIndented("Invalid event format! Use: event [desc] /from [start] /to [end]");
                }
                break;
            case BYE:
                isExit = true;
                ui.printByeMessage();
                break;
            default:
                ui.printIndented("Invalid command Human! You are asking me to do stuff I have not been programmed to do");
            }

            if (!isExit) {
                ui.printLineBreak();
            }
        }

        scanner.close();
    }
}
