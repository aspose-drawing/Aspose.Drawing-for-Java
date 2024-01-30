package main.java.com.aspose.drawing.examples.LinesCurvesShapes;

import com.aspose.drawing.*;

import java.io.File;
import java.io.IOException;


public class DrawBezierSpline {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);

        Pen pen = new Pen(Color.getBlue(), 2);
        PointF p1 = new PointF(0, 0);   // start point
        PointF c1 = new PointF(0, 800);   // first control point
        PointF c2 = new PointF(1000, 0);  // second control point
        PointF p2 = new PointF(1000, 800);  // end point
        graphics.drawBezier(pen, p1, c1, c2, p2);

        bitmap.save(createFileIfNotExist("DrawBezierSpline.png"));
    }

    private static String createFileIfNotExist(String s) {
        File file = new File(getDataDir() + s);
        if (file.exists()) {
            System.out.println("File already exists.");
        } else {
            try {
                // Create the file
                String path = file.getParent();
                File fileDirectory = new File(path);
                if (!fileDirectory.exists()) {
                    fileDirectory.mkdirs();
                }
                if (file.createNewFile()) {
                    System.out.println("File created successfully!");
                } else {
                    System.out.println("Failed to create the file.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        return getDataDir() + s;
    }

    private static String getDataDir() {
        return "result" + File.separator;
    }
}
