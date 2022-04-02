package runner;

public class Wendo {
    private String Duedate;
    private String time;
    private String title;
    private String notes;


    public Wendo(){}

    public String getDuedate() {
        return Duedate;
    }

    public Wendo setDuedate(String Duedate) {
        this.Duedate = Duedate;
        return this;
    }

    public String gettime() {
        return time;
    }

    public Wendo setLastname(String time) {
        this.time = time;
        return this;
    }

    public String gettitle() {
        return title;
    }

    public Wendo settitle(String title) {
        this.title = title;
        return this;
    }

    public String getnotes() {
        return notes;
    }

    public Wendo setnotes(String notes) {
        this.notes = notes;
        return this;
    }


}
