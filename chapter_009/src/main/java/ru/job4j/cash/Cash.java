package ru.job4j.cash;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cash {

    private Map<String, SoftReference> data = new HashMap<>();

    public SoftReference get(String key) {
        SoftReference result = null;
        if (data.containsKey(key)) {
            result = data.get(key);
        }
        return result;
    }

    public void add(String key, String value) {
        SoftReference<String> softReference = new SoftReference(value);
        data.put(key, softReference);
    }
}
