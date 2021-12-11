import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
	public static void main(String[] args) {
    // The provided images are apple.jpg, flower.jpg, and kitten.jpg
		int[][] imageData = imgToTwoD("./apple.jpg");
    int[][] negative = negativeColor(imageData);
    twoDToImage(negative, "./negative_apple.jpg");
    int[][] stretchSide = stretchHorizontally(imageData);
    twoDToImage(stretchSide, "./stretchedside_apple.jpg");
    int[][] shrinked = shrinkVertically(imageData);
    twoDToImage(shrinked, "./shrinked_apple.jpg");
    int[][] inverted = invertImage(imageData);
    twoDToImage(inverted, "./inverted_apple.jpg");
    int[][] filtered = colorFilter(imageData, -75, 30, -30);
    twoDToImage(filtered, "./filtered_apple.jpg");
    int[][] blank = new int[500][500];
    int[][] random = paintRandomImage(blank);
    twoDToImage(random, "./random_image.jpg");
    int[][] rect = paintRectangle(imageData, 100, 20, 40, 145, 253);
    twoDToImage(rect, "./rect_apple.jpg");
    // Or load your own image using a URL!
		//int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
		//viewImageData(imageData);
		int[][] trimmed = trimBorders(imageData, 60);
		twoDToImage(trimmed, "./trimmed_apple.jpg");
    int[][] abstractImg = generateRectangles(imageData, 800);
    twoDToImage(abstractImg, "./abstract_apple.jpg");
		// int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
		// Painting with pixels
	}
	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}
	public static int[][] negativeColor(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    // copy the 2D array to negativeImg
    int[][] negativeImg = new int[imageTwoD.length][imageTwoD[0].length];
    // iterating in row-major order
    for (int i = 0; i < imageTwoD.length; i++) {
      for (int j = 0; j <imageTwoD[0].length; j++) {
        // getting RGBA array from each individual pixel
        int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
        // process of inverting the image: 255 - (value of R, G, B)
        rgba[0] = 255 - rgba[0];
        rgba[1] = 255 - rgba[1];
        rgba[2] = 255 - rgba[2];
        // storing the new pixel data to negativeImg
        negativeImg[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return negativeImg;
	}
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    // initialising new 2D array with width x height
    int[][] fatImg = new int[imageTwoD.length][imageTwoD[0].length * 2];
    int it = 0;
    for (int i = 0; i < imageTwoD.length; i++) {
      for (int j = 0; j < imageTwoD[0].length; j++) {
        // we need a counter to know which column we are at to copy one pixel to two pixels
        it = j * 2;
        fatImg[i][it] = imageTwoD[i][j];
        fatImg[i][it + 1] = imageTwoD[i][j];
      }
    }
		return fatImg;
	}
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    // initialise 2D array with half the row size compared to input
    int[][] shrinkImg = new int[imageTwoD.length / 2][imageTwoD[0].length];
    for (int i = 0; i < imageTwoD[0].length; i++) {
      // we need to increment by 2 in order to shrink it
      // we need to stop inner loop early to avoid out of bounds error
      for (int j = 0; j < imageTwoD.length - 1; j += 2) {
        shrinkImg[j / 2][i] = imageTwoD[j][i];
      }
    }
		return shrinkImg;
	}
	public static int[][] invertImage(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    // initialise 2D array with same size as input
    int[][] invertedImg = new int[imageTwoD.length][imageTwoD[0].length];
    // iterating each pixel by row major order
    for (int i = 0; i < imageTwoD.length; i++) {
      for (int j = 0; j < imageTwoD[0].length; j++) {
        // storing all the pixels from input, albeit inverted
        invertedImg[i][j] = imageTwoD[(imageTwoD.length - 1) - i][(imageTwoD[i].length - 1) - j];
      }
    }
		return invertedImg;
	}
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		// TODO: Fill in the code for this method
    // initialising 2D array with same size as input
    int[][] modifiedImg = new int[imageTwoD.length][imageTwoD[0].length];
    // iterating arrays by row major order
    // outer loop - rows
    for (int i = 0; i < imageTwoD.length; i++) {
      // inner loop - columns
      for (int j = 0; j < imageTwoD[0].length; j++) {
        int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
        int newRed = rgba[0] + redChangeValue;
        int newGreen = rgba[1] + greenChangeValue;
        int newBlue = rgba[2] + blueChangeValue;
        // contain all RGB values to be within 0-255
        if (newRed < 0) {
          newRed = 0;
        } else if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen < 0) {
          newGreen = 0;
        } else if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue < 0) {
          newBlue = 0;
        } else if (newBlue > 255) {
          newBlue = 255;
        }
        // storing finalised value to RGBA
        rgba[0] = newRed;
        rgba[1] = newGreen;
        rgba[2] = newBlue;
        // filtered value
        modifiedImg[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return modifiedImg;
	}
	// Painting Methods
	public static int[][] paintRandomImage(int[][] canvas) {
		// TODO: Fill in the code for this method
    Random rand = new Random();
    for (int i = 0; i < canvas.length; i++) {
      for (int j = 0; j < canvas[i].length; j++) {
        int rand1 = rand.nextInt(256);
        int rand2 = rand.nextInt(256);
        int rand3 = rand.nextInt(256);
        int[] rgba = {rand1, rand2, rand3, 255};
        canvas[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return canvas;
	}
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
		// TODO: Fill in the code for this method
    for (int i = 0; i < canvas.length; i++) {
      for (int j = 0; j < canvas[i].length; j++) {
        if (i>=rowPosition && i<=rowPosition + height) {
          if (j>=colPosition && j<=colPosition + width) {
            canvas[i][j] = color;
          }
        }
      }
    }
		return canvas;
	}
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		// TODO: Fill in the code for this method
    Random rand = new Random();
    for (int i = 0; i < numRectangles; i++) {
      int randW = rand.nextInt(canvas[0].length);
      int randH = rand.nextInt(canvas.length);
      int randRowP = canvas.length - randH;
      int randHeightP = canvas[0].length - randW;
      int[] rgba = {rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 255};
      int randColor = getColorIntValFromRGBA(rgba);
      canvas = paintRectangle(canvas, randW, randH, randRowP, randHeightP, randColor);
    }
		return canvas;
	}
	// Utility Methods
	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}
