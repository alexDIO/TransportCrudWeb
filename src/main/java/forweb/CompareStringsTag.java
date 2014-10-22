package forweb;

/**
 * Created by olomakovskyi on 10/17/2014.
 */
public class CompareStringsTag {
    public static String checkIfElemSelected (String selectedObjectProperty, String valueToCompare){
        if (valueToCompare.equals(selectedObjectProperty)){
            return "selected";
        } else {
            return "";
        }
    }

    public static Integer parseInteger(String valueToParse){
        return Integer.parseInt(valueToParse);
    }
}
