<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, req.contextPath)}"/>
<spring:url value="/resources/css/default.css" var="defaultCss"/>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<spring:url value="/resources/js/default.js" var="defaultJs"/>
<spring:url value="/resources/js/main.js" var="mainJs"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%-- CSS --%>
    <link href="${defaultCss}" rel="stylesheet"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <title>Dashboard</title>

</head>
<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">

        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg dashbard-1">

    </div>
</div>
<%-- Javascript --%>
<script src="${defaultJs}"></script>
<script src="${mainJs}"></script>
</body>
</html>