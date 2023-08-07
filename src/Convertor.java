public class Convertor {
    private static final char[] romanSymbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    public static final String[] ROMAN_NUM = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static String Convert(String s1, String s2, String operator) throws Exception {
        int num_1 = 0;
        int num_2 = 0;
        for (int i =0; i<10; i++){
            if (s1.equals(ROMAN_NUM[i])){
                num_1 = i+1;
            }
            if (s2.equals(ROMAN_NUM[i])){
                num_2 = i+1;
            }
        }
        switch (operator) {
            case ("+"):
                return ToRoman(num_1+num_2);
            case ("-"):
                if ((num_1-num_2)<=0){
                    throw new Exception();
                }
                return ToRoman(num_1-num_2);
            case ("/"):
                return ToRoman((int)(num_1/num_2));
            case ("*"):
                return ToRoman(num_1 * num_2);
            default:
                throw new Exception();
        }
    }
    public static String ToRoman(int convert) {
        final int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (convert >= arabicValues[i]) {
                roman.append(romanSymbols[i]);
                convert -= arabicValues[i];
            }
        }
        return roman.toString();
    }
    public static String Convert(int num_1,int num_2, String operator) throws Exception {
        switch (operator) {
            case ("+"):
                return String.valueOf(num_1+num_2);
            case ("-"):
                return String.valueOf(num_1-num_2);
            case ("/"):
                return String.valueOf((int)(num_1/num_2));
            case ("*"):
                return String.valueOf(num_1 * num_2);
            default:
                throw new Exception("Неправильная операция");
        }
    }
}