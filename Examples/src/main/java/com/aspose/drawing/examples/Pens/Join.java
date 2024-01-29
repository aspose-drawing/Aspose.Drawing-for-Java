package main.java.com.aspose.drawing.examples.Pens;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.GraphicsPath;
import com.aspose.drawing.drawing2d.LineJoin;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class Join {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);

        drawPath(graphics, LineJoin.Bevel, 200);
        drawPath(graphics, LineJoin.Round, 400);
        bitmap.save(createFileIfNotExinst("Join.png"));
    }
    static void drawText(Graphics graphics, String familyName, int y)
    {
        Brush brush = new SolidBrush(Color.getBlack());
        Font font = new Font(familyName, 10, FontStyle.Regular);
        String text = "The quick brown fox jumps over the lazy dog. 0123456789 ~!@#$%^&*()_+-={}[];':\"<>?/,.\\¹`";
        graphics.drawString(text, font, brush, 100, y);
    }
    static void drawPath(Graphics graphics, int join, int y)
    {
        Pen pen = new Pen(Color.getBlue(), 30);
        GraphicsPath path = new GraphicsPath();
        path.startFigure();
        path.addLine(100, y, 200, y);
        path.addLine(200, y, 200, y + 100);
        pen.setLineJoin(join);
        graphics.drawPath(pen, path);
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
