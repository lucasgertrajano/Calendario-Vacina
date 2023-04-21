package calendario.vacina.ufpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bebe{

    private String nome;
    private String sexo;
    private int idade;
    private ArrayList<Vacina> vacinasRecomendadas;
    private ArrayList<Vacina> vacinasTomadas;
    private ArrayList<Bebe> bebes;



    public Bebe(String nome, String sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.vacinasRecomendadas = new ArrayList<Vacina>();
        this.vacinasTomadas = new ArrayList<Vacina>();
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

    public ArrayList<Vacina> getVacinasRecomendadas() {
        return vacinasRecomendadas;
    }

    public void setVacinasRecomendadas(ArrayList<Vacina> vacinasRecomendadas) {
        this.vacinasRecomendadas = vacinasRecomendadas;
    }

    public ArrayList<Vacina> getVacinasTomadas() {
        return vacinasTomadas;
    }

    public void setVacinasTomadas(ArrayList<Vacina> vacinasTomadas) {
        this.vacinasTomadas = vacinasTomadas;
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
