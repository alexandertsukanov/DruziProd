package tsukanov.druzi.component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 
 * 
 * @author tsukanov
 *
 */
public interface TemplateResolver {

	@Nonnull String resolve(@Nonnull String template, @Nullable Object model);
}
