package calendario.vacina.ufpb;

import java.time.LocalDate;

public class VacinaAgendada {
    private String nomeVacina;
    private LocalDate data;

    public VacinaAgendada(String nomeVacina, LocalDate dataVacina) {
        this.nomeVacina = nomeVacina;
        this.data = dataVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}