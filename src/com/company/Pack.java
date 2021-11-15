package com.company;

public class Pack {

    private Integer timestamp;
    private String inputValue;

    public Pack(Integer timestamp, String inputValue) {
        this.timestamp = timestamp;
        this.inputValue = inputValue;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return timestamp + ": " + inputValue;
    }
}
