/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int total = 0;

        for (int totaltrials = 1; totaltrials <= trials; totaltrials++) {
            int steps = 0;
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                steps++;
                double a = Math.random();
                int roll = (int) (a * 4);

                if (roll == 0) x = x + 1;
                else if (roll == 1) x = x - 1;
                else if (roll == 2) y = y + 1;
                else y = y - 1;
            }
            total += steps;
        }
        System.out.println("average number of steps = " + 1.0 * total / trials);
    }
}
