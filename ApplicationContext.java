import java.io.File;

public class ApplicationContext {
    private University university;
    private File currentFile;
    private boolean isFileOpen;
    private String currentFilePath;

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
    
    public String getCurrentFilePath() {
    return currentFilePath;
    }

    public void setCurrentFilePath(String currentFilePath) {
    this.currentFilePath = currentFilePath;
    }


    public void clear() {
    this.university = null;
    this.currentFile = null;
    this.currentFilePath = null;
    this.isFileOpen = false;
    }

}
