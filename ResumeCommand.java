/**
 * Команда за възстановяване на студент.
 * Употреба: resume <фн>
 */
public class ResumeCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: resume <фн>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            context.getUniversity().resumeStudent(fn);
            context.setModified(true);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден факултетен номер.");
        }
    }
}
