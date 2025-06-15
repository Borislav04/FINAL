/**
 * Команда за прекъсване на студент.
 * Употреба: interrupt <фн>
 */
public class InterruptCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: interrupt <фн>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            context.getUniversity().interruptStudent(fn);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден факултетен номер.");
        }
    }
}
