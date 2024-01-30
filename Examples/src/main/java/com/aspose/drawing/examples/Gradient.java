package main.java.com.aspose.drawing.examples;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.LinearGradientBrush;
import com.aspose.drawing.drawing2d.SmoothingMode;

import java.io.File;
import java.io.IOException;


public class Gradient {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);
        graphics.setSmoothingMode(SmoothingMode.HighQuality);

        Brush brush = new LinearGradientBrush(new Point(0, 0), new Point(1000, 800), Color.getRed(), Color.getBlue());
        graphics.fillEllipse(brush, 100, 100, 800, 600);

        bitmap.save(createFileIfNotExist("gradient.png"));
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
