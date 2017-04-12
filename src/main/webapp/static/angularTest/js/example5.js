/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .controller('MyController', function ($scope, $parse) {
        $scope.$watch('expr', function (newValue, oldValue, scope) {
            if(newValue !== oldValue){
                debugger;
                var parseFun = $parse(newValue);
                $scope.parseValue = parseFun(scope);
            }
        })
    })
