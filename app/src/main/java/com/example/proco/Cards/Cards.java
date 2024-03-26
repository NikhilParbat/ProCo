package com.example.proco.Cards;

public class Cards {


    private String userId;
    private String name;
    private String ProfileImageUrl;
    private String need;
    private String give;
    private String budget;

    public Cards(String userId, String name, String ProfileImageUrl, String need, String give, String budget) {
        this.userId = userId;
        this.name = name;
        this.ProfileImageUrl = ProfileImageUrl;
        this.need = need;
        this.give = give;
        this.budget = budget;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl(){
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String ProfileImageUrl) {
        this.ProfileImageUrl = ProfileImageUrl;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getGive() {
        return give;
    }

    public void setGive(String give) {
        this.give = give;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}




