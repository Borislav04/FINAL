import java.util.Scanner;

/**
 * Команда за записване на нов студент.
 * Употреба: enroll <име> <фн> <специалност> <група>
 */
public class EnrollCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Моля, използвайте 'open' първо.");
            return;
        }

        if (args.length < 5) {
            System.out.println("Употреба: enroll <име> <фн> <специалност> <група>");
            return;
        }

        try {
            String name = args[1];
            int fn = Integer.parseInt(args[2]);
            String program = args[3];
            String group = args[4];

            context.getUniversity().enrollStudent(name, fn, program, group);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден формат за факултетен номер.");
        }
    }
}
