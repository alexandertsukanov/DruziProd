package tsukanov.druzi.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

import tsukanov.druzi.annotation.constraints.EnglishLanguage;

/**
 * 
 * @author tsukanov
 *
 */
public class SignUpForm extends PasswordForm {

	@NotNull
	@Size(max=50)
	@SafeHtml
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String firstName;

	@NotNull
	@Size(max=50)
	@SafeHtml
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
