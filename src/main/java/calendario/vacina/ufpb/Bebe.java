package calendario.vacina.ufpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bebe{

    private String nome;
    private String sexo;
    private int idade;

    private Calendario calendario;





    public Bebe(String nome, String sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.calendario = new Calendario();
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nIdade: " + this.idade + "\n";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bebe bebe = (Bebe) o;
        return idade == bebe.idade && nome.equals(bebe.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
