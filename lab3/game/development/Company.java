package game.development;

import java.util.ArrayList;

public class Company extends Contact{
    private String title;
    private short foundationData;
    private int money;
    private ArrayList<Developer> developers = new ArrayList<>();
    private Seller seller;
    private ArrayList<Game> projects = new ArrayList<>();
    public void setTitle(String title) {
        this.title = title;
    }
    public void setFoundationData(short data) {
        foundationData = data;
    }
    public void setSalary(Developer dev,int salary) {
        dev.setSalary(salary);
        money = money-salary;
    }
    public void setStartMoney(int money) {
        this.money = money;
    }
    public void addDeveloper(Developer dev) {
        developers.add(dev);
    }
    protected void buyProject(Game game,int money) {
        this.money=this.money-money;
        this.projects.add(game);
    }
    public void addSeller(Seller seller){
        this.seller=seller;
    }
    public void saleGame(Seller seller,Game game,int price){
        seller.setProduct(game,price);
        money += seller.saleCopies(game);
    }
    public int printMoney(){
        System.out.println(this.money);
        return money;
    }
}
