package game.development;

import java.util.ArrayList;

public class GameDevelopment {
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();
    public void addCompanies(Company company) {
        companies.add(company);
    }
    public void addGames(Game game) {
        games.add(game);
    }
    public Character createCharacter(Game game,Developer developer,String characterName,String ability,int health) {
        for (int i=0;i<developer.getPlatform().size();i++)
        {
            if (game.getPlatform().equals(developer.getPlatform().get(i)))
            {
                Character character = developer.createCharacter(characterName,ability,health);
                game.addCharacter(character);
                return character;
            }
        }
        System.out.println("the developer does not work on this platform");
        Character character = new Character();
        return character;
    }
    public Weapon createGun(Character character,String title,short bullet,byte damage,float reload){
        Weapon weapon = new Weapon();
        weapon.createWeapon(title,bullet,damage,reload);
        return weapon;
    }

    public void addCharacterGun(Character character,Weapon weapon){
        character.changeGun(weapon);
    }
    public void deleteCharacter(Character character,Game game){
        game.deleteCharacter(character);
    }
    public void saleProject(Company company,Game game,int money) {
        company.buyProject(game,money);
    }
}
