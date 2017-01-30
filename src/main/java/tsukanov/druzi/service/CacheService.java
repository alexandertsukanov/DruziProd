package tsukanov.druzi.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import tsukanov.druzi.entity.Profile;

/**
 * 
 * @author tsukanov
 *
 */
public interface CacheService {

	@Nullable Profile findProfileByUid(@Nonnull String uid);
	
	void deleteProfileByUid(@Nonnull String uid);
}
