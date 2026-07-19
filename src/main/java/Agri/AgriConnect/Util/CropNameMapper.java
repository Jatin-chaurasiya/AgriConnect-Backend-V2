package Agri.AgriConnect.Util;

import java.util.Map;

public class CropNameMapper {

    private static final Map<String, String> CROP_MAP = Map.ofEntries(
            Map.entry("rice", "Rice"),
            Map.entry("maize", "Maize"),
            Map.entry("chickpea", "Chickpea"),
            Map.entry("kidneybeans", "Kidney Beans"),
            Map.entry("pigeonpeas", "Pigeon Peas"),
            Map.entry("mothbeans", "Moth Beans"),
            Map.entry("mungbean", "Mung Bean"),
            Map.entry("blackgram", "Black Gram"),
            Map.entry("lentil", "Lentil"),
            Map.entry("pomegranate", "Pomegranate"),
            Map.entry("banana", "Banana"),
            Map.entry("mango", "Mango"),
            Map.entry("grapes", "Grapes"),
            Map.entry("watermelon", "Watermelon"),
            Map.entry("muskmelon", "Muskmelon"),
            Map.entry("apple", "Apple"),
            Map.entry("orange", "Orange"),
            Map.entry("papaya", "Papaya"),
            Map.entry("coconut", "Coconut"),
            Map.entry("cotton", "Cotton"),
            Map.entry("jute", "Jute"),
            Map.entry("coffee", "Coffee")
    );

    public static String normalize(String cropName) {
        if (cropName == null) {
            return null;
        }
        return CROP_MAP.getOrDefault(cropName.toLowerCase(), cropName);
    }
}