package tsukanov.druzi.repository.storage;

import org.springframework.data.repository.CrudRepository;

import tsukanov.druzi.entity.ProfileRestore;

/**
 * 
 * @author tsukanov
 *
 */
public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {
	
	ProfileRestore findByToken(String token);
}
