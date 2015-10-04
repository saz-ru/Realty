<?xml version="1.0" encoding="UTF-8" ?>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, req.contextPath)}"/>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<spring:url value="/resources/js/main.js" var="mainJs"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <sec:csrfMetaTags/>
    <%-- CSS --%>
    <link href="${mainCss}" rel="stylesheet"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="${req.contextPath}/resources/js/html5shiv.js"></script>
    <script src="${req.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body onload="document.loginForm.j_username.focus();">
<%-- Top content --%>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <%-- Title --%>
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>${message}</strong> Login Form</h1>

                    <div class="description">
                        <p>
                            All right reserved &copy;2015 <a href="${baseURL}"><strong>${baseURL}</strong></a>
                        </p>
                    </div>
                </div>
            </div>
            <%-- Login form --%>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>

                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form:form role="form" action="${req.contextPath}/j_spring_security_check" method="POST"
                                   class="login-form" name="loginForm" id="loginForm">
                            <div class="form-group">
                                <label class="sr-only" for="j_username">Username</label>
                                <input type="text" name="j_username" placeholder="Username..."
                                       class="form-username form-control" id="j_username"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="j_password">Password</label>
                                <input type="password" name="j_password" placeholder="Password..."
                                       class="form-password form-control" id="j_password">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form:form>
                    </div>
                </div>
            </div>
            <c:if test="${error == true}">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 help-block">
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        Invalid login or password.
                    </div>
                </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%-- Javascript --%>
<script src="${mainJs}"></script>
<!--[if lt IE 10]>
<script src="${req.contextPath}/resources/js/placeholder.js"></script>
<![endif]-->
</body>
</html>