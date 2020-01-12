package ru.job4j.tdd;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private final Pattern pattern = Pattern.compile("\\$\\{.*?\\}");

    @Override
    public String generate(String template, Map<String, String> data) throws Exception {
        Set<String> set = new HashSet<>();
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String key = matcher.group();
            if (!data.containsKey(key)) {
                throw new Exception("Map does't contain that key");
            }
            template = template.replaceFirst(pattern.pattern(), data.get(key));
            set.add(key);
        }
        if (!set.containsAll(data.keySet())) {
            throw new Exception("Map contains unused keys");
        }
        return template;
    }
}
