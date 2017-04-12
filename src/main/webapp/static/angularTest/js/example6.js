/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .controller('MyController', function ($scope, $interpolate) {
        debugger;
        $scope.$watch('emailBody', function (body) {
            if(body){
                var template = $interpolate(body);
                $scope.previewText = template({
                    to: $scope.to
                })
            }
        })
    })
