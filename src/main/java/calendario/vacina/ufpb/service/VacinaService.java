package calendario.vacina.ufpb.service;

import calendario.vacina.ufpb.Vacina;

import java.util.ArrayList;

public class VacinaService {
    public ArrayList<String> getVacinasPorIdade(int idade) {
        ArrayList<String> vacinas = new ArrayList<String>();

        switch (idade) {
            case 0:
                vacinas.add(Vacina.getVacinas().get(0)); // BCG
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                break;
            case 2:
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                break;
            case 3:
            case 5:
                vacinas.add(Vacina.getVacinas().get(7)); // Meningocócica ACWY
                vacinas.add(Vacina.getVacinas().get(8)); // Meningocócica B
                break;
            case 4:
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                break;
            case 6:
                vacinas.add(Vacina.getVacinas().get(1)); // Hepatite B
                vacinas.add(Vacina.getVacinas().get(2)); // Poliomielite
                vacinas.add(Vacina.getVacinas().get(3)); // Tríplice bacteriana
                vacinas.add(Vacina.getVacinas().get(4)); // Haemophilus
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(6)); // Rotavírus
                vacinas.add(Vacina.getVacinas().get(9)); // Influenza
                break;
            case 9:
                vacinas.add(Vacina.getVacinas().get(10)); // Febre Amarela
                break;
            case 12:
                vacinas.add(Vacina.getVacinas().get(5)); // Pneumocócica 13V
                vacinas.add(Vacina.getVacinas().get(7)); // Meningocócica ACWY
                vacinas.add(Vacina.getVacinas().get(8)); // Meningocócica B
                vacinas.add(Vacina.getVacinas().get(11)); // Tríplice viral
                vacinas.add(Vacina.getVacinas().get(12)); // Varicela
                vacinas.add(Vacina.getVacinas().get(13)); // Hepatite A
                break;
            default:
                break;
        }

        return vacinas;
    }
}

