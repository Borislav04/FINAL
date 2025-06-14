/**
 * Команда за извеждане на помощна информация.
 */
public class HelpCommand implements Command {

    @Override
    public void execute(ApplicationContext context, String[] args) {
        System.out.println("\nДостъпни команди:");
        System.out.println("open <път>              - Отваря файл с база данни");
        System.out.println("close                  - Затваря текущо заредената база");
        System.out.println("save                   - Записва промените във файла");
        System.out.println("saveas <път>           - Записва в нов файл");
        System.out.println("help                   - Показва този списък с команди");
        System.out.println("exit                   - Излиза от програмата");

        // Команди свързани със студенти
        System.out.println("enroll <име> <фн> <специалност> <група>       - Записва нов студент");
        System.out.println("advance <фн>                                 - Повишава студента в следващ курс");
        System.out.println("change <фн> <program|group|year> <стойност>  - Променя данни за студент");
        System.out.println("graduate <фн>                                - Дипломира студент");
        System.out.println("interrupt <фн>                               - Прекъсва обучението на студент");
        System.out.println("resume <фн>                                  - Възстановява студент");
        System.out.println("enrollin <фн> <дисциплина>                   - Записва студент в дисциплина");
        System.out.println("addgrade <фн> <дисциплина> <оценка>          - Добавя оценка по дисциплина");
        System.out.println("print <фн>                                   - Извежда справка за студент");
        System.out.println("printall [специалност] [курс]               - Извежда списък на студенти");
        System.out.println("protocol <дисциплина>                       - Генерира протокол по дисциплина");
        System.out.println("report <фн>                                  - Показва академична справка");
        System.out.println("export [файл]                                - Експортира информацията в .txt файл");
        System.out.println("courses <специалност>                        - Показва всички дисциплини за специалност");
        System.out.println();
    }
}
