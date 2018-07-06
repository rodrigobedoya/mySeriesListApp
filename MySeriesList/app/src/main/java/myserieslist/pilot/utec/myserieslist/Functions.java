package myserieslist.pilot.utec.myserieslist;

public class Functions {

    public static String formatToFileName(String name)
    {
        name = name.replaceAll("\\W", "");
        name = name.toLowerCase();
        return name;
    }
}
