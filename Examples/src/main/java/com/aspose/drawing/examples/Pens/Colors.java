package main.java.com.aspose.drawing.examples.Pens;

import com.aspose.drawing.Bitmap;
import com.aspose.drawing.Color;
import com.aspose.drawing.Graphics;
import com.aspose.drawing.Pen;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class Colors {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);

        Pen bluePen = new Pen(Color.getBlue(), 2);
        graphics.drawLine(bluePen, 100, 100, 900, 100);

        Pen redPen = new Pen(Color.fromArgb(255, 255, 0, 0), 2);
        graphics.drawLine(redPen, 100, 200, 900, 200);



        bitmap.save(createFileIfNotExist("Colors.png"));
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
