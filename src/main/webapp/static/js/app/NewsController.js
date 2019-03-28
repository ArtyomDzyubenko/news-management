'use strict';
 
angular.module('myApp').controller('NewsController', ['$scope', 'NewsService', function($scope, NewsService) {
    var self = this;

    self.news={id:null, title:'', date:'', brief:'', content:'', selected:false};
    self.newsList=[];

    self.submit = submit;
    self.edit = edit;
    self.reset = reset;
    self.removeNewsList = removeNewsList;
 
    fetchAllNews();
 
    function fetchAllNews(){
        NewsService.fetchAllNews()
            .then(
            function(d) {
                self.newsList = d;
            },
            function(errResponse){
                console.error('Error while fetching News list');
            }
        );
    }
 
    function createNews(news){
        NewsService.createNews(news)
            .then(
            fetchAllNews,
            function(errResponse){
                console.error('Error while creating News');
            }
        );
    }
 
    function updateNews(news, id){
        NewsService.updateNews(news, id)
            .then(
            fetchAllNews,
            function(errResponse){
                console.error('Error while updating News');
            }
        );
    }

    function submit() {
        if(self.news.id === null){
            console.log('Saving New News', self.news);
            createNews(self.news);
        }else{
            updateNews(self.news, self.news.id);
            console.log('News updated with id ', self.news.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.newsList.length; i++){
            if(self.newsList[i].id === id) {
                self.news = angular.copy(self.newsList[i]);
                break;
            }
        }
    }
 
    function removeNewsList(){
        var selectedIds = [];

        angular.forEach(self.newsList, function (news) {
            if (news.selected) {
                selectedIds.push(news.id);
            }
        });

        console.log('News list to be deleted', selectedIds);

        NewsService.deleteNewsList(selectedIds)
            .then(
            fetchAllNews,
            function(errResponse){
                console.error('Error while deleting News list');
            }
        );
    }

    function reset(){
        self.news={id:null, title:'', date:new Date(), brief:'', content:'', selected:false};
        $scope.newsForm.$setPristine();
    }
}]);