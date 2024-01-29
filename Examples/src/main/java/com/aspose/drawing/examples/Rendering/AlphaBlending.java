package main.java.com.aspose.drawing.examples.Rendering;

import com.aspose.drawing.*;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class AlphaBlending {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);

        graphics.fillEllipse(new SolidBrush(Color.fromArgb(128, 255, 0, 0)), 300, 100, 400, 400);
        graphics.fillEllipse(new SolidBrush(Color.fromArgb(128, 0, 255, 0)), 200, 300, 400, 400);
        graphics.fillEllipse(new SolidBrush(Color.fromArgb(128, 0, 0, 255)), 400, 300, 400, 400);

        bitmap.save(createFileIfNotExinst("AlphaBlending.png"));
    }
    static void drawText(Graphics graphics, String familyName, int y)
    {
        Brush brush = new SolidBrush(Color.getBlack());
        Font font = new Font(familyName, 10, FontStyle.Regular);
        String text = "The quick brown fox jumps over the lazy dog. 0123456789 ~!@#$%^&*()_+-={}[];':\"<>?/,.\\¹`";
        graphics.drawString(text, font, brush, 100, y);
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
