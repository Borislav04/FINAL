import java.util.Scanner;

/**
 * Команда за извеждане на всички дисциплини по дадена специалност.
 * Използва се: courses <специалност> <курс>
 */
public class CoursesCommand implements Command {

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Моля, първо отворете файл с командата 'open'.");
            return;
        }

        if (args.length < 3) {
            System.out.println("Употреба: courses <специалност> <курс>");
            return;
        }

        String program = args[1];
        int year;
        try {
            year = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Курсът трябва да бъде цяло число.");
            return;
        }

        context.getUniversity().printAllCourses(program, year);
    }
}
