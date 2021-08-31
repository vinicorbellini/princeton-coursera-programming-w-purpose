public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] *= alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < b.length / 2; i++) {
            int r = b.length - i - 1;
            double t = b[r];
            b[r] = b[i];
            b[i] = t;
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int max = Math.max(a.length, b.length);
        double[] c = new double[max];
        double[] d = new double[max];
        if (a.length != b.length) {
            if (a.length < b.length) {
                for (int i = 0; i < a.length; i++) {
                    c[i] = a[i];
                }
                for (int i = 0; i < max; i++) {
                    d[i] = c[i] + b[i];
                }
                return d;
            }
            else {
                for (int i = 0; i < b.length; i++) {
                    c[i] = b[i];
                }
                for (int i = 0; i < max; i++) {
                    d[i] = c[i] + a[i];
                }
                return d;
            }
        }
        else {
            for (int i = 0; i < max; i++) {
                d[i] = a[i] + b[i];
            }
            return d;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) (a.length / alpha)];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[(int) (Math.floor(alpha * i))];
        }
        return b;
    }

    private static double[] clamp(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] > 1.0) b[i] = 1.0;
            else if (b[i] < -1.0) b[i] = -1.0;
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] a = StdAudio.read("beatbox.wav");
        double[] b = StdAudio.read("piano.wav");
        double[] c = StdAudio.read("scratch.wav");
        double[] d = StdAudio.read("singer.wav");
        double[] e = StdAudio.read("cow.wav");
        StdAudio.play(clamp(amplify(a, 1)));
        StdAudio.play(reverse(d));
        StdAudio.play(changeSpeed(c, 2));
        StdAudio.play(clamp(mix(b, d)));
        StdAudio.play(reverse(e));
        StdAudio.play(merge(a, a));
    }
}
