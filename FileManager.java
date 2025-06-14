import java.io.*;
import java.util.Set;

/**
 * Клас за управление на файловите операции:
 * - запис и зареждане на данни от/в конкретен файл
 * - експорт в текстов файл
 */
public class FileManager {
    private static final String DEFAULT_FILE = "university.dat";

    /**
     * Записва подадения обект University във файл по подразбиране.
     *
     * @param university обектът, който ще бъде записан
     */
    public void saveUniversity(University university) {
        saveUniversityToFile(new File(DEFAULT_FILE), university);
    }

    /**
     * Записва University обекта в конкретен файл.
     *
     * @param file       файлът, в който да се запише
     * @param university обектът за записване
     */
    public void saveUniversityToFile(File file, University university) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(university);
            System.out.println("Данните са запазени успешно във файл: " + file.getName());
        } catch (IOException e) {
            System.err.println("Грешка при запис на данните: " + e.getMessage());
        }
    }

    /**
     * Зарежда University от файл по подразбиране.
     *
     * @return обект University или нов, ако не съществува
     */
    public University loadUniversity() {
        return loadUniversityFromFile(new File(DEFAULT_FILE));
    }

    /**
     * Зарежда University от подаден файл.
     *
     * @param file файлът, от който ще се чете
     * @return зареден University обект или null при неуспех
     */
    public University loadUniversityFromFile(File file) {
        if (!file.exists()) {
            System.out.println("Файлът не съществува. Създава се нова база.");
            return new University();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            University university = (University) ois.readObject();
            System.out.println("Данните са заредени успешно от файл: " + file.getName());
            return university;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Грешка при зареждане на данните: " + e.getMessage());
            return null;
        }
    }

    /**
     * Експортира списък на студентите и техните дисциплини в текстов файл.
     *
     * @param filename   име на текстовия файл
     * @param university обектът с информацията
     */
    public void exportToTextFile(String filename, University university) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== Списък на студентите ===");
            for (Student student : university.getStudents()) {
                writer.println(student);
                Set<Discipline> disciplines = student.getEnrolledDisciplines();
                for (Discipline d : disciplines) {
                    writer.println("  - " + d.getName());
                }
            }
            System.out.println("Данните са експортирани в " + filename);
        } catch (IOException e) {
            System.err.println("Грешка при експорт: " + e.getMessage());
        }
    }
}
