package com.healthcare.cbcanalyzer;

public class CBC_BookModal {

    private String label;
    private String description;


    // Constructor
    public CBC_BookModal(String label, String description) {
        this.label = label;
        this.description = description;
    }
    // Getter and Setter
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
