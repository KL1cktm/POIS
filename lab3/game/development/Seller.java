package game.development;

import java.util.HashMap;
import java.util.Map;

public class Seller extends Contact{
    private Map<Game,Integer> product = new HashMap<Game,Integer>();
    private int copies;

    public void setCopies(int copies) {
        this.copies=copies;
    }
    public void setProduct(Game game,Integer price){
        product.put(game,price);
    }
    protected int saleCopies(Game game) {
        int price = product.get(game);
        int total = price*copies;
        return total;
    }
    protected Map<Game,Integer> getProduct(){
        return product;
    }
}
