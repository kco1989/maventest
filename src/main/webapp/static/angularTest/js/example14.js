/**
 * restrict: E 元素 A 属性 C 类 M 注释
 * Created by pc on 2017/4/12.
 */

angular.module('myApp', [])
    .run(function ($rootScope, $timeout) {
        $rootScope.isDisabled = true;
        $timeout(function () {
            $rootScope.isDisabled = false;
            $rootScope.myHref = 'http://baidu.com';
            $rootScope.imgSrc = 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492863278&di=e383cd999bb3505b5cbfa1c7b0364ee7&imgtype=jpg&er=1&src=http%3A%2F%2Fs6.sinaimg.cn%2Fmiddle%2F4a16c770h963cc80d1a25%26amp%3B690%26amp%3B690';
        }, 5000);

    })
    ;