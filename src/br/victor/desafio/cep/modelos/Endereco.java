package br.victor.desafio.cep.modelos;

public class Endereco implements Comparable <Endereco> {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(EnderecoViaCep meuEnderecoViaCep){
        this.cep = meuEnderecoViaCep.cep();
        this.logradouro = meuEnderecoViaCep.logradouro();
        this.bairro = meuEnderecoViaCep.bairro();
        this.cidade = meuEnderecoViaCep.localidade();
        this.estado = meuEnderecoViaCep.uf();

    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco" + "("+ "Cep: " + cep +
                " Logradouro: " + logradouro +
                " Nª: " + numero + " Complemento: " + complemento +
                " Bairro: " + bairro + " Cidade: " + cidade +
                " UF: " + estado + ")";

    }

    @Override
    public int compareTo(Endereco outroEndereco) {
        return this.getCep().compareTo(outroEndereco.getCep());
    }
}