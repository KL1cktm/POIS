package game.development;

public abstract class Human extends Contact{
    private String name;
    private String lastname;
    private byte age;
    private String skill;

    public void setPersonalInfo(String name,String lastname,byte age,String skill) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.skill = skill;
    }
    public String getPersonalInfo() {
        String info = "";
        info += lastname;
        info += name;
        info += age;
        info += "Skills: " + skill;
        return info;
    }
}
