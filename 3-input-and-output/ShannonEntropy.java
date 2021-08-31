public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] size = new int[m + 1];

        int total = 0;
        while (!StdIn.isEmpty()) {
            size[StdIn.readInt()]++;
            total++;
        }

        double[] p = new double[m + 1];
        double[] entropy = new double[m + 1];
        double shannon = 0;
        for (int i = 1; i <= m; i++) {
            if (size[i] != 0) {
                p[i] = (double) size[i] / total;
                entropy[i] = -p[i] * (Math.log(p[i]) / Math.log(2));
                shannon += entropy[i];
            }
        }
        StdOut.printf("%.4f\n", shannon);
    }
}
