package ucf.assignments;

import java.time.LocalDate;

public class Item {
    private String name;
    private LocalDate date;
    private boolean complete;

    public Item(String name)
    {
        this.setName(name);
        this.setDate(date.getChronology().dateNow());
        this.setComplete(false);
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public boolean getCompleteStatus()
    {
        return complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
