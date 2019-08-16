package lib.casa.casa.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;

public class ImageCollectionUtil
{
    public static Image[] mountStripFrames(Image strip,
                                           int numberLines, int numberColumns)
    {
        int nLines = (numberLines <= 0) ? 1 : numberLines,
            nColumns = (numberColumns <= 0) ? 1 : numberColumns;

        int imageWidth = strip.getWidth(null),
        imageHeight = strip.getHeight(null);
        
        int frameWidth = imageWidth / nColumns,
            frameHeight = imageHeight / nLines;
        
        Image frame[] = new Image[nLines * nColumns];
        ImageProducer stripSource = strip.getSource();
        Toolkit tk = Toolkit.getDefaultToolkit();

        for (int l = 0; l < nLines; l++)
            for (int c = 0; c < nColumns; c++)
                frame[(l* nColumns) + c] = tk.createImage(
                        new FilteredImageSource(stripSource,
                                new CropImageFilter(frameWidth * c, frameHeight * l,
                                                    frameWidth, frameHeight)
                        ));

        return frame;
    }
}