let app = angular.module('client', []).config(function ($httpProvider) {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfheader = $("meta[name='_csrf_header']").attr("content");
    $httpProvider.defaults.headers.common["X-CSRF-TOKEN"] = csrftoken;
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(csrfheader, csrftoken);
        xhr.setRequestHeader("X-XSRF-TOKEN", csrftoken);
    });
});

app.controller("ClientController", function ($scope, $http) {

    $scope.getOrders = function () {
        $http.get('/public/rest/client/mypage/order').success(function (data, status, headers, config) {
            $scope.orders = data;
        });
    };
});