package game.development;

import java.util.ArrayList;

public class User {
    private String nickname;
    private int money;
    private ArrayList<Game> games = new ArrayList<>();
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public void buyGame(Store store,Game game){
        int price = store.inventoryCheck(game);
        if (price <= money){
            money -= price;
            games.add(game);
        }
        else {
            System.out.println("Insufficient funds on the balance");
        }
    }
    public void setStoreRating(Store store,float rating){
        store.Evaluate(rating);
    }
    public int getMoney(){
        return this.money;
    }
}
