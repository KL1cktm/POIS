package game.development;

import java.util.ArrayList;

public class Game {
    private String title;
    private String genre;
    private String platform;
    private ArrayList<Character> characters = new ArrayList<>();
    public void setGameInfo(String title,String genre,String platform){
        this.title = title;
        this.genre=genre;
        this.platform=platform;
    }
    protected String getPlatform(){
        return platform;
    }

    protected void addCharacter(Character character){
        characters.add(character);
    }
    public String getGameInfo(){
        String info = "";
        info += "Title: " + title + "\n";
        info += "Genre: " + genre + "\n";
        info += "Platform: " + platform + "\n";
        System.out.println(info);
        return info;
    }

    protected void deleteCharacter(Character character) {
        for (int i=0;i<characters.size();i++)
        {
            if (characters.get(i)==character)
            {
                characters.remove(i);
            }
        }
    }
    public String getCharactersName(){
        String characterList = "";
        for (int i=0;i<characters.size();i++){
            characterList += characters.get(i).getName()+"\n";
        }
        return characterList;
    }
}
