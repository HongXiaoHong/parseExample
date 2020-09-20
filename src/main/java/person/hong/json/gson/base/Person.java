package person.hong.json.gson.base;

public class Person {

    private int id;
    private String name;
    private String location;
    private Phone phone;

    public Person(int id, String name, String location) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Person() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", location=" + location + ", phone=" + phone + "]";
    }

}
