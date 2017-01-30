<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="druzi" 	tagdir="/WEB-INF/tags"%>

<druzi:edit-tab-header selected="certificates" />

<div class="panel panel-default certificates">
	<div class="panel-body">
		<h4 class="data-header">Сертификаты</h4>
		<hr />
		<druzi:form-display-error-if-invalid formName="certificateForm" />
		<form:errors path="*"/>
		<form:form action="/edit/certificates" method="post" commandName="certificateForm">
			<sec:csrfInput/>
			<div id="ui-block-container">
				<c:forEach var="certificate" items="${certificateForm.items }" varStatus="status">
					<druzi:edit-certificate-block index="${status.index }" id="${certificate.id }"
								largeUrl="${certificate.largeUrl }" smallUrl="${certificate.smallUrl }" name="${certificate.name }" />
				</c:forEach>
			</div>
			<hr />
			<div class="row">
				<div class="col-xs-12">
					<a href="javascript:druzi.certificates.showUploadDialog();">+ Добавить сертификат</a>
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
	<druzi:edit-certificate-block index="{{blockIndex}}" largeUrl="{{largeUrl}}" smallUrl="{{smallUrl}}" name="{{name}}" />
</script>
<druzi:certificate-viewer />
<druzi:certificate-uploader />

<content tag="js-init"> 
<script>
$(document).ready(function() {
	druzi.initCertificateViewer();
	druzi.createCertificateUploader('${_csrf.token}');
});
</script> 
</content>