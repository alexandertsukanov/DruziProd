package tsukanov.druzi.service;

import javax.annotation.Nonnull;

import tsukanov.druzi.entity.Profile;

/**
 * 
 * @author tsukanov
 *
 */
public interface NotificationManagerService {

	void sendRestoreAccessLink(@Nonnull Profile profile, @Nonnull String restoreLink);

	void sendPasswordChanged(@Nonnull Profile profile);
	
	void sendPasswordGenerated(@Nonnull Profile profile, @Nonnull String generatedPassword);
}
