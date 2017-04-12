/**
 * Created by pc on 2017/4/12.
 */
/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .controller('DemoController', ['$scope', '$filter',function ($scope, $filter) {
        debugger;
        $scope.$watch('fristName', function (value) {
            $scope.fristNameLowerCase = $filter('lowercase')(value);
        });
        $scope.today = new Date();
    }]);
