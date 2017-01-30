package tsukanov.druzi.service;

import java.nio.file.Path;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import tsukanov.druzi.Constants.UIImageType;

/**
 * 
 * @author tsukanov
 *
 */
public interface ImageStorageService {
	
	@Nonnull String saveAndReturnImageLink (@Nonnull String imageName, @Nonnull UIImageType imageType, @Nonnull Path tempImageFile);

	void remove (@Nullable String ... imageLinks);
}
