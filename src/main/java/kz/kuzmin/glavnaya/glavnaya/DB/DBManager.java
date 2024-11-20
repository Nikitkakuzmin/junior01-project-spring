package kz.kuzmin.glavnaya.glavnaya.DB;

import kz.kuzmin.glavnaya.glavnaya.Model.Item;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {
    private static ArrayList<Item> items = new ArrayList<>();
    private static Long id = 6L;

    static {
        items.add(new Item(1L, "Iphone", 10000, 4,"iphone-14-pro"));
        items.add(new Item(2L, "Samsung", 9200, 7,"samsung-s-20"));
        items.add(new Item(3L, "Motorolla", 8500, 9,"motorolla-razer-v3"));
        items.add(new Item(4L, "Nokia", 6300, 6,"nokia-33-10"));
        items.add(new Item(5L, "Xiaomi", 7100, 5,"xiaomi-mi-12"));
    }

    public static void addItem(Item item) {
        item.setId(id);
        items.add(item);
        id++;

    }

    public static Item getItem(Long id) {
        return items.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }
}
