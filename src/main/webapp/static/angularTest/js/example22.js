/**
 * Created by pc on 2017/4/16.
 */
angular.module('myApp', ['ngRoute'])
    .controller('MainController', function ($scope) {

    })
    .controller('HomeController', function ($scope) {

    })
    .controller('LoginController', function ($scope) {

    })
    .controller('DashboardController', function ($scope) {

    })
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'HomeController'
            })
            .when('/login', {
                templateUrl: 'login.html',
                controller: 'LoginController'
            })
            .when('/dashboard', {
                templateUrl: 'views/dashboard.html',
                controller: 'DashboardController',
                resolve:{
                    user: function (SessionService) {
                        return SessionService.getCurrentUser();
                    }
                }
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }])
;
angular.element(document.getElementsByTagName('head')).append(angular.element('<base href="' + window.location.pathname + '" />'));