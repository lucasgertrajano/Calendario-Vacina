package calendario.vacina.ufpb;

import java.util.ArrayList;
import java.util.Date;

public class Bebe{

    private String nome;
    private String sexo;
    private Date dataNascimento;
    private ArrayList<Vacina> vacinasRecomendadas;
    private ArrayList<Vacina> vacinasTomadas;


    public Bebe(String nome, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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


}
