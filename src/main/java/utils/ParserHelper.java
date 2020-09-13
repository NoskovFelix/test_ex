package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ParserHelper {

    public static Set<String> getKeys(Map<String,String> map, String value){
        return map.keySet().stream().filter(s->value.equals(map.get(s))).collect(Collectors.toSet());
    }

    public static Set<String> getUniqueValues(List<Map<String,String>> maps){
        Set<String> set = new HashSet<>();
        maps.forEach(map -> {
            for (Map.Entry<String,String> entry: map.entrySet()){
                set.add(String.join("", entry.getValue()));
            }
        });
        return set;
    }
}
