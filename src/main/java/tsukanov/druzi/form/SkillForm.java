package tsukanov.druzi.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import tsukanov.druzi.entity.Skill;

/**
 * 
 * @author tsukanov
 *
 */
public class SkillForm {
	@Valid
	private List<Skill> items = new ArrayList<>();
	
	public SkillForm() {
		super();
	}

	public SkillForm(List<Skill> items) {
		super();
		this.items = items;
	}

	public List<Skill> getItems() {
		return items;
	}

	public void setItems(List<Skill> items) {
		this.items = items;
	}
}
