import java.io.File;

public class FileSession {
    private University university;
    private File currentFile;
    private boolean isModified;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
        this.isModified = false;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public void clear() {
        university = null;
        currentFile = null;
        isModified = false;
    }

    public boolean hasOpenFile() {
        return university != null;
    }
}
