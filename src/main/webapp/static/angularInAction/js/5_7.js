/**
 * Created by pc on 2017/4/16.
 */
angular.module('myApp', ['ngRoute'])
    .controller('controller1', ['$scope', function ($scope) {
        $scope.students = students;
    }])
    .controller('controller2', function ($scope, $routeParams) {
        for (var i = 0; i < students.length; i ++){
            debugger;
            if(students[i].stuId == $routeParams.id){
                $scope.student = students[i];
                break;
            }
        }
    })
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/", {
                controller: 'controller1',
                templateUrl: '../html/5_7_1.html'
            })
            .when('/view/:id',{
                controller: 'controller2',
                templateUrl: '../html/5_7_2.html',
                publicAccess: true
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
var students = [
    {stuId: 1000, name: 'zhang mingming1', sex: 'F', score: 60},
    {stuId: 1001, name: 'zhang mingming2', sex: 'M', score: 70},
    {stuId: 1002, name: 'zhang mingming3', sex: 'F', score: 80},
    {stuId: 1003, name: 'zhang mingming4', sex: 'M', score: 90}
];
