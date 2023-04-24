package calendario.vacina.ufpb;

import java.time.LocalDate;

public class VacinaAgendada {
    private String nomeVacina;
    private LocalDate data;
    private String nomeBebe;


    public VacinaAgendada(String nomeVacina, LocalDate dataVacina, String nomeBebe) {
        this.nomeVacina = nomeVacina;
        this.data = dataVacina;
        this.nomeBebe = nomeBebe;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
    public String getNomeBebe() {
        return nomeBebe;
    }

    public void setNomeBebe(String nomeBebe) {
        this.nomeBebe = nomeBebe;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}