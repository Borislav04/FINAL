import java.util.HashMap;
import java.util.Map;

/**
 * Основен обработчик на команди. Използва Command шаблон.
 */
public class CommandHandler {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Инициализира всички поддържани команди.
     */
    public CommandHandler() {
        commands.put("open", new OpenCommand());
        commands.put("close", new CloseCommand());
        commands.put("save", new SaveCommand());
        commands.put("saveas", new SaveAsCommand());
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());

        // Следващите ще добавим допълнително
        commands.put("enroll", new EnrollCommand());
        commands.put("advance", new AdvanceCommand());
        commands.put("change", new ChangeCommand());
        commands.put("graduate", new GraduateCommand());
        commands.put("interrupt", new InterruptCommand());
        commands.put("resume", new ResumeCommand());
        commands.put("enrollin", new EnrollInCommand());
        commands.put("addgrade", new AddGradeCommand());
        commands.put("print", new PrintCommand());
        commands.put("printall", new PrintAllCommand());
        commands.put("protocol", new ProtocolCommand());
        commands.put("report", new ReportCommand());
        commands.put("export", new ExportCommand());
        commands.put("courses", new CoursesCommand());
    }

    /**
     * Изпълнява дадена команда по име.
     *
     * @param input   входният ред, въведен от потребителя
     * @param context споделеното състояние на приложението
     */
    public void executeCommand(String input, ApplicationContext context) {
        String[] parts = input.trim().split("\\s+");
        String commandName = parts[0].toLowerCase();

        Command command = commands.get(commandName);

        if (command != null) {
            command.execute(context, parts);
        } else {
            System.out.println("Невалидна команда. Използвайте 'help' за помощ.");
        }
    }
}
