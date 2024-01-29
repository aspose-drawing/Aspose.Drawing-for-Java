package main.java.com.aspose.drawing.examples.LinesCurvesShapes;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.GraphicsPath;

import java.io.File;
import java.io.IOException;


public class FillRegion {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);

        GraphicsPath path = new GraphicsPath();
        path.addPolygon(new Point[] { new Point(100, 400), new Point(500, 100), new Point(900, 400), new Point(500, 700) });
        Region region = new Region(path);

        GraphicsPath innerPath = new GraphicsPath();
        innerPath.addRectangle(new Rectangle(300, 300, 400, 200));
        region.exclude(innerPath);

        Brush brush = new SolidBrush(Color.getBlue());
        graphics.fillRegion(brush, region);
        bitmap.save(createFileIfNotExist("FillRegion.png"));
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
        return "result\\";
    }


}
