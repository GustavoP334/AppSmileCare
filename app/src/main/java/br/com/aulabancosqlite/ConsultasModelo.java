package br.com.aulabancosqlite;

public class ConsultasModelo {
    int 	codigo;
    String 	Nome;
    String 	hora;
    String 	data;

    public ConsultasModelo() {
    }

    public ConsultasModelo(int codigo, String Nome, String hora, String data) {
        this.codigo = codigo;
        this.Nome = Nome;
        this.hora = hora;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) { this.hora = hora;}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
