package tsukanov.druzi.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import tsukanov.druzi.model.NotificationMessage;

public interface NotificationTemplateService {

	@Nonnull
	NotificationMessage createNotificationMessage (@Nonnull String templateName, @Nullable Object model);
}
