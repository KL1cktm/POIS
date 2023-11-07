package test.java;

import game.development.*;
import game.development.Character;
import org.junit.Assert;
import org.junit.Test;

public class GameDevelopmentTest {
    @Test
    public void test1(){
        Game game = new Game();
        game.setGameInfo("PUBG","Action","PC");

        Assert.assertEquals("Title: PUBG\nGenre: Action\nPlatform: PC\n",game.getGameInfo());
    }
    @Test
    public void test2(){
        Developer developer = new Developer();
        developer.setPersonalInfo("Eugene","Yurhilevich", (byte) 18,"Java,C++");

        Assert.assertEquals("YurhilevichEugene18Skills: Java,C++",developer.getPersonalInfo());
    }
    @Test
    public void test3(){
        Company company = new Company();
        company.setStartMoney(14000000);
        company.setTitle("Rock-Star");
        company.setFoundationData((short)1965);
        Developer developer = new Developer();
        developer.setPlatform("PC");
        company.addDeveloper(developer);
        company.setSalary(developer,15000);

        Assert.assertEquals(15000,developer.getSalary());
        Assert.assertEquals(13985000,company.printMoney());
    }
    @Test
    public void test4(){
        Company company = new Company();
        Developer developer = new Developer();
        developer.setPlatform("PC");
        GameDevelopment gameDevelopment = new GameDevelopment();
        Game game = new Game();
        game.setGameInfo("GTA","Action","PC");
        gameDevelopment.addGames(game);
        gameDevelopment.addCompanies(company);
        Character character = gameDevelopment.createCharacter(game,developer,"NPC","God",9999999);
        Weapon weapon = gameDevelopment.createGun(character,"AK-47",(short)30,(byte)27,3.5f);
        gameDevelopment.addCharacterGun(character,weapon);

        Assert.assertEquals("NPC\n",game.getCharactersName());
        Assert.assertEquals(30,weapon.getBullet());
        Assert.assertEquals(27,weapon.getDamage());
    }
    @Test
    public void test5(){
        Company company = new Company();
        company.setStartMoney(14000000);
        Game game = new Game();
        game.setGameInfo("GTA","Action","PC");
        GameDevelopment gameDevelopment = new GameDevelopment();
        gameDevelopment.addGames(game);
        gameDevelopment.addCompanies(company);
        gameDevelopment.saleProject(company,game,2000000);

        Assert.assertEquals(12000000,company.printMoney());
    }
    @Test
    public void test6(){
        Company company = new Company();
        company.setStartMoney(14000000);
        Game game = new Game();
        game.setGameInfo("GTA","Action","PC");
        GameDevelopment gameDevelopment = new GameDevelopment();
        gameDevelopment.addGames(game);
        gameDevelopment.addCompanies(company);
        gameDevelopment.saleProject(company,game,2000000);
        Seller seller = new Seller();
        company.addSeller(seller);
        seller.setCopies(480000);
        company.saleGame(seller,game,30);

        Assert.assertEquals(26400000,company.printMoney());
    }
    @Test
    public void test7(){
        Developer developer = new Developer();
        developer.setPhoneNumber("+375443223223");
        developer.setEmail("developer@mail.ru");
        developer.setAddress("Minsk/Belarus");

        Assert.assertEquals("Address: Minsk/Belarus\nEmail: developer@mail.ru\nPhoneNumber: +375443223223\n",developer.printInfo());
    }
    @Test
    public void test8(){
        User user = new User();
        user.setMoney(1700);
        Store store = new Store();
        Company company = new Company();
        company.setStartMoney(14000000);
        Game game = new Game();
        game.setGameInfo("GTA","Action","PC");
        GameDevelopment gameDevelopment = new GameDevelopment();
        gameDevelopment.addGames(game);
        gameDevelopment.addCompanies(company);
        gameDevelopment.saleProject(company,game,2000000);
        Seller seller = new Seller();
        seller.setCopies(480000);
        company.saleGame(seller,game,30);
        company.addSeller(seller);
        store.setProduct(seller,game);
        store.setTitle("Amazon");
        store.setMarkUp((short)55);
        user.buyGame(store,game);

        Assert.assertEquals(1654,user.getMoney());
    }
    @Test
    public void test9(){
        User user = new User();
        Store store = new Store();
        user.setNickname("KL1ck");
        user.setStoreRating(store,4.9f);
        user.setStoreRating(store,4.7f);
        user.setStoreRating(store,4.8f);

        Assert.assertEquals(4.8f,store.getRating(),0.001);
    }
}
