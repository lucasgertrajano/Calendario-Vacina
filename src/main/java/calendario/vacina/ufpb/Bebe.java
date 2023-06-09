package calendario.vacina.ufpb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bebe{

    private String nome;
    private String sexo;
    private Integer idade;

    private ArrayList<VacinaAgendada> vacinasAgendadas = new ArrayList<>();


    public Bebe(String nome, String sexo, Integer idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Bebe(String nome, String sexo, Integer idade, ArrayList<VacinaAgendada> vacinasAgendadas){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.vacinasAgendadas = vacinasAgendadas;
    }

    public Bebe(String nomeVacina, String nomeVacina2) {
    }


    public ArrayList<VacinaAgendada> getVacinasAgendadas() {
        return vacinasAgendadas;
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

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public StringBuilder listaVacinasAgendadas(){
        StringBuilder stringBuilder = new StringBuilder();
        if (this.vacinasAgendadas.size() == 0) {
            stringBuilder.append("Não há nenhuma vacina Agendada para este bebê");
            return stringBuilder;
        }
        for (VacinaAgendada vacinaAgendada: vacinasAgendadas){
            stringBuilder.append(vacinaAgendada.getNomeVacina()).append("\n");
        }
        return stringBuilder;
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