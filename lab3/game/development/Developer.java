package game.development;

import java.util.ArrayList;

public class Developer extends Human{
    private int salary;
    private ArrayList<String> platform = new ArrayList<>();
    protected void setSalary(int salary) {
        this.salary=salary;
    }
    public void setPlatform(String platform) {
        this.platform.add(platform);
    }
    protected ArrayList<String> getPlatform(){
        return platform;
    }
    protected Character createCharacter(String characterName,String ability,int health) {
        Character character = new Character();
        character.setCharacteristics(characterName,ability, health);
        return character;
    }
    public int getSalary(){
        return salary;
    }
}
