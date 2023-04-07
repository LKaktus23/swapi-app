package de.lkaktus.util;

public class Helper {

    public static String CHARACTER_TYPE = "character";
    public static String FILM_TYPE = "film";
    public static String PLANET_TYPE = "planet";
    public static String SPECIES_TYPE = "species";
    public static String STARSHIP_TYPE = "starship";
    public static String VEHICLE_TYPE = "vehicle";

    public static String getIdFromUrl(String url){
        String [] temp = url.split("/");
        return temp[temp.length - 1];
    }

}
