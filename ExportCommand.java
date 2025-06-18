import java.io.File;

/**
 * Команда за експортиране на студентски данни в текстов файл.
 * Употреба: export [име на файл]
 */
public class ExportCommand implements Command {
    private FileManager fileManager = new FileManager();

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл. Моля, използвайте 'open' първо.");
            return;
        }

        String filename = (args.length > 1) ? args[1] : "students_report.txt";
        fileManager.exportToTextFile(filename, context.getUniversity());
        context.setModified(true);
    }
}
