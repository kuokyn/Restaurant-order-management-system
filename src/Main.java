import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void internetOrder(OrderManager orderManager) {
        HashMap<String, Order> list = orderManager.getInternetOrders();
        int i = 1;
        for (String key : list.keySet()) {
            System.out.println("Order №" + i + "(" + key + "): " + list.get(key).toString());
        }
    }

    public static void restaurantOrder(OrderManager orderManager) {
        for (int i = 0; i < orderManager.tableCount; i++) {
            if (orderManager.getOrder(i) != null)
                System.out.println("Table " + i + ": " + orderManager.getOrder(i).toString());
        }
    }

    public static void addOrder(OrderManager orderManager, boolean flag) {
        Scanner scanner = new Scanner(System.in);
        if (!flag) {
            System.out.print("Table: ");
            int table = scanner.nextInt();
            System.out.print("Drink(1) or Dish(2): ");
            int choose = scanner.nextInt();
            System.out.print("Price: ");
            int temp = scanner.nextInt();
            System.out.print("Label: ");
            scanner.nextLine();
            String temp1 = scanner.nextLine();
            System.out.print("Description: ");
            String temp2 = scanner.nextLine();
            switch (choose) {
                case 1:
                    orderManager.addDrink(new Drink(temp, temp1, temp2), table);
                    break;
                case 2:
                    orderManager.addDish(new Dish(temp, temp1, temp2), table);
                    break;
                default:
                    break;
            }
        } else {
            System.out.print("Your address: ");
            String address = scanner.nextLine();
            System.out.print("Drink(1) or Dish(2): ");
            int choose = scanner.nextInt();
            System.out.print("Price: ");
            int temp = scanner.nextInt();
            scanner.nextInt();
            System.out.print("Label: ");
            String temp1 = scanner.nextLine();
            System.out.print("Description: ");
            String temp2 = scanner.nextLine();
            switch (choose) {
                case 1:
                    orderManager.addItem(address, new Drink(temp, temp1, temp2));
                    break;
                case 2:
                    orderManager.addItem(address, new Dish(temp, temp1, temp2));
                    break;
                default:
                    break;
            }
        }
    }

    public static void removeOrder(OrderManager orderManager, boolean flag) {
        Scanner scanner = new Scanner(System.in);
        if (!flag) {
            System.out.print("Table: ");
            int table = scanner.nextInt();
            orderManager.removeOrder(table);
        } else {
            System.out.print("Your address: ");
            String address = scanner.nextLine();
            orderManager.removeOrder(address);
        }
    }

    public static void chooseOption() {
        System.out.println("1. Create restaurant order");
        System.out.println("2. Create Internet order");
        System.out.println("3. Show all restaurant orders");
        System.out.println("4. Show all Internet orders");
        System.out.println("5. Add dish/drink to an order");
        System.out.println("6. Delete order");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount of tables in restaurant: ");
        int count = scanner.nextInt();
        int x, temp, choose, table;
        String temp1, temp2, address;
        OrderManager orderManager = new OrderManager(count);
        while (true) {
            chooseOption();
            x = scanner.nextInt();
            switch (x) {
                case 0:
                    return;
                case 1:
                    System.out.print("Table number: ");
                    table = scanner.nextInt();
                    System.out.print("Drink(1) or Dish(2): ");
                    choose = scanner.nextInt();
                    System.out.print("Price: ");
                    temp = scanner.nextInt();
                    System.out.print("Label: ");
                    scanner.nextLine();
                    temp1 = scanner.nextLine();
                    System.out.print("Description: ");
                    temp2 = scanner.nextLine();
                    switch (choose) {
                        case 1:
                            RestaurantOrder restaurantOrderDrink = new RestaurantOrder(2);
                            restaurantOrderDrink.add(new Drink(temp, temp1, temp2));
                            orderManager.add(restaurantOrderDrink, table);
                            break;
                        case 2:
                            RestaurantOrder restaurantOrderDish = new RestaurantOrder(2);
                            restaurantOrderDish.add(new Dish(temp, temp1, temp2));
                            orderManager.add(restaurantOrderDish, table);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Your address: ");
                    scanner.nextLine();
                    address = scanner.nextLine();
                    System.out.print("Drink(1) or Dish(2): ");
                    choose = scanner.nextInt();
                    System.out.print("Price: ");
                    temp = scanner.nextInt();
                    System.out.print("Label: ");
                    scanner.nextLine();
                    temp1 = scanner.nextLine();
                    System.out.print("Description: ");
                    temp2 = scanner.nextLine();
                    switch (choose) {
                        case 1:
                            RestaurantOrder restaurantOrderDrink = new RestaurantOrder(2);
                            restaurantOrderDrink.add(new Drink(temp, temp1, temp2));
                            orderManager.add(address, restaurantOrderDrink);
                            break;
                        case 2:
                            RestaurantOrder restaurantOrderDish = new RestaurantOrder(2);
                            restaurantOrderDish.add(new Dish(temp, temp1, temp2));
                            orderManager.add(address, restaurantOrderDish);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    restaurantOrder(orderManager);
                    break;
                case 4:
                    internetOrder(orderManager);
                    break;
                case 5:
                    System.out.println("Restaurant - 1 \n Internet - 2");
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            restaurantOrder(orderManager);
                            addOrder(orderManager, false);
                            break;
                        case 2:
                            internetOrder(orderManager);
                            addOrder(orderManager, true);
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Restaurant - 1 \n Internet - 2");
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            restaurantOrder(orderManager);
                            removeOrder(orderManager, false);
                            break;
                        case 2:
                            internetOrder(orderManager);
                            removeOrder(orderManager, true);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
