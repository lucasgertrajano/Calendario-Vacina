package calendario.vacina.ufpb;

import java.util.ArrayList;

public class Calendario {

    private ArrayList<Vacina> vacinasRecomendadas;
    private ArrayList<Vacina> vacinasTomadas;

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
