package prime.manager;

import prime.exceptions.InvalidTaskNumberException;
import prime.exceptions.PrimeException;
import prime.task.Task;
import prime.ui.UserInterface;

public class TaskManager {
    private static final int MAX_TASKS = 100;
    private final Task[] tasks = new Task[MAX_TASKS];
    private int taskCounter = 0;

    public void addTask(Task task, UserInterface ui) throws PrimeException {
        if (taskCounter < MAX_TASKS) {
            tasks[taskCounter] = task;
            ui.printIndented("Got it. I've added this task:");
            ui.printIndented(task.toString());
            taskCounter++;
            ui.printIndented("Now you have " + taskCounter + " tasks in your task list.");
        } else {
            throw new PrimeException("Task list is full Human! Maybe it’s time you finish some tasks.");
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

    public void toggleMark(int taskNo, UserInterface ui) throws InvalidTaskNumberException {
        if (taskNo < 1 || taskNo > taskCounter) {
            throw new InvalidTaskNumberException(taskNo,taskCounter);
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
