package imageScaling;

import org.openimaj.image.MBFImage;

/**
 * @author Alfred Röttger Rydahl
 * @date 09/03/2020
 *
 * @description This class can downscale and upscale any MBFImage by any scalar.
 **/
public class ScaledImageCreator
{
	/**
	 * Creates a new MBFImage with the width and height respectively divided by
	 * the scalar.
	 *
	 * @param image MBFImage to scale down from
	 * @param scalar Divides with width and height
	 * @return MBFImage
	 */
	public MBFImage downscale(final MBFImage image, int scalar)
	{
		// Create new MBFImage with width and height scaled down
		return new MBFImage(image.getWidth()/scalar, image.getHeight()/scalar);
	}
	
	/**
	 * Creates a new MBFImage with the width and height respectively times the scalar.
	 *
	 * @param image MBFImage to scale up from
	 * @param scalar Times width and height
	 * @return MBFImage
	 */
	public MBFImage upscale(final MBFImage image, int scalar)
	{
		// Create new MBFImage with width and height scaled up
		return new MBFImage(image.getWidth()*scalar, image.getHeight()*scalar);
	}
}
