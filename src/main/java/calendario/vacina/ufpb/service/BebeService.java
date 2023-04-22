package calendario.vacina.ufpb.service;

import calendario.vacina.ufpb.Bebe;
import java.util.ArrayList;

public class BebeService {
    private Bebe bebe;
    private ArrayList<Bebe> bebes = new ArrayList<Bebe>();

    public BebeService() {
    }

    public Bebe cadastrarBebe(Bebe bebe){
        this.bebes.add(bebe);
        return bebe;
    }
    public void removerBebe(String nome){
        for(Bebe b: this.bebes) {
            if(b.getNome().equals(nome)) {
                this.bebes.remove(b);
            }
        }
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

    public StringBuilder listarBebes(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Bebe bebe: this.bebes){
            stringBuilder.append(bebe.toString());
        }
        return stringBuilder;
    }
}