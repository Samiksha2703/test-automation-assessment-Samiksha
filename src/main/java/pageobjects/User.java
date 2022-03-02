package pageobjects;

public class User {
    String username;
    String password;
    String skill;
    String details;

    public User(String username, String password, String skill, String details){
        this.username = username;
        this.password = password;
        this.skill = skill;
        this.details = details;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
