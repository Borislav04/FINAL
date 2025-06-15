/**
 * Команда за извеждане на академична справка за студент.
 * Употреба: report <факултетен номер>
 */
public class ReportCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: report <факултетен номер>");
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
