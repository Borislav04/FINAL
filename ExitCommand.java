/**
 * Команда за изход от програмата със запазване на данните (ако има заредена база).
 */
public class ExitCommand implements Command {

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (context.getUniversity() != null && context.getCurrentFilePath() != null) {
            context.getFileManager().saveUniversity(context.getUniversity(), context.getCurrentFilePath());
        }
        System.out.println("Довиждане!");
        System.exit(0);
    }
}
