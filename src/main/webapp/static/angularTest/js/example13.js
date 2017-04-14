/**
 * restrict: E 元素 A 属性 C 类 M 注释
 * Created by pc on 2017/4/12.
 */

angular.module('myApp', [])
    .run(function ($rootScope) {
        $rootScope.rootProperty = "root scope";
    })
    .controller('ParentController', function ($scope) {
        $scope.parentProperty = 'parent scope';
    })
    .controller('ChildController', function ($scope) {
        $scope.childProperty = "child scope";
        $scope.fullSentenceFromChild = "Same $scope: we can access" +
                $scope.rootProperty + " and " +
                $scope.parentProperty + " and " +
                $scope.childProperty;
    })
    .directive('myDirective', function () {
        return{
            restrict: 'A',
            replace: true,
            scope:{
                myUrl: '@',
                myLinkText: '@'
            },
            template: '<a href="{{ myUrl }}">{{ myLinkText }}</a>'
        };
    });