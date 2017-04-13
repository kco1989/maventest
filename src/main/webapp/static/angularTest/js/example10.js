/**
 * Created by pc on 2017/4/12.
 */
/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .directive('ensureUnique', function () {
        return {
            require: 'ngModel',
            link: function (scope, ele, attrs, c) {
                scope.$watch(attrs.ngModel, function (n) {
                    if(!n) return;
                    $http({
                        method: 'POST',
                        url: '/api/check' + attrs.ensureUnique,
                        data:{
                            field: attrs.ensureUnique,
                            value: scope.ngModel
                        }
                    }).success(function (data) {
                        c.$setValidity('unique', data.isUnique);
                    }).error(function (data) {
                        c.$setValidity('unique', false);
                    })
                })
            }
        };
    });