package calendario.vacina.ufpb.service;

import calendario.vacina.ufpb.Bebe;
import calendario.vacina.ufpb.GravadorDeArquivos;
import calendario.vacina.ufpb.VacinaAgendada;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BebeService {
    private Bebe bebe;
    private ArrayList<Bebe> bebes;


    private GravadorDeArquivos gravadorBebe;

    private GravadorDeArquivos gravadorDeVacinasAgendadas;

    public BebeService() {
        this.bebes = new ArrayList<Bebe>();
        this.gravadorBebe = new GravadorDeArquivos("Bebes");
        this.gravadorDeVacinasAgendadas = new GravadorDeArquivos("Vacinas");
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

    public void salvarDados() throws IOException {
        List<String> listaBebes = new ArrayList<String>();
        List<String> listaVacinas = new ArrayList<String>();

        for (Bebe bebe : this.bebes) {
            String addBebe = bebe.getNome() + "###" + bebe.getSexo() + "###" + bebe.getIdade();
            listaBebes.add(addBebe);
            for (int i = 0 ; i < bebe.getVacinasAgendadas().size(); i++){
                String addVacina = bebe.getVacinasAgendadas().get(i).getNomeVacina() + "###" +
                        bebe.getVacinasAgendadas().get(i).getData() + "###" + bebe.getVacinasAgendadas().get(i).getNomeBebe();
                listaVacinas.add(addVacina);
            }
        }
        gravadorBebe.gravarTextoEmArquivo(listaBebes);
        gravadorDeVacinasAgendadas.gravarTextoEmArquivo(listaVacinas);
    }

    public void recuperarDados() throws IOException {
        List<String> listaBebes = gravadorBebe.recuperaDadosDeTexto();
        List<String> listaVacinas = gravadorDeVacinasAgendadas.recuperaDadosDeTexto();

        for (String listaBebe : listaBebes) {
            String[] arrayBebe = listaBebe.split("###");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                Bebe bebeRecuperado = new Bebe(arrayBebe[0], arrayBebe[1], Integer.parseInt(arrayBebe[2]));
                for (String listaVacina : listaVacinas) {
                    String[] arrayVacina = listaVacina.split("###");
                    LocalDate data = LocalDate.parse(arrayVacina[1], formatter);
                    VacinaAgendada vacinaAgendada = new VacinaAgendada(arrayVacina[0], data, arrayVacina[2]);
                    if (vacinaAgendada.getNomeBebe().equals(bebeRecuperado.getNome())) {
                        bebeRecuperado.getVacinasAgendadas().add(vacinaAgendada);
                    }
                }
                bebes.add(bebeRecuperado);
            } catch (NumberFormatException e) {
                System.out.println("Erro na recuperação dos dados: " + e.getMessage());
            }
        }
    }

    public ArrayList<Bebe> getBebes() {
        return bebes;
    }

    public boolean agendarVacina(String nome, String vacina, LocalDate data) {
        Bebe bebe = pesquisarPeloNome(nome);
        if (bebe != null) {
            // bebe.agendarVacina(vacina, data);
            return true;
        }
        return false;
    }

    public void agendarVacina(Bebe bebeAgendar, VacinaAgendada vacinacao) {
    }
}
