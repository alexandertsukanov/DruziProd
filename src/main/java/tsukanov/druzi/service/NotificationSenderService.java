package tsukanov.druzi.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import tsukanov.druzi.entity.Profile;
import tsukanov.druzi.model.NotificationMessage;

public interface NotificationSenderService {

	void sendNotification(@Nonnull NotificationMessage message);

	@Nullable String getDestinationAddress(@Nonnull Profile profile);
}
