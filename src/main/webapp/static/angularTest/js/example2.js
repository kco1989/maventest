/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .controller('MyController', function ($scope) {
        $scope.$root.name = "good";
        $scope.name = "World";
    });
