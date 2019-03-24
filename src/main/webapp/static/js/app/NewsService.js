'use strict';

angular.module('myApp').factory('NewsService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8081/news-management/news/';

    var factory = {
        fetchAllNews: fetchAllNews,
        createNews: createNews,
        updateNews: updateNews,
        /*deleteNews: deleteNews,*/
        deleteNewsList: deleteNewsList
    };

    return factory;

    function fetchAllNews() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching News list');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createNews(news) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateNews(news, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + id, news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    /*function deleteNews(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }*/

    function deleteNewsList(newsRemoveList) {
        var deferred = $q.defer();
        $http.patch(REST_SERVICE_URI, newsRemoveList)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting News list');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);