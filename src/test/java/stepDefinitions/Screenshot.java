package stepDefinitions;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.en.And;
import utils.BaseClass;

public class Screenshot extends BaseClass{
	@And ("capture the Screenshot")
	public void takeScreenshot() {
//	    if (scenario.isFailed() || true) { // true = always take screenshot
		// String filename = "screenshots/screenshot_" + System.currentTimeMillis() + ".png";
		try {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	            //FileUtils.copyFile(srcFile, new File(filename));
	       
	        BufferedImage image = ImageIO.read(srcFile);
	     // Prepare overlay text
	        String currentUrl = driver.getCurrentUrl();
	        String timestamp = java.time.LocalDateTime.now()
	                            .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	        String overlayText = "URL: " + currentUrl + " | Time: " + timestamp;

	        // Draw text on image (top-right corner)
	        Graphics2D g2d = image.createGraphics();
	        g2d.setFont(new Font("Arial", Font.BOLD, 19));
	       

	        // Calculate position (top-right)
	        FontMetrics fm = g2d.getFontMetrics();
	        int textWidth = fm.stringWidth(overlayText);
	        int textHeight = fm.getHeight();
	        int x = 20; // 20px padding from right
	        int y = textHeight+30; // 10px from top
	        
	     // Draw semi-transparent background rectangle
	        g2d.setColor(new Color(255, 255, 255, 200)); // white with transparency
	        g2d.fillRect(x - 5, y - textHeight, textWidth + 10, textHeight);
	        
	        g2d.setColor(Color.BLACK);
	        g2d.drawString(overlayText, x, y);
	        g2d.dispose();
	        File destFile = new File("screenshots/SCR_"+ timestamp+".png");
	        ImageIO.write(image, "png", destFile);
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	}

	


