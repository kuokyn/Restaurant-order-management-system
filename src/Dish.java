import java.util.Objects;

public final class Dish implements Item{

    private double cost;
    private String name;
    private String description;


    public Dish(String name, String description) throws IllegalArgumentException {
        if (Objects.equals(name,"")){
            throw new IllegalArgumentException("empty name!");
        }if (Objects.equals(description,"")){
            throw new IllegalArgumentException("empty description!");
        }
        this.cost = 0;
        this.name = name;
        this.description = description;
    }

    public Dish(double cost,String name, String description) throws IllegalArgumentException{
        if (Objects.equals(name,"")){
            throw new IllegalArgumentException("empty name!");
        }
        if (Objects.equals(description,"")){
            throw new IllegalArgumentException("empty description!");
        }
        if (cost<=0){
            throw new IllegalArgumentException("invalid cost value!");
        }
        this.cost = cost;
        this.name = name;
        this.description = description;
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
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Dish {\n" +
                "cost=" + cost +
                ",\n name='" + name + '\'' +
                ",\n description='" + description + '\'' +
                "\n}";
    }
}
