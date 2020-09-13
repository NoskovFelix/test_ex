package utils;

import java.util.*;

public class ConvertHelper {

    public static List<Map<String,String>> convertStringToMaps(String targetString){
        if (targetString.equals("")){
            throw new RuntimeException("String is null");
        }
        String[] list = targetString.split(";");
        List<Map<String,String>> map = new ArrayList<>();
        Arrays.stream(list).forEach(str->{
            String[] values =  str.split(":")[1].split(",");
            for (String value: values){
                map.add(new HashMap<String, String>(){{put(str.split(":")[0],value);}});
            }
        });
        return map;
    }

    public static StringBuilder convertToString(Map<String,List<String>> map){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,List<String>> entry: map.entrySet()){
            result.append(entry.getKey()).append(":").append(String.join(",", entry.getValue())).append(";");
        }
        return result;
    }
}
