package tsukanov.druzi.form;

import org.hibernate.validator.constraints.SafeHtml;

import tsukanov.druzi.annotation.constraints.EnglishLanguage;
import tsukanov.druzi.entity.Profile;

/**
 * 
 * @author tsukanov
 *
 */
public class InfoForm {

	@EnglishLanguage
	@SafeHtml
	private String info;

	public InfoForm() {
		super();
	}

	public InfoForm(String info) {
		super();
		this.info = info;
	}
	
	public InfoForm(Profile profile) {
		super();
		this.info = profile.getInfo();
	}

	public String getInfo() {
		return info != null ? info.trim() : null;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
