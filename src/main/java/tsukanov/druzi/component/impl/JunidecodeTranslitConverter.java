package tsukanov.druzi.component.impl;

import org.springframework.stereotype.Component;

import tsukanov.druzi.component.TranslitConverter;
import net.sf.junidecode.Junidecode;

/**
 * 
 * @author tsukanov
 *
 */
@Component
public class JunidecodeTranslitConverter implements TranslitConverter {

	@Override
	public String translit(String text) {
		return Junidecode.unidecode(text);
	}
}
