/**
 * Created by pc on 2017/4/12.
 */
/**
 * Created by pc on 2017/4/12.
 */
angular.module('myApp', [])
    .filter('capitalize', function () {
        return function (input) {
            if(input){
                return input[0].toUpperCase() + input.slice(1);
            }
        }
    });
