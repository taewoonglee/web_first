package data;
abstract public class Unit {
    private String name;
    private int hp;
    private int attackPoint;
    public Unit(String name, int hp, int attackPoint) {
        this.name = name;
        this.attackPoint = attackPoint;
        this.hp = hp;
    }
    public Unit(String name, int attackPoint) {
        this.name = name;
        this.attackPoint = attackPoint;
    }
    public String attack() {
        return name+ "가 " + attackPoint + "딜을 줬습니다";
    }
    public String getDamage(Unit unit) {
        this.hp = this.hp - unit.getAttackPoint();
        return name+ "가 "+ unit.getName()+ "한테 "
                + unit.getAttackPoint() + "딜을 받았다";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAttackPoint() {
        return attackPoint;
    }
    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

}