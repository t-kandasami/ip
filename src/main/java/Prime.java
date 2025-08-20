public class Prime {
    private static final String LINE_BREAK = "____________________________________________________________";
    private static final String AGENT_NAME = "Prime";
    public static void main(String[] args) {
        String logo = " ____  ____  ___ ____  __  __ \n"
                + "|  _ \\|  _ \\|_ _|  _ \\|  \\/  |\n"
                + "| |_) | |_) || || |_) | |\\/| |\n"
                + "|  __/|  _ < | ||  _ <| |  | |\n"
                + "|_|   |_| \\_\\___|_| \\_\\_|  |_|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I'm " + AGENT_NAME);
        System.out.println("What can I do for you?");
        System.out.println(LINE_BREAK);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.print(LINE_BREAK);
    }
}
