package main.java.com.aspose.drawing.examples.LinesCurvesShapes;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.GraphicsPath;

import java.io.File;
import java.io.IOException;


public class DrawPath {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);

        Pen pen = new Pen(Color.getBlue(), 2);
        GraphicsPath path = new GraphicsPath();
        path.addLine(100, 100, 1000, 400);
        path.addLine(1000, 600, 300, 600);
        path.addRectangle(new Rectangle(500, 350, 200, 400));
        path.addEllipse(10, 250, 450, 300);
        graphics.drawPath(pen, path);

        bitmap.save(createFileIfNotExist("DrawPath.png"));
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
