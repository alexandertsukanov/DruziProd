package tsukanov.druzi.service;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import tsukanov.druzi.model.UploadCertificateResult;
import tsukanov.druzi.model.UploadResult;

/**
 * 
 * @author tsukanov
 *
 */
public interface ImageProcessorService {

	@Nonnull UploadResult processNewProfilePhoto(@Nonnull MultipartFile uploadPhoto);

	@Nonnull
	UploadCertificateResult processNewCertificateImage(@Nonnull MultipartFile uploadCertificateImage);
}
