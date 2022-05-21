let app = angular.module('reg', []).config(function ($httpProvider) {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfheader = $("meta[name='_csrf_header']").attr("content");
    $httpProvider.defaults.headers.common["X-CSRF-TOKEN"] = csrftoken;
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(csrfheader, csrftoken);
        xhr.setRequestHeader("X-XSRF-TOKEN", csrftoken);
    });
});

app.controller("RegistrationController", function ($scope, $http) {

    $scope.reg = function () {
        $scope.errorreg = null;
        let name = document.getElementById("name").value;
        let sname = document.getElementById("sname").value;
        let pname = document.getElementById("pname").value;
        let telephone = document.getElementById("login").value;
        let email = document.getElementById("email").value;
        let password = document.getElementById("pass").value;
        let repassword = document.getElementById("repass").value;

        if (password!=repassword){
            $scope.errorreg = "Пароли не совпадают";
        }
        if (password.length < 8 || password.length > 25){
            $scope.errorreg = "Пароль должен содержать от 8 до 25 символов";
        }

        if ($scope.errorreg == null) {
            $http.post('/public/rest/client/registration/' + telephone + '/' + name + '/' + sname + '/' + pname + '/' + email + '/' + password)
                .error(function (data, status, headers, config) {
                    $scope.errorreg = data.message;
                })
        }
    }
})