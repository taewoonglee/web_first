package domain;

public class Me {
    
    
    private int id;
    private String name;

    
    public Me(){
        
    }
    public Me(int id) {
        this.id = id;
    }

    public Me(Integer id1, String name) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Me{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
