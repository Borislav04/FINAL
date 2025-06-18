/**
 * Команда за преминаване на студент в следващ курс.
 * Употреба: advance <фн>
 */
public class AdvanceCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: advance <фн>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            context.getUniversity().advanceStudent(fn);
            context.setModified(true);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден формат за факултетен номер.");
        }
    }
}
