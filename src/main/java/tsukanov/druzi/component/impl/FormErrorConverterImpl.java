package tsukanov.druzi.component.impl;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import tsukanov.druzi.annotation.EnableFormErrorConvertation;
import tsukanov.druzi.component.FormErrorConverter;
import tsukanov.druzi.util.DataUtil;

/**
 * 
 * @author tsukanov
 *
 */
@Component
public class FormErrorConverterImpl implements FormErrorConverter {

	@Override
	public void convertFormErrorToFieldError(Class<? extends Annotation> validationAnnotationClass, Object formInstance, BindingResult bindingResult) {
		Annotation validationAnnotation = findValidationAnnotation(validationAnnotationClass, formInstance);
		List<EnableFormErrorConvertation> metaAnnotations = findMetaAnnotations(formInstance);
		boolean found = false;
		for (EnableFormErrorConvertation metaAnnotation : metaAnnotations) {
			if (metaAnnotation.validationAnnotationClass() == validationAnnotationClass) {
				processGlobalErrorConvertation(validationAnnotation, metaAnnotation, formInstance, bindingResult);
				processFormFieldErrorConvertation(validationAnnotation, metaAnnotation, formInstance, bindingResult);
				found = true;
				break;
			}
		}
		if (!found) {
			throw new IllegalArgumentException("validationAnnotationClass not found for EnableFormErrorConvertation annoattion: validationAnnotationClass=" + validationAnnotationClass
					+ ", formInstance=" + formInstance.getClass());
		}
	}

	protected void processGlobalErrorConvertation(Annotation validationAnnotation, EnableFormErrorConvertation metaAnnotation, Object formInstance, BindingResult bindingResult) {
		for (ObjectError objectError : bindingResult.getGlobalErrors()) {
			for (String code : objectError.getCodes()) {
				if (getCodeForAnnotation(validationAnnotation).equals(code)) {
					createFieldErrorForErrorCode(metaAnnotation, objectError, formInstance, bindingResult);
					return;
				}
			}
		}
	}

	protected void processFormFieldErrorConvertation(Annotation validationAnnotation, EnableFormErrorConvertation metaAnnotation, Object formInstance, BindingResult bindingResult) {
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			if (fieldError.getField().startsWith("items[") && fieldError.getField().endsWith("]")) {
				for (String code : fieldError.getCodes()) {
					if (getCodeForAnnotation(validationAnnotation).equals(code)) {
						createFieldErrorForErrorCode(metaAnnotation, fieldError, formInstance, bindingResult);
						return;
					}
				}
			}
		}
	}

	protected Annotation findValidationAnnotation(Class<? extends Annotation> validationAnnotationClass, Object formInstance) {
		Annotation validationAnnotation = findAnnotation(validationAnnotationClass, formInstance);
		if (validationAnnotation == null) {
			throw new IllegalArgumentException(
					"validationAnnotationClass not found for formInstance: validationAnnotationClass=" + validationAnnotationClass + ", formClass=" + formInstance.getClass());
		}
		return validationAnnotation;
	}

	protected List<EnableFormErrorConvertation> findMetaAnnotations(Object formInstance) {
		EnableFormErrorConvertation metaAnnotation = findAnnotation(EnableFormErrorConvertation.class, formInstance);
		if (metaAnnotation != null) {
			return Collections.singletonList(metaAnnotation);
		}
		EnableFormErrorConvertation.List list = findAnnotation(EnableFormErrorConvertation.List.class, formInstance);
		if (list != null) {
			return Arrays.asList(list.value());
		}
		throw new IllegalArgumentException("metaAnnotation not found for formInstance: " + formInstance.getClass());
	}

	protected <T extends Annotation> T findAnnotation(Class<T> annotationClass, Object formInstance) {
		if (formInstance instanceof Iterable<?>) {
			formInstance = ((Iterable<?>) formInstance).iterator().next();
		}
		return AnnotationUtils.findAnnotation(formInstance.getClass(), annotationClass);
	}

	protected String getCodeForAnnotation(Annotation validationAnnotation) {
		return validationAnnotation.annotationType().getSimpleName();
	}

	protected void createFieldErrorForErrorCode(EnableFormErrorConvertation metaAnnotation, FieldError fieldError, Object formInstance, BindingResult bindingResult) {
		String fieldName = metaAnnotation.fieldReference();
		String formName = metaAnnotation.formName();
		Object value = DataUtil.readProperty(fieldError.getRejectedValue(), fieldName);
		bindingResult.addError(new FieldError(formName, fieldError.getField() + "." + fieldName, value, false, fieldError.getCodes(), fieldError.getArguments(), fieldError.getDefaultMessage()));
	}

	protected void createFieldErrorForErrorCode(EnableFormErrorConvertation metaAnnotation, ObjectError objectError, Object formInstance, BindingResult bindingResult) {
		String fieldName = metaAnnotation.fieldReference();
		String formName = metaAnnotation.formName();
		Object value = formInstance instanceof Iterable<?> ? null : DataUtil.readProperty(formInstance, fieldName);
		bindingResult.addError(new FieldError(formName, fieldName, value, false, objectError.getCodes(), objectError.getArguments(), objectError.getDefaultMessage()));
	}
}
