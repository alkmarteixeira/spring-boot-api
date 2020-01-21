(function() {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state'];

    function HomeController($scope, $state) {
        // yimaHome.init();
        $scope.$state = $state;
        $scope.hasFullContainer = true;
    }
}());