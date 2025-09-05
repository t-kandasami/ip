public class UserInterface {
    private static final String LINE_BREAK = "____________________________________________________________";
    private static final String AGENT_NAME = "Prime";

    // Helps auto indent 4 spaces to show the Bot Response
    public void printIndented(String message) {
        System.out.println("    " + message);
    }
    public void printLineBreak() {
        System.out.println(LINE_BREAK);
    }

    public void printLogo(){
        String logo = """
                    ██████╗ ██████╗ ██╗███╗   ███╗███████╗
                    ██╔══██╗██╔══██╗██║████╗ ████║██╔════╝
                    ██████╔╝██████╔╝██║██╔████╔██║█████╗ \s
                    ██╔═══╝ ██╔══██╗██║██║╚██╔╝██║██╔══╝ \s
                    ██║     ██║  ██║██║██║ ╚═╝ ██║███████╗
                    ╚═╝     ╚═╝  ╚═╝╚═╝╚═╝     ╚═╝╚══════╝
                """;
        printIndented(logo);
    }

    public void printWelcomeMessage() {
        printIndented("Greetings, human. I am " + AGENT_NAME + ".");
        printIndented("Freedom is the right of all sentient beings.");
        printIndented("How may I assist you in protecting our shared world today?");
        printLineBreak();
    }

    public void printByeMessage() {
        printIndented("Bye Human, I wish you a nice. Hope to see you again soon!");
        printLineBreak();
    }
}
