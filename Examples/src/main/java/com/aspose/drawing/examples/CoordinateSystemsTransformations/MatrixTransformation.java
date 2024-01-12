package org.example;

import com.aspose.drawing.*;
import com.aspose.drawing.drawing2d.GraphicsPath;
import com.aspose.drawing.drawing2d.Matrix;

import java.io.File;
import java.io.IOException;

import static com.aspose.drawing.imaging.PixelFormat.Format32bppPArgb;


public class MatrixTransformation {
    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(1000, 800, Format32bppPArgb);
        Graphics graphics = Graphics.fromImage(bitmap);
        graphics.clear(Color.fromKnownColor(KnownColor.Gray));

        Rectangle originalRentangle = new Rectangle(300, 300, 300, 200);
        Matrix matrix = new Matrix();
        matrix.rotate(15.0f);
        transformPath(graphics, originalRentangle, matrix);
        matrix = new Matrix();
        matrix.translate(-250, -250);
        transformPath(graphics, originalRentangle, matrix);
        matrix = new Matrix();
        matrix.scale(0.3f, 0.3f);
        transformPath(graphics, originalRentangle, matrix);


        bitmap.save(createFileIfNotExinst("CoordinateSystemsTransformations\\MatrixTransformations_out.png"));
    }

    private static void transformPath(Graphics graphics, Rectangle originalRentangle, Matrix matrix)
    {
        GraphicsPath path = new GraphicsPath();
        path.addRectangle(originalRentangle);

        path.transform(matrix);

        Pen pen = new Pen(Color.fromKnownColor(KnownColor.Blue), 2);
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