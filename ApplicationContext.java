import java.io.File;

public class ApplicationContext {
    private University university;
    private File currentFile;
    private boolean isFileOpen;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public boolean isFileOpen() {
        return isFileOpen;
    }

    public void setFileOpen(boolean fileOpen) {
        isFileOpen = fileOpen;
    }

    public void clear() {
        this.university = null;
        this.currentFile = null;
        this.isFileOpen = false;
    }
}
