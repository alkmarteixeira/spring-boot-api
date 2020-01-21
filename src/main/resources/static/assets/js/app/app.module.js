(function() {
    'use strict';

    angular
        .module('app', [
            'ui.bootstrap',
            'ui.router',
            'oc.lazyLoad',
            'ncy-angular-breadcrumb',
            'ui.utils.masks'
        ])    
        .constant('urlApi','http://localhost:8080/api')
        // .constant('urlApi','https://services.centraldut.com.br/Api');
}());