package main.java.com.aspose.drawing.examples.TextFonts;

import com.aspose.drawing.*;
import com.aspose.drawing.text.TextRenderingHint;

import java.io.File;
import java.io.IOException;


public class cat_with_honor_out {
    private static String DIRECTORY = "TextFonts";
    private static String SOURCE = "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static void main(String[] args) {
        try {
            Image image = Image.fromFile(SOURCE + "cat_with_honor_out.jpg");
            Graphics graphics = Graphics.fromImage(image);

            graphics.setTextRenderingHint(TextRenderingHint.AntiAliasGridFit);
            graphics.setPageUnit(GraphicsUnit.Pixel);

            Pen pen = new Pen(Color.getMagenta(), 1);

            int gap = 2;

            graphics.drawRectangle(pen, 0, 0, image.getWidth() - 1, image.getHeight() - 1);
            graphics.drawRectangle(pen, gap, gap, image.getWidth() - gap - 1, image.getHeight() - gap - 1);


            image.save(createFileIfNotExist("cat_with_honor_out.jpg"));
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
        return "result" + File.separator + s + File.separator;
    }
}
