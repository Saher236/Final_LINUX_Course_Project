import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Watermark {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Watermark <image-folder> <output-folder> \"<student1-info>\" \"<student2-info>\"");
            System.exit(1);
        }

        File inputDir = new File(args[0]);
        File outputDir = new File(args[1]);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        String student1 = args[2];
        String student2 = args[3];

        for (File file : inputDir.listFiles()) {
            try {
                BufferedImage image = ImageIO.read(file);
                Graphics2D g2d = image.createGraphics();

                g2d.setFont(new Font("Arial", Font.BOLD, 36));
                g2d.setColor(new Color(255, 0, 0, 128));

                int x = image.getWidth() / 10;
                int y1 = image.getHeight() / 10;
                int y2 = y1 + 40;

                g2d.drawString(student1, x, y1);
                g2d.drawString(student2, x, y2);

                File outputFile = new File(outputDir, file.getName());
                ImageIO.write(image, "png", outputFile);
                g2d.dispose();

                System.out.println("Watermark added to: " + file.getName());
            } catch (IOException e) {
                System.err.println("Error processing: " + file.getName());
            }
        }
    }
}
