/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.abs(i - j) > width) {
                    System.out.print("0  ");
                }
                else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }
}
