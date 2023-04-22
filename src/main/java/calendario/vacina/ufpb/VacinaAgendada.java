package calendario.vacina.ufpb;

import java.time.LocalDate;

public class VacinaAgendada {
    private String nomeVacina;
    private LocalDate data;
    private String nomeAgendar;


    public VacinaAgendada(String nomeVacina, LocalDate dataVacina, String nomeAgendar) {
        this.nomeVacina = nomeVacina;
        this.data = dataVacina;
        this.nomeAgendar = nomeAgendar;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
    public String getNomeAgendar() {
        return nomeAgendar;
    }

    public void setNomeAgendar(String nomeAgendar) {
        this.nomeAgendar = nomeAgendar;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}