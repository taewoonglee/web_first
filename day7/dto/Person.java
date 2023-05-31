package dto;

public class Person {
    private String name;
    private int id;
    private int now_state;

    public void setName(String name) {
        this.name = name;
    }
    public void setNow_state(int now_state)
    {
        this.now_state=now_state;
    }
    public int getNow_state()
    {
        return now_state;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }
}
