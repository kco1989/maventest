/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .controller('ParentController', function ($scope) {
        $scope.person = {greeted: false, a: {b:5}};
    })
    .controller("ChildController", function ($scope) {
        debugger;
        $scope.sayHello = function () {
            $scope.person.name = "Ari Lerner";
        }
    });