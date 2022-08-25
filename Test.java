import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ar = {};
        //String x = args[0];
        //String y = args[1];

        String x = sc.nextLine();
        String y = sc.nextLine();

        int n = Math.max(x.length(), y.length());

        while (x.length() < n) {
            x = "0" + x;
        }
        while (y.length() < n) {
            y = "0" + y;
        }

        while(y.length() % 3 != 0){
            y = "0" + y;
            x = "0" + x;
        }

        System.out.println(karatsubaW3(x,y));
    }

    public static String leadingZero(String x){
        while(x.length() % 3 != 0 && x.length() != 1){
            x = "0" + x;
        }
        return x;
    }

    public static String rightZero(String x, int zeros){
        int aux = 0;

        while(aux != zeros){
            x = x+"0";
            aux++;
        }

        return x;
    }

    public static String karatsubaW3 (String x, String y) {

        if(x.length() ==1 || y.length()==1) {
            return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
        }
        else {
            
            int third = x.length() / 3;
            int twoThird = 2 * third;

            String x0 = leadingZero(x.substring(0, third));
            String x1 = leadingZero(x.substring(third, twoThird));
            String x2 = leadingZero(x.substring((twoThird)));

            String y0 = leadingZero(y.substring(0, third));
            String y1 = leadingZero(y.substring(third, twoThird));
            String y2 = leadingZero(y.substring(twoThird));


            String x0y0, x0y1, x0y2, x1y0, x1y1, x1y2, x2y0, x2y1, x2y2;
            x0y0 = rightZero(karatsubaW3(x0, y0), 2 * twoThird);
            x0y1 = rightZero(karatsubaW3(x0, y1), twoThird + third);
            x0y2 = rightZero(karatsubaW3(x0, y2), twoThird);
            x1y0 = rightZero(karatsubaW3(x1, y0), twoThird+third);
            x1y1 = rightZero(karatsubaW3(x1, y1), third+third);
            x1y2 = rightZero(karatsubaW3(x1, y2), third);
            x2y0 = rightZero(karatsubaW3(x2, y0), twoThird);
            x2y1 = rightZero(karatsubaW3(x2, y1), third);
            x2y2 = karatsubaW3(x2, y2);
            // repete o processo com o resto das variaveis (total dão 9)

            
            return add(x0y0, add(x1y0, add(x2y0, add(x0y1, add(x1y1, add(x2y1, add(x0y2, add(x1y2, x2y2))))))));

        }
    }

    //adding two string numbers
    public static String add(String x, String y) {
        int n = Math.max(x.length(), y.length());
        while (x.length() < n) {
            x = "0" + x;
        }
        while (y.length() < n) {
            y = "0" + y;
        }
        String result = "";
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = (carry + Integer.parseInt(x.charAt(i) + "")) + Integer.parseInt(y.charAt(i) + "");
            if (sum > 9) {
                carry = 1;
                result = sum % 10 + result;
            } else {
                carry = 0;
                result = sum + result;
            }
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }
}
