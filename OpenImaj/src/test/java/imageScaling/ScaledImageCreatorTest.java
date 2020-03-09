package imageScaling;

import org.junit.jupiter.api.Test;
import org.openimaj.image.MBFImage;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alfred Röttger Rydahl
 * @date 09/03/2020
 *
 * @description This class can downscale and upscale any MBFImage by any scalar.
 **/
class ScaledImageCreatorTest
{

	ScaledImageCreator scaler = new ScaledImageCreator();
	int scalar0 = 2, scalar1 = 12;
	Dimension oriDimen0 = new Dimension(1280, 720);
	Dimension oriDimen1 = new Dimension(1920, 1080);
	MBFImage image0 = new MBFImage(oriDimen0.width, oriDimen0.height);
	MBFImage image1 = new MBFImage(oriDimen1.width, oriDimen1.height);
	
	@Test
	void downscale()
	{
		// Calculate expected values
		int expectedWidth0  = oriDimen0.width/ scalar0;
		int expectedHeight0 = oriDimen0.height/ scalar0;
		int expectedWidth1  = oriDimen1.width/ scalar1;
		int expectedHeight1 = oriDimen1.height/ scalar1;
		
		// Created downscaled images
		MBFImage scaledImage0 = scaler.downscale(image0, scalar0);
		MBFImage scaledImage1 = scaler.downscale(image1, scalar1);
		
		// Assert
		assertEquals(expectedWidth0, scaledImage0.getWidth());
		assertEquals(expectedHeight0, scaledImage0.getHeight());
		assertEquals(expectedWidth1, scaledImage1.getWidth());
		assertEquals(expectedHeight1, scaledImage1.getHeight());
	}
	
	@Test
	void upscale()
	{
		// Calculate expected values
		int expectedWidth0  = oriDimen0.width 	* scalar0;
		int expectedHeight0 = oriDimen0.height 	* scalar0;
		int expectedWidth1  = oriDimen1.width 	* scalar1;
		int expectedHeight1 = oriDimen1.height 	* scalar1;
		
		// Created downscaled images
		MBFImage scaledImage0 = scaler.upscale(image0, scalar0);
		MBFImage scaledImage1 = scaler.upscale(image1, scalar1);
		
		// Assert
		assertEquals(expectedWidth0, scaledImage0.getWidth());
		assertEquals(expectedHeight0, scaledImage0.getHeight());
		assertEquals(expectedWidth1, scaledImage1.getWidth());
		assertEquals(expectedHeight1, scaledImage1.getHeight());
	}
}