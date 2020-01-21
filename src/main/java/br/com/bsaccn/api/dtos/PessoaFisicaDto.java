package br.com.bsaccn.api.dtos;

import java.util.List;

public class PessoaFisicaDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String estadoCivil;
	private String dataNascimento;
	private String profissao;
	private String nacionalidade;
	private String cidadeNaturalidade;
	private String nuTelefone;
	private String nuCelular;
	private String docIdentidade;
	private String docDsSgOrgaoEmissor;
	private String docUfOrgaoEmissor;
	private String docDataEmissao;
	private String numeroFicha;
	private String dataFicha;
	private String mae;
	private String pai;
	private String enderecoCompleto;
	private String cidadeEndereco;
	private String ufEndereco;
	private String email;
	private String observacao;
	private String imagemFoto;
	private List<String> imagemFicha;
	private List<String> imagemDocumento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getCidadeNaturalidade() {
		return cidadeNaturalidade;
	}
	public void setCidadeNaturalidade(String cidadeNaturalidade) {
		this.cidadeNaturalidade = cidadeNaturalidade;
	}
	public String getNuTelefone() {
		return nuTelefone;
	}
	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}
	public String getNuCelular() {
		return nuCelular;
	}
	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}
	public String getDocIdentidade() {
		return docIdentidade;
	}
	public void setDocIdentidade(String docIdentidade) {
		this.docIdentidade = docIdentidade;
	}
	public String getDocDsSgOrgaoEmissor() {
		return docDsSgOrgaoEmissor;
	}
	public void setDocDsSgOrgaoEmissor(String docDsSgOrgaoEmissor) {
		this.docDsSgOrgaoEmissor = docDsSgOrgaoEmissor;
	}
	public String getDocUfOrgaoEmissor() {
		return docUfOrgaoEmissor;
	}
	public void setDocUfOrgaoEmissor(String docUfOrgaoEmissor) {
		this.docUfOrgaoEmissor = docUfOrgaoEmissor;
	}
	public String getDocDataEmissao() {
		return docDataEmissao;
	}
	public void setDocDataEmissao(String docDataEmissao) {
		this.docDataEmissao = docDataEmissao;
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
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getenderecoCompleto() {
		return enderecoCompleto;
	}
	public void setenderecoCompleto(String enderecoCompleto) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getImagemFoto() {
		return imagemFoto;
	}
	public void setImagemFoto(String imagemFoto) {
		this.imagemFoto = imagemFoto;
	}
	public List<String> getImagemFicha() {
		return imagemFicha;
	}
	public void setImagemFicha(List<String> imagemFicha) {
		this.imagemFicha = imagemFicha;
	}
	public List<String> getImagemDocumento() {
		return imagemDocumento;
	}
	public void setImagemDocumento(List<String> imagemDocumento) {
		this.imagemDocumento = imagemDocumento;
	}
}
