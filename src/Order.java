public interface Order {
    public void add(Item item);
    public boolean deleteThis(String item);
    public Item[] getItems();
    public double getTotalCost();
    public int getItemsCount(String itemName);
    public Item[] getItemSort();
}
