public class Test {

    public static void main(String[] args) {
        String x = args[0];
        String y = args[1];

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
            x0y0 = leadingZero(karatsubaW3(x0, y0));
            x0y1 = leadingZero(karatsubaW3(x0, y1));
            x0y2 = leadingZero(karatsubaW3(x0, y2));
            x1y0 = leadingZero(karatsubaW3(x1, y0));
            x1y1 = leadingZero(karatsubaW3(x1, y1));
            x1y2 = leadingZero(karatsubaW3(x1, y2));
            x2y0 = leadingZero(karatsubaW3(x2, y0));
            x2y1 = leadingZero(karatsubaW3(x2, y1));
            x2y2 = leadingZero(karatsubaW3(x2, y2));
            // repete o processo com o resto das variaveis (total dão 9)

            int soma =
                    Integer.parseInt(x0y0) * (int) Math.pow(10, twoThird+twoThird) +
                    Integer.parseInt(x0y1) * (int) Math.pow(10, twoThird+third)+
                    Integer.parseInt(x0y2) * (int) Math.pow(10, twoThird)+
                    Integer.parseInt(x1y0) * (int) Math.pow(10, third+twoThird)+
                    Integer.parseInt(x1y1) * (int) Math.pow(10, third+third)+
                    Integer.parseInt(x1y2) * (int) Math.pow(10, third)+
                    Integer.parseInt(x2y0) * (int) Math.pow(10, twoThird)+
                    Integer.parseInt(x2y1) * (int) Math.pow(10, third)+
                    Integer.parseInt(x2y2);
            return String.valueOf(soma);

        }
    }
}
