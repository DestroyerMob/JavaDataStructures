package org.destroyermob;

import org.destroyermob.datastructures.hashmap.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Monday", 1);
        map.put("Tuesday", 2);
        map.put("Wednesday", 3);
        map.put("Wednesday", 3);
        map.put("Thursday", 4);
        map.put("Friday", 5);
        map.put("Saturday", 6);
        map.put("Sunday", 7);

        System.out.println(map.get("Wednesday"));

    }
}