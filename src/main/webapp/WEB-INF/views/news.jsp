<!DOCTYPE html>
<html lang="en-US">
<head>
	<meta charset="UTF-8" />
	<title> News management </title>
</head>
<body ng-app="myApp">
<div ng-controller="NewsController as newsCtrl">
	<h1> News management </h1>
	<form ng-submit="newsCtrl.submit()" name="newsForm" method="POST">
	    <input type="hidden" ng-model="newsCtrl.news.id" />
		<table>
            <tr>
				<td>
                    Title:
                </td>
                <td>
                    <input type="text" name="title" ng-model="newsCtrl.news.title" required/>
                    <span ng-show="newsForm.title.$error.required" class="msg-val">Title is required.</span>
				</td>
			</tr>

			<tr>
				<td>
				    Date:
				</td>
				<td>
				    <input type="text" name="date" ng-model="newsCtrl.news.date" required/>
				    <span ng-show="newsForm.date.$error.required" class="msg-val">Date is required.</span>
				</td>
			</tr>

			<tr>
				<%--<td>Brief: </td> <td><input type="text" name="brief" ng-model="newsCtrl.news.brief" required/>--%>
				<td>
				    Brief:
				</td>
				<td>
				    <textarea name="brief" ng-model="newsCtrl.news.brief" required></textarea>
				    <span ng-show="newsForm.brief.$error.required" class="msg-val">Brief is required.</span>
				</td>
			</tr>

			<tr>
			    <%--Content: </td> <td> <input type="text" name="content" ng-model="newsCtrl.news.content" required/>--%>
				<td>
				    Content:
				</td>
				<td>
				    <textarea name="content" ng-model="newsCtrl.news.content" required></textarea>
				    <span ng-show="newsForm.content.$error.required" class="msg-val">Content is required.</span>
				</td>
			</tr>

			<tr>
			    <td colspan="2">
                    <input type="submit" value="{{!newsCtrl.news.id ? 'Add' : 'Update'}}"/>
                    <input type="button" ng-click="newsCtrl.reset()" value="Reset"/>
                </td>
			</tr>
        </table>
	</form>
	<table>
		<tr>
		    <th>ID</th>
		    <th>Title</th>
		    <th>Date</th>
		    <th>Brief</th>
		    <th>Content</th>
		    <th><input type="button" ng-click="newsCtrl.removeNewsList()" value="Delete"/></th>
		</tr>
		<tr ng-repeat="row in newsCtrl.newsList">
			<td><span ng-bind="row.id"></span></td>
			<td><span ng-bind="row.title"></span></td>
			<td><span ng-bind="row.date"></span></td>
			<td><span ng-bind="row.brief"></span></td>
			<td><span ng-bind="row.content"></span></td>
			<td><input name="delete" type="checkbox" ng-model="row.selected"/></td>
			<td>
				<input type="button" ng-click="newsCtrl.edit(row.id)" value="Edit"/>
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
  