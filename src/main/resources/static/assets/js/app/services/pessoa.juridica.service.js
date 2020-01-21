(function () {
    'use strict';

    angular
        .module('app')
        .factory('PessoaJuridicaService', PessoaJuridicaService);

    PessoaJuridicaService.$inject = ['$http', 'urlApi'];

    function PessoaJuridicaService($http, urlApi) {
        var _pesquisarPessoasPorCnpj = function (cnpj) {
            return $http.get(urlApi + '/pessoa-juridica/list/' + cnpj);
        };

        var _getPessoa = function(id) {
            return $http.get(urlApi + '/pessoa-juridica/' + id);
        };

        return {
            pesquisarPessoasPorCnpj: _pesquisarPessoasPorCnpj,
            getPessoa: _getPessoa
        };
    }
})();