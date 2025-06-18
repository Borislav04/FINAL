import java.io.File;

public class SaveAsCommand implements Command {
    private FileManager fileManager = new FileManager();

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Употреба: saveas <път до нов файл>");
            return;
        }

        File newFile = new File(args[1]);
        fileManager.saveUniversityToFile(newFile, context.getUniversity());
        context.setCurrentFile(newFile);
        context.setModified(true);
    }
}
