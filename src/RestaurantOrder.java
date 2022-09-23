import java.util.Arrays;
import java.util.Objects;

public class RestaurantOrder implements Order{

    protected int size;
    protected Item[] items;

    public RestaurantOrder(int size){
        this.size = size;
        items = new Item[size];
    }

    public boolean remove(String itemName){
        for(int i=0;i<size;i++){
            if (items[i]==null)
                continue;
            if (Objects.equals(items[i].getName(),itemName)){
                for(int j=0;j<size;j++){
                    items[j] = items[j+1];
                }
                size -=1;
                return true;
            }
        }
        return false;
    }

    public int getCount(){
        int count = 0;
        for (int i=0;i<size;i++){
            if (items[i]==null)
                continue;
            else
                count++;
        }
        return count;
    }

    @Override
    public void add(Item item) {
        for (int i=0; i<size;i++){
            if (items[i]==null){
                items[i]= item;
                break;
            }
        }
    }

    @Override
    public boolean deleteThis(String item) {
        for (int i=0;i<size;i++){
            if (items[i]==null)
                continue;
            if (Objects.equals(items[i].getName(), item)){
                items[i] = null;
                for (int j=i;i<size-1;j++){
                    items[j] =items[j+1];
                }
                size-=1;
                return true;
            }
        }
        return false;
    }

    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public double getTotalCost() {
        double totalCost=0;
        for (int i=0;i<size;i++){
            if (items[i]==null)
                continue;
            totalCost+=items[i].getCost();
        }
        return totalCost;
    }

    @Override
    public int getItemsCount(String itemName) {
        int count=0;
        for (int i=0;i<size;i++){
            if (items[i]==null)
                continue;
            if(Objects.equals(items[i].getName(),itemName))
                count++;
        }
        return count;
    }

    @Override
    public Item[] getItemSort() {
        Item temp;
        for(int i=1;i<size-1;i++){
            for(int j=0;j<size-(i+1);j++){
                if(items[i].getCost()>items[i+1].getCost()){
                    temp = items[i];
                    items[i] = items[i+1];
                    items[i+1] = temp;
                }
            }
        }
        return items;
    }

    @Override
    public String toString() {
        return "\nRestaurantOrder {\n"+
                Arrays.toString(items)+"\n" +
                "}";
    }
}
