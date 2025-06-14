import java.io.File;

/**
 * Команда за отваряне на файл и зареждане на обекта University от него.
 */
public class OpenCommand implements Command {

    private final FileManager fileManager;

    public OpenCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String[] args, FileSession session) {
        if (args.length < 2) {
            System.out.println("Използване: open <път до файл>");
            return;
        }

        String path = args[1];
        File file = new File(path);

        University university = fileManager.loadUniversityFromFile(file);

        if (university != null) {
            session.setUniversity(university);
            session.setCurrentFile(file);
            session.setModified(false);
            System.out.println("Успешно отворен: " + file.getName());
        } else {
            System.out.println("Неуспешно зареждане на файл: " + file.getName());
        }
    }
}
