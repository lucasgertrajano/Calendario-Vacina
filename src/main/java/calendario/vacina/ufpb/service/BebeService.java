package calendario.vacina.ufpb.service;

import calendario.vacina.ufpb.Bebe;
import calendario.vacina.ufpb.Vacina;

import java.util.ArrayList;

public class BebeService {
    private ArrayList<Bebe> bebes;


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
