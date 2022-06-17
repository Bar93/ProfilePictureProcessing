import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePicture {

    String url;
    File fileUrl;
    private BufferedImage image;
    private int x;
    private int y;
    private int width;
    private int height;

    public ProfilePicture(String url, int x, int y, int width, int height) {
        this.fileUrl = new File(url);
        try {
            this.url = url;
            this.image = ImageIO.read(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image scaledInstance = this.image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.image.getGraphics().drawImage(scaledInstance, 0, 0, null);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage bufferedImage) {
        this.image = bufferedImage;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void grayScale() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < bufferedImage.getHeight(); i++) {
                for (int j = 0; j < bufferedImage.getWidth(); j++) {
                    Color c = new Color(bufferedImage.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    bufferedImage.setRGB(j, i, newColor.getRGB());
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void colorShiftRight() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < bufferedImage.getHeight(); i++) {
                for (int j = 0; j < bufferedImage.getWidth(); j++) {
                    Color c = new Color(bufferedImage.getRGB(j, i));
                    int red = (int) (c.getRed());
                    int green = (int) (c.getGreen());
                    int blue = (int) (c.getBlue());
                    Color newColor = new Color(green, blue, red);
                    bufferedImage.setRGB(j, i, newColor.getRGB());
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void colorShiftLeft() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < bufferedImage.getHeight(); i++) {
                for (int j = 0; j < bufferedImage.getWidth(); j++) {
                    Color c = new Color(bufferedImage.getRGB(j, i));
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    Color newColor = new Color(blue, red, green);
                    bufferedImage.setRGB(j, i, newColor.getRGB());
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mirror() {
        try {
            BufferedImage originalImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            BufferedImage processedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < originalImage.getWidth(); i++) {
                for (int j = 0; j < originalImage.getHeight(); j++) {
                    Color c = new Color(originalImage.getRGB(i, j));
                    processedImage.setRGB(processedImage.getWidth() - i - 1, j, c.getRGB());
                }
            }
            ImageIO.write(processedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void negative() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < bufferedImage.getHeight(); i++) {
                for (int j = 0; j < bufferedImage.getWidth(); j++) {
                    Color c = new Color(bufferedImage.getRGB(j, i));
                    int red = 255 - c.getRed();
                    int green = 255 - c.getGreen();
                    int blue = 255 - c.getBlue();
                    Color newColor = new Color(red, green, blue);
                    bufferedImage.setRGB(j, i, newColor.getRGB());
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void border() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            for (int i = 0; i < bufferedImage.getHeight() - 1; i++) {
                for (int j = 0; j < bufferedImage.getWidth() - 1; j++) {
                    Color c1 = new Color(bufferedImage.getRGB(j, i));
                    Color c2 = new Color(bufferedImage.getRGB(j + 1, i));
                    if (isDifference(c1, c2)) {
                        Color newColor = new Color(0, 0, 0);
                        bufferedImage.setRGB(j, i, newColor.getRGB());
                    }
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDifference(Color c1, Color c2) {
        int difference = 0;
        int minDifference = 20;
        difference += Math.abs(c1.getRed() - c2.getRed());
        difference += Math.abs(c1.getBlue() - c2.getBlue());
        difference += Math.abs(c1.getGreen() - c2.getGreen());
        if (difference > minDifference) {
            return true;
        } else
            return false;
    }

    public void setBrightness(int num) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(Constant.PATH_ORIGINAL_IMAGE));
            if (num != 5) {
                for (int i = 0; i < bufferedImage.getHeight(); i++) {
                    for (int j = 0; j < bufferedImage.getWidth(); j++) {
                        Color c = new Color(bufferedImage.getRGB(j, i));
                        if (num > 5) {
                           for (int z = 5; z < num; z++) {
                                c=c.darker();
                            }
                      }
                        if (num < 5) {
                            for (int z = 5; z > num; z--) {
                                c=c.brighter();
                            }
                        }
                        bufferedImage.setRGB(j, i, c.getRGB());
                    }
                }
            }
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


