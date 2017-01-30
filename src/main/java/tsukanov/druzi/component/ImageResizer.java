package tsukanov.druzi.component;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * 
 * @author tsukanov
 *
 */
public interface ImageResizer {

	void resizeImage(@Nonnull Path sourceImageFile, @Nonnull Path destImageFile, int width, int height) throws IOException;
}
