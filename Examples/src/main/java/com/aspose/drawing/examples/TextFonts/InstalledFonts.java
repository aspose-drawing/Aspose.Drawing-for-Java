package main.java.com.aspose.drawing.examples.TextFonts;

import com.aspose.drawing.*;
import com.aspose.drawing.text.InstalledFontCollection;
import com.aspose.drawing.text.TextRenderingHint;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class InstalledFonts {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);
        graphics.setTextRenderingHint(TextRenderingHint.AntiAliasGridFit);
        graphics.clear(Color.getWhite());

        Brush brush = new SolidBrush(Color.getBlack());
        InstalledFontCollection fonts = new InstalledFontCollection();
        Font arial = new Font("Arial", 20, FontStyle.Regular);
        graphics.drawString(fonts.getFamilies().length + " installed font families.", arial, brush, 100, 100);

        for (int i = 0; i < 6 && i < fonts.getFamilies().length; ++i)
        {
            graphics.drawString(fonts.getFamilies()[i].getName(), arial, brush, 100, (i + 2) * 100);
        }

        bitmap.save(createFileIfNotExist("InstalledFonts.png"));
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
