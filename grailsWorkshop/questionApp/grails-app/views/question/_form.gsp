<%@ page import="com.opi.Question" %>

  <div class="form-group ${hasErrors(bean: question, field: 'title', 'has_error')}">
    <label for="title" class="col-sm-2 control-label"><g:message code="question.title.label" default="Title" /><span class="required-indicator">*</span></label>
    <div class="col-sm-10">
      <g:textField name="title" class="form-control" id="title" placeholder="Title" value="${question?.title}"/>
    </div>
  </div>

  <div class="form-group ${hasErrors(bean: questionInstance, field: 'text', 'has_error')}">
    <label for="title" class="col-sm-2 control-label"><g:message code="question.text.label" default="Question" /><span class="required-indicator">*</span></label>
    <div class="col-sm-10">
      <g:textArea name="text" class="form-control" id="title" placeholder="Question" value="${question?.text}"/>
    </div>
  </div>

  <div class="form-group ${hasErrors(bean: question, field: 'user', 'has_error')}">
    <label for="user" class="col-sm-2 control-label"><g:message code="question.user.label" default="User" /><span class="required-indicator">*</span></label>
    <div class="col-sm-10">
      <g:select id="user" class="form-control" name="user.id" from="${com.opi.User.list()}" optionKey="id" required="" value="${question?.user?.id}"/>
    </div>
  </div>
