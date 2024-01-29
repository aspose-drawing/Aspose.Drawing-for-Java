package main.java.com.aspose.drawing.examples.Pens;

import com.aspose.drawing.*;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class Width {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);

        for (int i = 1; i < 8; ++i)
        {
            Pen pen = new Pen(Color.getBlue(), i);
            graphics.drawLine(pen, 100, i * 100, 900, i * 100);
        }

        bitmap.save(createFileIfNotExinst("Width.png"));
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
