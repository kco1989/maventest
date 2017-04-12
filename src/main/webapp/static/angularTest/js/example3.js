/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp',[])
    .controller('FirstController', function ($scope) {
        $scope.counter = 0;
        $scope.add = function (count) {
            $scope.counter += count;
        };

        $scope.$root.subtract = function (count) {
            $scope.counter -= count;
        };
    });