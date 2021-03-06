package string;

public class BuildLowestNumber {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(buildLowestNumber(num, k));

        num = "10200"; k = 1;

        System.out.println(buildLowestNumber(num, k));
    }

    public static String buildLowestNumber(String num, int k){
        if (num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder(num);

        /*We will iterate the number k times. In each iteration:
        1. Remove the digit for which the next digit is smaller.
        2. If we reach at the end than remove last digit.*/
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
