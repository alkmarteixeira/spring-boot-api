(function () {
    'use strict';

    angular
        .module('app')
        .controller('PessoaFisicaController', PessoaFisicaController);

    PessoaFisicaController.$inject = ['$scope', '$state', 'PessoaFisicaService'];

    function PessoaFisicaController($scope, $state, PessoaFisicaService) {
        var vm = this;
        vm.pessoa = {pathFoto: ""};
        vm.imagens = [];
        vm.pesquisarPessoasPorCpf = pesquisarPessoasPorCpf;
        vm.validarPessoa = validarPessoa;
        vm.listaPessoas = [];
        vm.buscaRealizada = false;
        vm.isValidacaoCadastro = false;
        vm.urlValidacaoCadastro = "views/pessoa-fisica/PessoaFisicaValidation.html";
        vm.voltarParaTelaPesquisa = voltarParaTelaPesquisa;
        vm.atribuirImagensGaleria = atribuirImagensGaleria;
        vm.imagemSelecionada = null;
        vm.tamanhoFullImg = 50;
        vm.mostrarImagem = mostrarImagem;
        $scope.$state = $state;

        function mostrarImagem (ev, imagem, index) {
            vm.imagemSelecionada = imagem.src;
        };

        function pesquisarPessoasPorCpf() {
            PessoaFisicaService.pesquisarPessoasPorCpf(vm.cpf).then(function (response) {
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
            PessoaFisicaService.getPessoa(pessoaId).then(function (response) {
                vm.pessoa = response.data.data;
                vm.atribuirImagensGaleria(vm.pessoa);
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