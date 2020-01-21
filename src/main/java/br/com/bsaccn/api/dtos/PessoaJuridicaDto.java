package br.com.bsaccn.api.dtos;

import br.com.bsaccn.api.model.Cartorio;

public class PessoaJuridicaDto {
	
	private Long id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String observacao;
	private String email;
	private String nuCelular;
	private String nuTelefone;
	private String dataCriacao;
	private String dataRegistro;
	private String dataAlteracao;
	private String numeroFicha;
	private String dataFicha;
	private String enderecoCompleto;
	private String cidadeEndereco;
	private String ufEndereco;
	private String nmCartorio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNuCelular() {
		return nuCelular;
	}
	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}
	public String getNuTelefone() {
		return nuTelefone;
	}
	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getNumeroFicha() {
		return numeroFicha;
	}
	public void setNumeroFicha(String numeroFicha) {
		this.numeroFicha = numeroFicha;
	}
	public String getDataFicha() {
		return dataFicha;
	}
	public void setDataFicha(String dataFicha) {
		this.dataFicha = dataFicha;
	}
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	public String getCidadeEndereco() {
		return cidadeEndereco;
	}
	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}
	public String getUfEndereco() {
		return ufEndereco;
	}
	public void setUfEndereco(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}
	public String getNmCartorio() {
		return nmCartorio;
	}
	public void setNmCartorio(String nmCartorio) {
		this.nmCartorio = nmCartorio;
	}
}
