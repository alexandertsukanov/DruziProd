package tsukanov.druzi.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import tsukanov.druzi.entity.Profile;

public interface SocialService<T> {

	@Nullable Profile loginOrSignup(@Nonnull T model);
}
