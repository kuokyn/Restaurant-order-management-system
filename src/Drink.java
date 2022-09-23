import java.util.Objects;

// immutable class
public final class Drink implements Item {

    private double cost;
    private String name;
    private String description;

    public Drink(String name, String description) throws IllegalArgumentException{
        if (Objects.equals(name,"")){
            throw new IllegalArgumentException("Empty name!");
        }if (Objects.equals(description,"")){
            throw new IllegalArgumentException("Empty description!");
        }
        this.name = name;
        this.description = description;
        this.cost = 0;
    }

    public Drink(double cost,String name, String description) throws IllegalArgumentException{
        if (Objects.equals(name,"")){
            throw new IllegalArgumentException("empty name!");
        }if (Objects.equals(description,"")){
            throw new IllegalArgumentException("empty description!");
        }if (cost<=0){
            throw new IllegalArgumentException("invalid cost value!");
        }
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public double getCost(){
        return cost;
    }
    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\n\tDrink {\n" +
                " \t cost=" + cost +
                ",\n\t name='" + name + '\'' +
                ",\n\t description='" + description + '\'' +
                "\n\t}";
    }
}
