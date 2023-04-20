package calendario.vacina.ufpb;
import java.util.ArrayList;

public class Vacina {
    private static ArrayList<String> vacinas = new ArrayList<String>();

    static {

        vacinas.add("BCG");                     //0 meses
        vacinas.add("Hepatite B");              //0, 2 e 6 meses
        vacinas.add("Poliomielite");            //2, 4 e 6 meses
        vacinas.add("Tríplice bacteriana");     //2, 4 e 6 meses
        vacinas.add("Pneumocócica 13V");        //2, 4, 6 e 12 meses
        vacinas.add("Rotavírus");               //2, 4 e 6 meses
        vacinas.add("Meningocócica ACWY");      //3, 5 e 12 meses
        vacinas.add("Meningocócica B");         //3, 5 e 12 meses
        vacinas.add("Influenza"); //VERIFICAR
        vacinas.add("Febre Amarela");           //9 meses
        vacinas.add("Tríplice viral");          //12 meses
        vacinas.add("Varicela");                //12 meses
        vacinas.add("Hepatite A");              //12 meses
    }

    public static ArrayList<String> getVacinas() {
        return vacinas;
    }
}