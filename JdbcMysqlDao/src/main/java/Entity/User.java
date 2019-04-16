package Entity;
public class User {
    private int ID;
    private String name;
    public int getId() {

        return ID;
    }
    public void setId(int id) {
        this.ID = id;
    }

    public String getname() {

        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

     @Override
     public String toString()
     {
         return " [id=" + ID + ", name=" + name + "]";
     }
     /*{return"[name="+name+"]";
     }*/
}