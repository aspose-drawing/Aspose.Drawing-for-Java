package main.java.com.aspose.drawing.examples.TextFonts;

import com.aspose.drawing.*;
import com.aspose.drawing.text.TextRenderingHint;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class girl_giftCard {
    private static String DIRECTORY = "TextFonts";
    private static String SOURCE = "src\\main\\resources\\";
    public static void main(String[] args) {
        try
        {
            Image image = Image.fromFile(SOURCE + "girl.jpg");
            Graphics graphics = Graphics.fromImage(image);

            graphics.setTextRenderingHint(TextRenderingHint.AntiAliasGridFit);
            graphics.setPageUnit(GraphicsUnit.Pixel);

            SolidBrush brush = new SolidBrush(Color.getNavy());
            Font font = new Font("Calibri", 20, FontStyle.Italic);

            int padding = 5;

            String text = "Happy Birthday!";
            String[] words = text.split(" ");

            int extentWidth = 0;
            int extentHeight = 0;


            List<String> wordsList = new ArrayList<>(Arrays.asList(words));

            for (String word : wordsList) {
                SizeF stringSize = graphics.measureString(word, font);
                extentWidth = Math.max(extentWidth, (int)stringSize.getWidth() + padding);
                extentHeight += (int)stringSize.getHeight();
            }


            RectangleF rectangle = new RectangleF(image.getWidth() - padding - extentWidth,
                    image.getHeight() - padding - extentHeight,
                    extentWidth,
                    extentHeight);

            graphics.drawString(text, font, brush, rectangle);

            image.save(createFileIfNotExist("girl_giftCard.jpg"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String createFileIfNotExist(String s) {
        File file = new File(getDataDir(DIRECTORY) + s);
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
        return getDataDir(DIRECTORY) + s;
    }

    private static String getDataDir(String s) {
        return "result\\" + s + "\\";
    }
}
