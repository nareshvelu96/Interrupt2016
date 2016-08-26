package com.example.naresh.interrupt2016;

/**
 * Created by Mathangi on 24-08-2016.
 */
public class event {

    private String event_name;
    private String rules;
    private String sample;
    private String description;
    private String rounds;

    public event(String event_name, String rules, String sample, String description, String rounds) {
        this.event_name = event_name;
        this.sample = sample;
        this.rules = rules;
        this.description = description;
        this.rounds = rounds;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getRules() {
        return rules;
    }

    public String getSample() {
        return sample;
    }

    public String getDescription() {
        return description;
    }

    public String getRounds() {
        return rounds;
    }
}