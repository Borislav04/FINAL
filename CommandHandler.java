import java.util.HashMap;
import java.util.Map;

/**
 * Клас, който регистрира и изпълнява обектни команди.
 */
public class CommandHandler {

    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandHandler(FileManager fileManager) {
        FileSession session = new FileSession(); // можем да държим това извън, ако искаш

        // Регистрация на всички команди:
        commandMap.put("open", new OpenCommand(fileManager));
        commandMap.put("save", new SaveCommand(fileManager));
        commandMap.put("saveas", new SaveAsCommand(fileManager));
        commandMap.put("close", new CloseCommand());
        commandMap.put("help", new HelpCommand());
        commandMap.put("exit", new ExitCommand(fileManager));

        // Университетски команди
        commandMap.put("enroll", new EnrollCommand());
        commandMap.put("advance", new AdvanceCommand());
        commandMap.put("change", new ChangeCommand());
        commandMap.put("graduate", new GraduateCommand());
        commandMap.put("interrupt", new InterruptCommand());
        commandMap.put("resume", new ResumeCommand());
        commandMap.put("enrollin", new EnrollInCommand());
        commandMap.put("addgrade", new AddGradeCommand());
        commandMap.put("print", new PrintCommand());
        commandMap.put("printall", new PrintAllCommand());
        commandMap.put("report", new ReportCommand());
        commandMap.put("protocol", new ProtocolCommand());
        commandMap.put("export", new ExportCommand());
        commandMap.put("courses", new CoursesCommand());

        // Пазим сесията и я предаваме при изпълнение (може и от Main)
    }

    /**
     * Изпълнява команда по име.
     */
    public void executeCommand(String input, FileSession session) {
        if (input == null || input.isEmpty()) return;

        String[] parts = input.trim().split("\\s+");
        String commandName = parts[0].toLowerCase();

        Command command = commandMap.get(commandName);
        if (command == null) {
            System.out.println("Невалидна команда. Използвайте 'help'.");
            return;
        }

        command.execute(parts, session);
    }
}
