public class CloseCommand implements Command {
    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл за затваряне.");
            return;
        }

        String fileName = context.getCurrentFile().getName();
        context.clear();
        System.out.println("Файлът " + fileName + " беше успешно затворен.");
    }
}
