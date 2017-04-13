/**
 * restrict: E 元素 A 属性 C 类 M 注释
 * Created by pc on 2017/4/12.
 */

angular.module('myApp', [])
    .directive('myDirective', function () {
        return{
            restrict: 'E',
            template: '<a href="http://baidu.com">baidu</a>'
        }
    })
    .directive('myDirective2', function () {
        return{
            restrict: 'E',
            template: '<a href="http://baidu.com">baidu2</a>',
            replace: true
        }
    })
    .directive('myDirective3', function () {
        return {
            restrict: 'EAC',
            template: '<a href="http://baidu.com">baidu3</a>',
            replace: true
        }
    });