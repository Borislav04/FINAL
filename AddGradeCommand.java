/**
 * Команда за добавяне на оценка на студент по дадена дисциплина.
 * Употреба: addgrade <фн> <дисциплина> <оценка>
 */
public class AddGradeCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Използвайте 'open' първо.");
            return;
        }

        if (args.length < 4) {
            System.out.println("Употреба: addgrade <фн> <дисциплина> <оценка>");
            return;
        }

        try {
            int fn = Integer.parseInt(args[1]);
            String disciplineName = args[2];
            double grade = Double.parseDouble(args[3]);

            context.getUniversity().addGrade(fn, disciplineName, grade);
        } catch (NumberFormatException e) {
            System.out.println("Невалидни данни. Проверете факултетния номер и оценката.");
        }
    }
}
