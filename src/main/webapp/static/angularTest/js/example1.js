/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .run(function ($rootScope) {
        $rootScope.name = "World";
        this.name = "w";
    });
