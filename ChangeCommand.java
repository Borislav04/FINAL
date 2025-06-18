/**
 * Команда за промяна на информация за студент.
 * Употреба: change <фн> <program|group|year> <стойност>
 */
public class ChangeCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 4) {
            System.out.println("Употреба: change <фн> <program|group|year> <стойност>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            String option = args[2];
            String value = args[3];

            switch (option.toLowerCase()) {
                case "program" -> context.getUniversity().changeStudentProgram(fn, value);
                                  context.setModified(true);
                case "group" ->
                        context.getUniversity().findStudentByFacultyNumber(fn).ifPresent(s -> s.setGroup(value));
                        context.setModified(true);
                case "year" -> {
                    int year = Integer.parseInt(value);
                    context.getUniversity().findStudentByFacultyNumber(fn).ifPresent(s -> s.setYear(year));
                    context.setModified(true);
                }
                default -> System.out.println("Невалидна опция. Използвайте 'program', 'group' или 'year'.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Невалиден формат за факултетен номер или година.");
        }
    }
}
