package calendario.vacina.ufpb;

import calendario.vacina.ufpb.service.BebeService;
import calendario.vacina.ufpb.service.VacinaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BebeService bebeService = new BebeService();
        VacinaService vacinaService = new VacinaService();

        System.out.println("Sistema Calendário de Vacina\n");

        System.out.println(
                 "Escolha uma opção:"
                + "\n 1.Cadastrar bebê"
                + "\n 2.Listar bebês"
                + "\n 3.Remover bebê"
                + "\n 4.Pesquisar bebê"
                + "\n 5.Alterar dados do bebê"
                + "\n 6.Verificar Vacinas de acordo com os meses"
                + "\n 7.Verifcar Vacinas Disponíveis"
                + "\n 8.Agendar Vacina"
                + "\n 9.Listar Vacina Agendadas"
                + "\n 10.Consultar Vacinas Tomadas"
                + "\n 0.Sair");

        Scanner leia = new Scanner(System.in);
        boolean sair = false;
        while(!sair) {
            int opcao = Integer.parseInt(leia.nextLine());

            switch(opcao){
                case 1:
                    System.out.println("Qual o nome do seu bebê?");
                    String nomeBebe = leia.nextLine();
                    System.out.println("Qual é o sexo do bebê? (F ou M)");
                    String sexoBebe = leia.nextLine();
                    System.out.println("Quantos meses tem o seu bebê?");
                    int idadeBebe = Integer.parseInt(leia.nextLine());
                    Bebe bebe = new Bebe(nomeBebe, sexoBebe, idadeBebe);
                    bebeService.cadastrarBebe(bebe);
                    System.out.println("Cadastro concluído com sucesso! \n");
                    break;
                case 2:
                    System.out.println("Bebês cadastrados: \n");
                    System.out.println(bebeService.listarBebes());
                    break;
                case 3:
                    System.out.println("Digite o nome do bebê que deseja remover:");
                    String nome = leia.nextLine();
                    bebeService.removerBebe(nome);
                    System.out.println("Removido com sucesso! \n" );
                    break;
                case 4:
                    System.out.println("Digite o nome do bebê que deseja pesquisar:");
                    String nomePesquisa = leia.nextLine();
                    System.out.println(bebeService.pesquisarPeloNome(nomePesquisa));
                    break;
                case 5:
                    System.out.println("Digite o nome do bebê que deseja alterar:");
                    String nomeAlterar = leia.nextLine();
                    System.out.println("Digite os novos dados do bebê");
                    System.out.println("Digite o nome bebê:");
                    String novoNome = leia.nextLine();
                    System.out.println("Digite o sexo do bebê: (F ou M)");
                    String novoSexo = leia.nextLine();
                    System.out.println("Digite quantos meses o bebê tem:");
                    int novaIdade = Integer.parseInt(leia.nextLine());
                    bebeService.alterarBebe(nomeAlterar, new Bebe(novoNome,novoSexo,novaIdade));
                    System.out.println("Dados alterados com sucesso!");
                    break;
                case 6:
                    System.out.println(vacinaService.verficarVacinas());
                    break;
                case 7:
                    System.out.println("Digite quantos meses tem seu bebê:");
                    int idadeVacinaBebe = Integer.parseInt(leia.nextLine());
                    System.out.println(vacinaService.getVacinasPorIdade(idadeVacinaBebe));
                    break;
                case 8:
                    System.out.println("Digite o nome do bebê para o qual deseja agendar uma vacina:");
                    String nomeAgendar = leia.nextLine();
                    Bebe bebeAgendar = bebeService.pesquisarPeloNome(nomeAgendar);
                    if (bebeAgendar != null) {
                        System.out.println("Vacinas recomendadas para " + nomeAgendar + " (" + bebeAgendar.getIdade() + " meses):");
                        System.out.println(vacinaService.getVacinasPorIdade(bebeAgendar.getIdade()));
                        for (VacinaAgendada vacina : bebeAgendar.getVacinasAgendadas()) {
                            System.out.println(vacina);
                        }
                        System.out.println("Digite o nome da vacina que deseja agendar:");
                        String nomeVacina = leia.nextLine();

                        System.out.println("Digite a data da vacina no formato DD/MM/AAAA:");
                        String dataVacinaStr = leia.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataVacina = LocalDate.parse(dataVacinaStr, formatter);
                        new VacinaAgendada(nomeVacina, dataVacina, nomeAgendar);
                        // System.out.println("Digite a data da vacina no formato DD/MM/AAAA:");
                        //String dataVacina = leia.nextLine();
                        //VacinaAgendada vacinacao = new VacinaAgendada(nomeVacina, dataVacina);
                        //bebeService.agendarVacina(bebeAgendar, vacinacao);
                        System.out.println("Vacina agendada com sucesso para " + nomeAgendar + "!");
                    } else {
                        System.out.println("Bebê não encontrado.");
                    }
                    break;
                case 9:
                case 10:
                case 0:
                    sair = true;
            }
        }
        System.out.println("Fim de programa!");

    }
}
