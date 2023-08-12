import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }
    public static String calc(String string) throws Exception {
        String[] result = string.split(" ");

        try {
            if (checkOperands(string)){
                if (RealRoman(result[0],result[2])){
                    return Convertor.Convert(result[0],result[2],result[1]);
                }

                int a = Integer.parseInt(result[0]);
                int b = Integer.parseInt(result[2]);
                if (a>10 || a<1 || b>10 || b<1){
                    throw new Exception("Числа вне диапазона");
                }
                return Convertor.Convert(a,b, result[1]);

            } else {
                throw new Exception("Формат математической операции не удовлетворяет заданию ");
            }
        } catch (Exception exception) {
            throw exception;
        }

    }

    private static boolean checkOperands(String s){
        String[] operators = {"+", "*", "/", "-"};

        for (String element : operators){
            //System.out.println(counterSymbols(s, element));
            if (counterSymbols(s, element) >= 2){
                return false;
            }
        }
        return true;
    }

    public static int counterSymbols(String s, String target) {
        return (s.length() - s.replace(target, "").length()) / target.length();
    }

    private static boolean RealRoman(String s, String s1) {
        String[] ROMAN_NUM = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int k =0;
        for (String element : ROMAN_NUM){
            if(element.equals(s) || element.equals(s1)){
                k+=1;
            }
        }
        return k == 2 || (k == 1 & s.equals(s1));
    }
}