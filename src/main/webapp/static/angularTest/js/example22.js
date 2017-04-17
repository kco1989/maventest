/**
 * Created by pc on 2017/4/16.
 */
angular.module('myApp', ['ngRoute'])
    .controller('MainController', function ($scope) {

    })
    .controller('HomeController', function ($scope) {

    })
    .controller('LoginController', function ($scope) {
        debugger
    })
    .controller('DashboardController', function ($scope, $routeParams, user) {
        $scope.hello = $routeParams;
        $scope.user = user;
    })
    .config(['$routeProvider','$locationProvider', function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'HomeController'
            })
            .when('/login', {
                templateUrl: 'views/login.html',
                controller: 'LoginController'
            })
            .when('/dashboard/:id', {
                templateUrl: 'views/dashboard.html',
                controller: 'DashboardController',
                resolve:{
                    user: function($q, $timeout) {
                        
                        return "hello";
                    }
                }
            })
            .otherwise({
                redirectTo: '/'
            });
        debugger;
        $locationProvider.html5Mode(true);
    }])
;
angular.element(document.getElementsByTagName('head')).append(angular.element('<base href="' + window.location.pathname + '" />'));