(function () {
    'use strict';

    angular
        .module('app')
        .factory('PessoaFisicaService', PessoaFisicaService);

    PessoaFisicaService.$inject = ['$http', 'urlApi'];

    function PessoaFisicaService($http, urlApi) {
        var _pesquisarPessoasPorCpf = function (Cpf) {
            return $http.get(urlApi + '/pessoa-fisica/list/' + Cpf);
        };

        var _getPessoa = function(id) {
            return $http.get(urlApi + '/pessoa-fisica/' + id);
        };

        return {
            pesquisarPessoasPorCpf: _pesquisarPessoasPorCpf,
            getPessoa: _getPessoa
        };
    }
})();