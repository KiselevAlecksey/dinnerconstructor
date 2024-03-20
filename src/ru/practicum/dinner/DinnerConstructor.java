package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    static HashMap<String, ArrayList<String>> dishesList;
    static ArrayList<ArrayList<String>> itemList;
    static ArrayList<String> dishName;
    static ArrayList<String> partCombo;
    static ArrayList<String> combo;
    static Random random;

    DinnerConstructor() {
        dishesList = new HashMap<>();
        dishName = new ArrayList<>();
        itemList = new ArrayList<>();
        random = new Random();
    }

    static void addDish(String type, String dish) {

        if (dishesList.get(type) != null) {
            ArrayList<String> dishes = dishesList.get(type);
            dishes.add(dish);
            dishesList.put(type, dishes);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dish);
            dishesList.put(type, dishes);
        }
    }

    static void getTypeDish(String item) {

        if (dishesList.get(item) != null) {
            dishName.add(item);
        } else {
            System.out.println("Такого типа не существует, вы ввели: " + item);
        }
    }

    static void generateCombination(int amount) {
        partCombo = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            combo = new ArrayList<>();
            int size = 0;

            for (String s : dishName) {

                for (String string : dishesList.get(s)) {
                    partCombo.add(string);
                    size = partCombo.size();
                }

                String part = partCombo.get(random.nextInt(size));
                combo.add(part);
                partCombo.clear();
            }

            itemList.add(combo);
            System.out.println("Комбо " + (i + 1));
            System.out.println(itemList.get(i));
            System.out.println();
        }

        dishName.clear();
        itemList.clear();
        combo.clear();
    }

    boolean checkMapNotEmpty() {
        return !dishesList.isEmpty();
    }
}
