/**
 * restrict: E 元素 A 属性 C 类 M 注释
 * Created by pc on 2017/4/12.
 */

angular.module('myApp', [])
    .controller('SomeController', function ($scope) {
        $scope.someModel = {
            someValue: 'hello computer'
        };
        $scope.someAction = function () {
            $scope.someModel.someValue = "hello human, from parent";
        }
    })
    .controller('ChildController', function ($scope) {
        $scope.childAction = function () {
            $scope.someModel.someValue = "hello human, from child";
        }
    });