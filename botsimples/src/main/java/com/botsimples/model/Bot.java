package com.botsimples.model;

public class Bot {
    private final String botName;
    private final String botYear;
    private String userName;
    private int userAge;

    public Bot(String botName, String botYear) {
        this.botName = botName;
        this.botYear = botYear;
    }

    public String getBotName() {
        return botName;
    }

    public String getBotYear() {
        return botYear;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int calculateAge(int rem3, int rem5, int rem7) {
        return (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
    }
}
