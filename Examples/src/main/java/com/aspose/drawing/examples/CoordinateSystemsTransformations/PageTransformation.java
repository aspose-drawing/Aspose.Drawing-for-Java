package main.java.com.aspose.drawing.examples.CoordinateSystemsTransformations;

import com.aspose.drawing.*;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class PageTransformation {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);
        graphics.clear(Color.fromKnownColor(KnownColor.Gray));

        graphics.setPageUnit(GraphicsUnit.Inch);

        Pen pen = new Pen(Color.fromKnownColor(KnownColor.Blue), 0.1f);
        graphics.drawRectangle(pen, 1, 1, 1, 1);

        bitmap.save(createFileIfNotExinst("CoordinateSystemsTransformations\\PageTransformation_out.png"));
    }

    private static String createFileIfNotExinst(String s) {
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
