import utils.ConvertHelper;
import utils.ParserHelper;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        String inputString = "Шкаф:Доска,Гвоздь,Фанера;Тумбочка:Доска,Гвоздь,Направляющая;Стеллаж:Профиль,Болт;Пенал:Доска,Болт,Доводчик;Кровать:Доска,Профиль,Гвоздь;";
        System.out.println("Входная строка: " + inputString + "\n");
        List<Map<String,String>> maps = ConvertHelper.convertStringToMaps(inputString);
        Set<String> setOfValues = ParserHelper.getUniqueValues(maps);
        SortedMap<String,List<String>> components = new TreeMap<>();

        for (String value : setOfValues) {
            List<String> objects = new ArrayList<>();
            for (Map<String, String> map : maps) {
                Set<String> tmpSet = ParserHelper.getKeys(map, value);
                if (!tmpSet.isEmpty())
                    objects.add(String.join("",tmpSet));
            }
            components.put(value, objects);
        }
        System.out.println("Строка после преобразований: " + ConvertHelper.convertToString(components));
    }
}
