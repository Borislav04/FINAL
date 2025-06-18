public class SaveCommand implements Command {
    private FileManager fileManager = new FileManager();

    @Override
    public void execute(ApplicationContext context, String[] args) {
        if (!context.isFileOpen()) {
            System.out.println("Няма отворен файл за запис.");
            return;
        }

        fileManager.saveUniversityToFile(context.getCurrentFile(), context.getUniversity());
        context.setModified(true);
    }
}
