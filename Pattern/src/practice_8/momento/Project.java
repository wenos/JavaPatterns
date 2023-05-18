package practice_8.momento;

import java.util.Date;
public class Project {
    private String version;
    private Date date;
    public void setVandD(String version) {
        this.version = version;
        this.date = new Date();
    }
    public Save save() {
        return new Save(version);
    }

    public void load(Save save) {
        version = save.getVersion();
        date = save.getDate();
    }
    @Override
    public String toString() {
        return "Project\n" + "Version: " + version + " Date: " + date;
    }
}
