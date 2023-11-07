package game.development;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<Game,Integer> product = new HashMap<Game,Integer>();
    private short markUp;
    private String title;
    private ArrayList<Float> rating = new ArrayList<>();
    public void setMarkUp(short markUp){
        this.markUp=markUp;
    }
    public void setTitle(String title){
        this.title=title;
    }
    protected void Evaluate(float score){
        rating.add(score);
    }
    public float getRating(){
        float score = 0;
        for (int i=0;i<rating.size();i++){
            score += rating.get(i);
        }
        return score/rating.size();
    }
    public void setProduct(Seller seller,Game game){
        product = seller.getProduct();
    }
    protected int inventoryCheck(Game game){
        if (product.containsKey(game)){
            return product.get(game)*55/100+product.get(game);
        }
        return 0;
    }
}
