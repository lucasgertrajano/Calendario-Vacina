package calendario.vacina.ufpb;

import java.util.ArrayList;
import java.util.List;

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

    public boolean cadastrarBebe(Bebe bebe){
        for(Bebe b : this.bebes) {
            if(b.equals(bebe)) {
                return false;
            }
        }
        this.bebes.add(bebe);
        return true;
    }
    public boolean removerBebe(Bebe bebe){
        for(Bebe b : this.bebes) {
            if(b.equals(bebe)) {
                return false;
            }
        }
        this.bebes.remove(bebe);
        return true;
    }
    public Bebe pesquisarPeloNome(String nome) {
        for( Bebe b: this.bebes) {
            if(b.getNome().equals(nome)) {
                return b;
            }
        }
        return null;
    }
    public boolean alterarBebe(String nome, Bebe novoBebe){
        for (int i = 0; i < this.bebes.size(); i++){
            if (this.bebes.get(i).getNome().equals(nome)){
                this.bebes.set(i, novoBebe);
                return true;
            }
        }
        return false;
    }

}
