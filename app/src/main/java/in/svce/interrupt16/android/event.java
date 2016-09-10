package in.svce.interrupt16.android;

/**
 * Created by Mathangi on 24-08-2016.
 */
public class event {

    private String event_name;
    private String event_type;
    private String description;
    private String rounds;




    public event(String event_name, String event_type, String description, String rounds) {
        this.event_name = event_name;
        this.event_type = event_type;
        this.description = description;
        this.rounds = rounds;




    }
    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_type() { return event_type;}

    public String getDescription() {
        return description;
    }

    public String getRounds() {
        return rounds;
    }





}