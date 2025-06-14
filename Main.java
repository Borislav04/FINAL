import java.util.Scanner;

/**
 * Главна точка за стартиране на програмата.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        CommandHandler handler = new CommandHandler();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добре дошли в системата. Въведете 'help' за налични команди.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            if (input.equalsIgnoreCase("exit")) {
                new ExitCommand().execute(context, new String[]{"exit"});
                break;
            }

            handler.executeCommand(input, context);
        }
    }
}
