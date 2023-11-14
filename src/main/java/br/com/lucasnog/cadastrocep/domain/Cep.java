package br.com.lucasnog.cadastrocep.domain;

public class Cep {

    private Integer numero;
    private String rua;
    private String cidade;
    private String estado;

    public Cep(Integer numero, String rua, String cidade, String estado) {
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  " { rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public Integer getNumero() {
        return numero;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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
}
