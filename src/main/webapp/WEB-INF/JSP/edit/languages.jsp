<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="druzi" 	tagdir="/WEB-INF/tags"%>

<druzi:edit-tab-header selected="languages"/>

<div class="panel panel-default">
	<div class="panel-body">
		<h4 class="data-header">Уровни владения иностранными языками</h4>
		<hr />
		<druzi:form-display-error-if-invalid formName="languageForm" />
		<form:form action="/edit/languages" method="post" commandName="languageForm">
			<sec:csrfInput/>
			<div id="ui-block-container" class="edit-languages">
				<c:forEach var="language" items="${languageForm.items}" varStatus="status">
					<druzi:edit-language-block index="${status.index}" language="${language }" />
				</c:forEach>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<a href="javascript:druzi.ui.addBlock();">+ Добавить язык</a>
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
	<druzi:edit-language-block index="{{blockIndex}}" />
</script>