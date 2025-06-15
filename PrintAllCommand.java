/**
 * Команда за извеждане на всички студенти по специалност и/или курс.
 * Употреба:
 *   printall              - извежда всички студенти
 *   printall <специалност>         - извежда всички студенти в дадената специалност
 *   printall <специалност> <курс>  - извежда студентите в специалност и курс
 */
public class PrintAllCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        University university = context.getUniversity();

        if (args.length == 1) {
            university.printAllStudents(null, 0);
        } else if (args.length == 2) {
            String program = args[1];
            university.printAllStudents(program, 0);
        } else {
            try {
                String program = args[1];
                int year = Integer.parseInt(args[2]);
                university.printAllStudents(program, year);
            } catch (NumberFormatException e) {
                System.out.println("Невалиден курс.");
            }
        }
    }
}
