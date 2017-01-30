package tsukanov.druzi.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Adds druzi.component.impl.UploadImageTempStorage aspect for method annotated by this annotation
 * 
 * 
 * @author tsukanov
 *
 */
@Retention(RUNTIME)
public @interface EnableUploadImageTempStorage {

}
