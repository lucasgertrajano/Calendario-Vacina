package calendario.vacina.ufpb;

import calendario.vacina.ufpb.service.BebeService;
import calendario.vacina.ufpb.service.VacinaService;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BebeService bebeService = new BebeService();
        try {
            bebeService.recuperarDados();

        } catch (IOException ioException){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao recuperar seus dados: "+ ioException.getMessage());
        }
        VacinaService vacinaService = new VacinaService();

        for (int i = 0; i< bebeService.getBebes().size(); i++) {
            Bebe bebe = bebeService.getBebes().get(i);
            for (int j = 0; j < bebe.getVacinasAgendadas().size(); j++){
                LocalDate dataVacina = bebe.getVacinasAgendadas().get(j).getData();;
                LocalDate hoje = LocalDate.now();

                int diasAteAgendada = hoje.until(dataVacina).getDays();

                if (diasAteAgendada <= 2 && diasAteAgendada >= 1) {
                    JOptionPane.showMessageDialog(null, "Faltam " + diasAteAgendada
                            + " dias para a data agendada da vacina contra "
                            + bebe.getVacinasAgendadas().get(j).getNomeVacina() + " para o bebe " + bebe.getNome());
                }
            }
            }

        System.out.println("Sistema Calendário de Vacina\n");

        System.out.println(
                 "Escolha uma opção:"
                + "\n 1.Cadastrar bebê"
                + "\n 2.Listar bebês"
                + "\n 3.Remover bebê"
                + "\n 4.Pesquisar bebê"
                + "\n 5.Alterar dados do bebê"
                + "\n 6.Verificar Vacinas de acordo com os meses"
                + "\n 7.Verificar Vacinas Disponíveis"
                + "\n 8.Agendar Vacina"
                + "\n 9.Listar Vacinas Agendadas"
                + "\n 0.Sair");

        Scanner leia = new Scanner(System.in);
        boolean sair = false;
        while(!sair) {
            String opcao = leia.nextLine();

            switch(opcao){
                case "1":
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

                case "2":
                    System.out.println("Bebês cadastrados: \n");
                    System.out.print(bebeService.listarBebes());
                    break;

                case "3":
                    System.out.println("Digite o nome do bebê que deseja remover:");
                    String nome = leia.nextLine();
                    bebeService.removerBebe(nome);
                    System.out.println("Removido com sucesso! \n" );
                    break;

                case "4":
                    System.out.println("Digite o nome do bebê que deseja pesquisar:");
                    String nomePesquisa = leia.nextLine();
                    System.out.println(bebeService.pesquisarPeloNome(nomePesquisa));
                    break;

                case "5":
                    System.out.println("Digite o nome do bebê que deseja alterar:");
                    String nomeAlterar = leia.nextLine();
                    Bebe bebeAlterar = bebeService.pesquisarPeloNome(nomeAlterar);
                    if(bebeAlterar != null) {
                        System.out.println("Digite os novos dados do bebê");
                        System.out.println("Digite o nome bebê:");
                        String novoNome = leia.nextLine();
                        System.out.println("Digite o sexo do bebê: (F ou M)");
                        String novoSexo = leia.nextLine();
                        System.out.println("Digite quantos meses o bebê tem:");
                        int novaIdade = Integer.parseInt(leia.nextLine());
                        bebeService.alterarBebe(nomeAlterar, new Bebe(novoNome, novoSexo, novaIdade));
                        System.out.println("Dados alterados com sucesso!");
                    } else {
                        System.out.println("Bebê não encontrado.");
                    }
                    break;

                case "6":
                    System.out.println(vacinaService.verficarVacinas());
                    break;

                case "7":
                    System.out.println("Digite quantos meses tem seu bebê:");
                    int idadeVacinaBebe = Integer.parseInt(leia.nextLine());
                    System.out.println(vacinaService.getVacinasPorIdade(idadeVacinaBebe));
                    break;

                case "8":
                    System.out.println("Digite o nome do bebê para o qual deseja agendar uma vacina:");
                    String nomeBebeAgendar = leia.nextLine();
                    Bebe bebeAgendar = bebeService.pesquisarPeloNome(nomeBebeAgendar);
                    if (bebeAgendar != null) {
                        System.out.println("Vacinas recomendadas para " + nomeBebeAgendar + " (" + bebeAgendar.getIdade() + " meses):");
                        System.out.println(vacinaService.getVacinasPorIdade(bebeAgendar.getIdade()));
                        System.out.println("Vacinas agendadas:");
                        System.out.println(bebeAgendar.listaVacinasAgendadas());
                        System.out.println("Digite o nome da vacina que deseja agendar:");
                        String nomeVacina = leia.nextLine();

                        System.out.println("Digite a data da vacina no formato dd/MM/yyyy:");
                        String dataVacinaStr = leia.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataVacina = LocalDate.parse(dataVacinaStr, formatter);
                        VacinaAgendada vacine = new VacinaAgendada(nomeVacina, dataVacina, nomeBebeAgendar);
                        bebeAgendar.getVacinasAgendadas().add(vacine);
                        System.out.println("Vacina agendada com sucesso para " + nomeBebeAgendar + "!");
                    } else {
                        System.out.println("Bebê não encontrado.");
                    }
                    break;

                case "9":
                    System.out.println("Digite o nome do Bebê: ");
                    String nomeBebeVacinas = leia.nextLine();
                    Bebe bebeVacinas = bebeService.pesquisarPeloNome(nomeBebeVacinas);
                    if (bebeVacinas != null){
                        System.out.println("Vacinas agendadas para " + bebeVacinas.getNome());
                        System.out.println(bebeVacinas.listaVacinasAgendadas());
                        break;
                    }
                    System.out.println("Bebê não encontrado");
                    break;

                case "0":
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inexistente!");
                    break;
            }
        }
        leia.close();
        System.out.println("Fim de programa!");
        try {
            bebeService.salvarDados();

        } catch (IOException ioException){
            JOptionPane.showConfirmDialog(null, "Ocorreu um erro ao recuperar seus dados: "+ ioException.getMessage());
        }

    }
}
