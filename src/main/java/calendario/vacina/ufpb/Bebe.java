package calendario.vacina.ufpb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Bebe{

    private String nome;
    private String sexo;
    private Integer idade;
    private Calendario calendario;


    public Bebe(String nome, String sexo, Integer idade) {
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

    public void setIdade(Integer idade) {
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

    public ArrayList<String> getVacinasPorIdade(int idade) {
        ArrayList<String> vacinas = new ArrayList<String>();

        switch (idade) {
            case 0:
                vacinas.add(Vacina.getVacinas().get(0)); // BCG
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                break;
            case 2:
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                break;
            case 3:
            case 5:
                vacinas.add(Vacina.getVacinas().get(7)); // Meningocócica ACWY
                vacinas.add(Vacina.getVacinas().get(8)); // Meningocócica B
                break;
            case 4:
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                break;
            case 6:
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                vacinas.add(Vacina.getVacinas().get(9)); // Influenza
                break;
            case 9:
                vacinas.add(Vacina.getVacinas().get(10)); // Febre Amarela
                break;
            case 12:
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(7)); // Meningocócica ACWY
                vacinas.add(Vacina.getVacinas().get(8)); // Meningocócica B
                vacinas.add(Vacina.getVacinas().get(11)); // Tríplice viral
                vacinas.add(Vacina.getVacinas().get(12)); // Varicela
                vacinas.add(Vacina.getVacinas().get(13)); // Hepatite A
                break;
            default:
                break;
        }

        return vacinas;
    }
    }

