package main.java.com.aspose.drawing.examples.TextFonts;

import com.aspose.drawing.*;
import com.aspose.drawing.text.TextRenderingHint;

import java.io.File;
import java.io.IOException;


public class gears_with_callout_out {
    private static String DIRECTORY = "TextFonts";
    private static String SOURCE = "src\\main\\resources\\";

    public static void main(String[] args) {
        try {
            Image image = Image.fromFile(SOURCE + "gears.png");
            Graphics graphics = Graphics.fromImage(image);

            graphics.setTextRenderingHint(TextRenderingHint.AntiAliasGridFit);
            graphics.setPageUnit(GraphicsUnit.Pixel);

            drawCallOut(graphics, new PointF(107, 55), new PointF(179, 5), 74, "mm");

            drawCallOut(graphics, new PointF(111, 146), new PointF(29, 180), 28, "mm");

            image.save(createFileIfNotExinst("gears_with_callout_out.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void drawCallOut(Graphics graphic, PointF startAnchor, PointF endAnchor, int value, String unit) {
        Pen pen = new Pen(Color.getDarkGray(), 1);

        Font font = new Font("Arial", 10, FontStyle.Bold);

        String outputValue = String.format("%d %s", value, unit);

        var textSize = graphic.measureString(outputValue, font);

        int diameterSymbolSize = 12;
        int spaceSize = 3;

        textSize.setWidth(textSize.getWidth() + diameterSymbolSize + spaceSize);
        ;

        float callOutMiddleX = endAnchor.getX() > startAnchor.getX() ? endAnchor.getX() - textSize.getWidth() : endAnchor.getX() + textSize.getWidth();
        float callOutMiddleY = endAnchor.getY() > startAnchor.getY() ? endAnchor.getY() - textSize.getHeight() : endAnchor.getY() + textSize.getHeight();

        graphic.drawLine(pen, startAnchor.getX(), startAnchor.getY(), callOutMiddleX, callOutMiddleY);

        float textAnchorX = Math.min(callOutMiddleX, endAnchor.getX());
        float textAnchorY = callOutMiddleY;
        graphic.drawLine(pen, callOutMiddleX, callOutMiddleY, textAnchorX == callOutMiddleX ? textAnchorX + textSize.getWidth() : textAnchorX, callOutMiddleY);

        graphic.drawEllipse(pen, new RectangleF((int) textAnchorX + spaceSize, (int) (textAnchorY - textSize.getHeight()) + spaceSize, 10, 10));
        graphic.drawLine(pen, (int) textAnchorX + 1, (int) textAnchorY - 1, (int) textAnchorX + diameterSymbolSize + 2, (int) textAnchorY - diameterSymbolSize - 2);

        SolidBrush brush = new SolidBrush(Color.getDarkGray());

        graphic.drawString(outputValue, font, brush, (int) textAnchorX + diameterSymbolSize + spaceSize, (int) (textAnchorY - textSize.getHeight()));
    }

    private static String createFileIfNotExinst(String s) {
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
