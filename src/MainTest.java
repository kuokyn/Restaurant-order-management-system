import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    OrderManager orderManager = new OrderManager(10);
    boolean flag = false;
    RestaurantOrder restaurantOrderDrink = new RestaurantOrder(2);

    @org.junit.jupiter.api.Test
    void createRestaurantOrder() {
        restaurantOrderDrink.add(new Drink(450, "Лимонад", "Манго, маракуйя"));
        orderManager.add(restaurantOrderDrink, 3);
        orderManager.addDish(new Dish(400, "Мясо", "Медиум-прожарка"), 3);
        assertEquals(orderManager.getOrder(3).getTotalCost(), 850);
    }

    @org.junit.jupiter.api.Test
    void createInternetOrder() {
        restaurantOrderDrink.add(new Drink(450, "Лимонад", "Манго, маракуйя"));
        orderManager.add("address", restaurantOrderDrink);
        orderManager.addItem("address", new Dish(400, "Мясо", "Медиум-прожарка"));
        assertEquals(orderManager.getOrder("address").getTotalCost(), 850);
    }

    @org.junit.jupiter.api.Test
    void removeOrder() {
        restaurantOrderDrink.add(new Drink(450, "Лимонад", "Манго, маракуйя"));
        orderManager.add(restaurantOrderDrink, 3);
        int before = 0;
        int after = 0;
        for (int i = 0; i < orderManager.tableCount; i++) {
            if (orderManager.getOrder(i) != null)
                before++;
        }
        if (!flag) {
            orderManager.removeOrder(3);
            for (int i = 0; i < orderManager.tableCount; i++) {
                if (orderManager.getOrder(i) != null)
                    after++;
            }
        } else {
            orderManager.removeOrder("address");
        }
        assertEquals(after, before - 1);
    }
}