package dbadapter;

import java.sql.Timestamp;

public class Presentation {

    private int id;
    private int dauer;
    private int hall;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private Boolean isArchived;

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDauer() {
        return this.dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getHall() {
        return this.hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
