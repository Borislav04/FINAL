/**
 * Команда за генериране на протокол за конкретна дисциплина.
 * Употреба: protocol <дисциплина> <курс> <специалност>
 */
public class ProtocolCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 4) {
            System.out.println("Употреба: protocol <дисциплина> <курс> <специалност>");
            return;
        }

        String courseName = args[1];
        int year;
        try {
            year = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Курсът трябва да е число.");
            return;
        }
        String program = args[3];

        context.getUniversity().generateProtocol(courseName, year, program);
    }
}
