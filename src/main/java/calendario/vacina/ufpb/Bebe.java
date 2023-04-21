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
    private LocalDate dataNascimento;
    private Calendario calendario;


    public Bebe(String nome, String sexo, LocalDate dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.calendario = new Calendario();
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nIdade: " + this.dataNascimento + "\n";
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Calendario getCalendario() {
        return calendario;
    }
    public int calcularIdadeEmMeses() {
        LocalDate hoje = LocalDate.now();
        long meses = ChronoUnit.MONTHS.between(dataNascimento, hoje);
        return (int) meses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bebe bebe = (Bebe) o;
        return dataNascimento == bebe.dataNascimento && nome.equals(bebe.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento);
    }
}
