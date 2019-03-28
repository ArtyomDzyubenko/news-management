<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body ng-app="myApp">
<div ng-controller="NewsController as newsCtrl">
    <div>
        <h1><spring:message code="app.title"/></h1>
    </div>

    <div>
        <a href='?lang=en'><spring:message code="app.lang.en"/></a> | <a href='?lang=ru'><spring:message code="app.lang.ru"/></a>
    </div>

    <div>
        <h2><spring:message code="app.welcome"/>${who}</h2>

        <form action='<spring:url value="/logout"/>' method="post">
            <input value="<spring:message code="app.news.button.logout"/>" type="submit">
        </form>
    </div>

    <div>
        <h3><spring:message code="app.news.form.add"/></h3>
    </div>

    <form ng-submit="newsCtrl.submit()" name="newsForm" method="POST">
        <input type="hidden" ng-model="newsCtrl.news.id" />
        <table>
            <tr>
                <td>
                    <spring:message code="app.news.title"/>
                </td>
                <td>
                    <input type="text" name="title" ng-model="newsCtrl.news.title" size="98" min="3" max="100" required/>
                    <span ng-show="newsForm.title.$error.required" class="msg-val"><spring:message code="app.news.validation.title"/></span>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="app.news.date"/>
                </td>
                <td>
                    <input type="text" name="date" ng-model="newsCtrl.news.date" size="10" pattern="^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$" placeholder="2000-12-31" required/>
                    <span ng-show="newsForm.date.$error.required" class="msg-val"><spring:message code="app.news.validation.date"/></span>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="app.news.brief"/>
                </td>
                <td>
                    <textarea name="brief" ng-model="newsCtrl.news.brief" rows="4" cols="100" minlength="3" maxlength="500" required></textarea>
                    <span ng-show="newsForm.brief.$error.required" class="msg-val"><spring:message code="app.news.validation.brief"/></span>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="app.news.content"/>
                </td>
                <td>
                    <textarea name="content" ng-model="newsCtrl.news.content" rows="10" cols="100" minlength="3" maxlength="2048" required></textarea>
                    <span ng-show="newsForm.content.$error.required" class="msg-val"><spring:message code="app.news.validation.content"/></span>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="{{!newsCtrl.news.id ? '<spring:message code="app.news.button.add"/>' : '<spring:message code="app.news.button.update"/>'}}"/>
                    <input type="button" ng-click="newsCtrl.reset()" value="<spring:message code="app.news.button.reset"/>"/>
                </td>
            </tr>
        </table>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th><spring:message code="app.news.title"/></th>
            <th><spring:message code="app.news.date"/></th>
            <th><spring:message code="app.news.brief"/></th>
            <th><spring:message code="app.news.content"/></th>
            <th><input type="button" ng-click="newsCtrl.removeNewsList()" value="<spring:message code="app.news.button.delete"/>"/></th>
        </tr>
        <tr ng-repeat="row in newsCtrl.newsList">
            <td><span ng-bind="row.id"></span></td>
            <td><span ng-bind="row.title"></span></td>
            <td><span ng-bind="row.date"></span></td>
            <td><span ng-bind="row.brief"></span></td>
            <td><span ng-bind="row.content"></span></td>
            <td><input name="delete" type="checkbox" ng-model="row.selected"/></td>
            <td>
                <input type="button" ng-click="newsCtrl.edit(row.id)" value="<spring:message code="app.news.button.edit"/>"/>
            </td>
        </tr>
    </table>
</div>
<script src="${pageContext.request.contextPath}/static/js/lib/angular.js"></script>
<script src="${pageContext.request.contextPath}/static/js/app/app.js"></script>
<script src="${pageContext.request.contextPath}/static/js/app/NewsService.js"></script>
<script src="${pageContext.request.contextPath}/static/js/app/NewsController.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
</body>
</html>  
  