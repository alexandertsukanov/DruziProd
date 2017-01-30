<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="druzi" 	tagdir="/WEB-INF/tags"%>

<druzi:edit-tab-header selected="education" />

<div class="panel panel-default">
	<div class="panel-body">
		<h4 class="data-header">Образование</h4>
		<h6 class="text-center help-block">(Упорядоченные по убыванию)</h6>
		<hr />
		<druzi:form-display-error-if-invalid formName="educationForm" />
		<form:form action="/edit/education" method="post" commandName="educationForm">
			<sec:csrfInput/>
			<div id="ui-block-container">
				<c:forEach var="education" items="${educationForm.items }" varStatus="status">
					<druzi:edit-education-block index="${status.index}" education="${education }" />
				</c:forEach>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<a href="javascript:druzi.ui.addBlock();">+ Добавить учереждение</a>
				</div>
			</div>
			<hr />
			<div class="row">
				<div class="col-xs-12 text-center">
					<input type="submit" class="btn btn-primary" value="Сохранить">
				</div>
			</div>
		</form:form>
	</div>
</div>
<script id="ui-block-template" type="text/x-handlebars-template">
	<druzi:edit-education-block index="{{blockIndex}}" />
</script>