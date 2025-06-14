import java.io.File;

public class OpenCommand implements Command {
    private FileManager fileManager = new FileManager();

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (args.length < 2) {
            System.out.println("Употреба: open <път до файл>");
            return;
        }

        File file = new File(args[1]);
        University university = fileManager.loadUniversityFromFile(file);
        if (university != null) {
            context.setUniversity(university);
            context.setCurrentFile(file);
            context.setFileOpen(true);
            System.out.println("Успешно отворен файл: " + file.getName());
        } else {
            System.out.println("Грешка при отваряне на файла.");
        }
    }
}
