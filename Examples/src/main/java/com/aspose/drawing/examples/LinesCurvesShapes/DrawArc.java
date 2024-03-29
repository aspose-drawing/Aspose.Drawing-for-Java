package main.java.com.aspose.drawing.examples.LinesCurvesShapes;

import com.aspose.drawing.Bitmap;
import com.aspose.drawing.Color;
import com.aspose.drawing.Graphics;
import com.aspose.drawing.Pen;

import java.io.File;
import java.io.IOException;


public class DrawArc {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);

        Pen pen = new Pen(Color.getBlue(), 2);
        graphics.drawArc(pen, 0, 0, 700, 700, 0, 180);

        bitmap.save(createFileIfNotExist("DrawArc.png"));
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
