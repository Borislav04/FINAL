/**
 * Команда за записване на студент по дадена дисциплина.
 * Употреба: enrollin <фн> <дисциплина>
 */
public class EnrollInCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 3) {
            System.out.println("Употреба: enrollin <фн> <дисциплина>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            String disciplineName = args[2];
            context.getUniversity().enrollInDiscipline(fn, disciplineName);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден факултетен номер.");
        }
    }
}
