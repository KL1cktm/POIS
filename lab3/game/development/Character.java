package game.development;

public class Character {
    private String name;
    private String ability;
    private int healPoint;
    private Weapon weapon;

    protected void setCharacteristics(String characterName,String ability,int health)
    {
        this.name=characterName;
        this.ability=ability;
        this.healPoint=health;
    }
    protected void changeGun(Weapon weapon) {
        this.weapon=weapon;
    }
    protected String getName(){
        return this.name;
    }
}
