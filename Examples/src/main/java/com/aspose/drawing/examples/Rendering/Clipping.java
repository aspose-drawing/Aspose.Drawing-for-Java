package main.java.com.aspose.drawing.examples.Rendering;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.GraphicsPath;
import com.aspose.drawing.text.TextRenderingHint;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class Clipping {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800);
        Graphics graphics = Graphics.fromImage(bitmap);
        graphics.setTextRenderingHint(TextRenderingHint.AntiAliasGridFit);

        RectangleF rectangle = new RectangleF(200, 200, 600, 400);
        GraphicsPath clipPath = new GraphicsPath();
        clipPath.addEllipse(rectangle);
        graphics.setClip(clipPath);

        StringFormat stringFormat = new StringFormat();
        stringFormat.setAlignment(StringAlignment.Center);
        stringFormat.setLineAlignment(StringAlignment.Center);
        Brush brush = new SolidBrush(Color.getWhite());
        Font arial = new Font("Arial", 20, FontStyle.Regular);
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sapien tellus, mattis et condimentum eget, commodo ut ipsum. Maecenas elit sapien, tempus sit amet mauris sit amet, hendrerit laoreet nisi. Nulla facilisi. Sed commodo, mauris eget porta commodo, nunc tellus volutpat mi, eu auctor diam libero vel neque. Vestibulum nec mattis dui, nec molestie nisl. Etiam in magna felis. Praesent non nulla tortor. Integer nec convallis purus. Fusce vitae mollis mauris. Cras efficitur dui at mi viverra scelerisque. Morbi quis magna elit. Nulla facilisis id ante sit amet fringilla. Sed iaculis consectetur lectus a interdum. Etiam ut sollicitudin lectus, et congue lectus.";
        graphics.drawString(text, arial, brush, rectangle, stringFormat);

        bitmap.save(createFileIfNotExist("Clipping.png"));
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
