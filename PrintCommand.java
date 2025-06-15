/**
 * Команда за извеждане на информация за студент.
 * Употреба: print <фн>
 */
public class PrintCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: print <фн>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            context.getUniversity().printStudentReport(fn);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден факултетен номер.");
        }
    }
}
