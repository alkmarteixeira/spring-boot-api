(function () {
    'use strict';

    angular
        .module('app')
        .controller('PessoaJuridicaController', PessoaJuridicaController);

    PessoaJuridicaController.$inject = ['$scope', '$state', 'PessoaJuridicaService'];

    function PessoaJuridicaController($scope, $state, PessoaJuridicaService) {
        var vm = this;
        vm.pessoaJuridica = { representantes: [] };
        vm.imagens = [];
        vm.pesquisarPessoasPorCnpj = pesquisarPessoasPorCnpj;
        vm.validarPessoa = validarPessoa;
        vm.listaPessoas = [];
        vm.buscaRealizada = false;
        vm.isValidacaoCadastro = false;
        vm.urlValidacaoCadastro = "views/pessoa-juridica/PessoaJuridicaValidation.html";
        vm.voltarParaTelaPesquisa = voltarParaTelaPesquisa;
        vm.atribuirImagensGaleria = atribuirImagensGaleria;
        vm.imagemSelecionada = null;
        vm.tamanhoFullImg = 50;
        vm.mostrarImagem = mostrarImagem;
        $scope.$state = $state;

        function mostrarImagem (ev, imagem, index) {
            vm.imagemSelecionada = imagem.src;
        };

        function pesquisarPessoasPorCnpj() {
            PessoaJuridicaService.pesquisarPessoasPorCnpj(vm.cnpj).then(function (response) {
                var result = response.data.data;
                if (response.status == 200) {
                    if (result.totalElements > 0) {
                        vm.listaPessoas = result.content;
                    }
                } else {
                    angular.forEach(result.data.errors, function (a) {
                        show(a, 'danger')
                    });
                }
                vm.buscaRealizada = true;
            });
        };

        function validarPessoa(pessoaId) {
            PessoaJuridicaService.getPessoa(pessoaId).then(function (response) {
                vm.pessoaJuridica = response.data.data;
                // vm.atribuirImagensGaleria(vm.pessoaJuridica);
                vm.isValidacaoCadastro = true;
            });
        };

        function atribuirImagensGaleria(pessoa){
            if (pessoa.imagemDocumento != undefined && pessoa.imagemDocumento != "" && pessoa.imagemDocumento.length > 0) {
                angular.forEach(pessoa.imagemDocumento, function (value, key) {
                    vm.imagens.push({ src: value });
                });
            }
            if (pessoa.imagemFicha != undefined && pessoa.imagemFicha != "" && pessoa.imagemFicha.length > 0) {
                angular.forEach(pessoa.imagemFicha, function (value, key) {
                    vm.imagens.push({ src: value });
                })
            }
        };

        function voltarParaTelaPesquisa() {
            vm.isValidacaoCadastro = false;
        };

        function show(msg, type) {
            $.notify({
                message: msg
            }, { type: type, offset: { y: 70, x: 20 }, timer: 5000 })
        };
    }
}());