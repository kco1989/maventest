/**
 * Created by pc on 2017/4/16.
 */
angular.module('myApp', ['ngRoute'])
    .controller('controller1', ['$scope', function ($scope) {
        debugger;
        $scope.title = "This is home";
    }])
    .controller('controller2', ['$scope', function ($scope) {
        $scope.title = 'This is book';
    }])
    .controller('controller3', ['$scope', function ($scope) {
        $scope.title = 'This is game';
    }])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            controller: 'controller1',
            template:'<div>{{title}}</div>'
        }).when('/book', {
            controller: 'controller2',
            template:'<div>{{title}}</div>'
        }).when('/game', {
            controller: 'controller3',
            template:'<div>{{title}}</div>'
        }).otherwise({
            redirectTo: '/'
        })
    }])