package tsukanov.druzi.component;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * 
 * @author tsukanov
 *
 */
public interface ImageFormatConverter {

	void convertImage(@Nonnull Path sourceImageFile, @Nonnull Path destImageFile) throws IOException;
}
