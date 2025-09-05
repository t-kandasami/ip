public class TaskManager {
    private static final int MAX_TASKS = 100;
    private final Task[] tasks = new Task[MAX_TASKS];
    private int taskCounter = 0;

    public void addTask(Task task, UserInterface ui) {
        if (taskCounter < MAX_TASKS) {
            tasks[taskCounter] = task;
            ui.printIndented("Got it. I've added this task:");
            ui.printIndented(task.toString());
            taskCounter++;
            ui.printIndented("Now you have " + taskCounter + " tasks in your task list.");
        } else {
            ui.printIndented("Task list is full Human! Maybe it’s time you finish some tasks.");
        }
    }

    public void listTasks(UserInterface ui) {
        if (taskCounter == 0) {
            ui.printIndented("No tasks have been added in your list yet.");
            return;
        }
        ui.printIndented("Here are your tasks in your list:");
        for (int i = 0; i < taskCounter; i++) {
            ui.printIndented((i + 1) + "." + tasks[i]);
        }
    }

    public void toggleMark(int taskNo, UserInterface ui) {
        if (taskNo < 1 || taskNo > taskCounter) {
            ui.printIndented("Invalid task number! Please try again.");
            ui.printIndented("You are allowed to enter a number between 1 and " + taskCounter);
            return;
        }
        Task task = tasks[taskNo - 1];
        task.setIsDone(!task.getIsDone());
        if (task.getIsDone()) {
            ui.printIndented("Nice Human! I've marked this task as done:");
        } else {
            ui.printIndented("Ok Human! I've marked this task as not done yet:");
        }
        ui.printIndented(task.toString());
    }
}
