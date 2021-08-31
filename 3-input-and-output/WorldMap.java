public class WorldMap {
    public static void main(String[] args) {
        // read in bounding box and rescale
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // for bigger points
        StdDraw.setPenRadius(0.001);

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot points, one at a time
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int length = StdIn.readInt();
            double[] x = new double[length];
            double[] y = new double[length];
            for (int i = 0; i < length; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }

        // display all of the points now
        StdDraw.show();
    }
}
