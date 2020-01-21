(function() {
    'use strict';

    angular
        .module('app')
        .controller('MainController', MainController);

    MainController.$inject = ['$scope', '$state'];

    function MainController($scope, $state) {
        yima.init();

        $scope.login = function () {
            $state.go("dashboard.pessoaFisica");
        }

        $scope.$state = $state;
    }
}());