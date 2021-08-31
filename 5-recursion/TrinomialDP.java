public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    // if (k < -n || k > n) return 0;
    // else return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) return 0;
        else {
            k = Math.abs(k);
            long[][] T = new long[n + k + 2][n + k + 2];
            T[0][0] = 1;
            for (int i = 1; i <= n + k; i++) {
                for (int j = 0; j <= n + k; j++) {
                    if (j == 0) {
                        T[i][j] = 2 * T[i - 1][j + 1] + T[i - 1][j];
                    }
                    else {
                        T[i][j] = T[i - 1][j - 1] + T[i - 1][j] + T[i - 1][j + 1];
                    }
                }
            }
            return T[n][k];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
