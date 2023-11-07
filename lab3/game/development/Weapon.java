package game.development;

public class Weapon {
    private String title;
    private short bullet;
    private byte damage;
    private float reload;
    public void createWeapon(String title,short bullet,byte damage,float reload){
        this.title=title;
        this.bullet=bullet;
        this.damage=damage;
        this.reload=reload;
    }
    public short getBullet(){
        return bullet;
    }
    public byte getDamage(){
        return damage;
    }

    public void changeReloadSpeed(float reload) {
        this.reload=reload;
    }
}
