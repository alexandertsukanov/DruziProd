package tsukanov.druzi.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 * @author tsukanov
 *
 */
public class UploadTempPath extends AbstractModel{
	private final Path largeImagePath;
	private final Path smallImagePath;
	public UploadTempPath() throws IOException {
		super();
		this.largeImagePath = Files.createTempFile("large", ".jpg");
		this.smallImagePath = Files.createTempFile("small", ".jpg");
	}
	public Path getLargeImagePath() {
		return largeImagePath;
	}
	public Path getSmallImagePath() {
		return smallImagePath;
	}
}
