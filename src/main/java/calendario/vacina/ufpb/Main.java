package calendario.vacina.ufpb;

import calendario.vacina.ufpb.service.BebeService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BebeService bebeService = new BebeService();

        System.out.println("Sistema Calendário de Vacina\n");

        System.out.println("                                         Meses | Vacinas Recomendadas\n"
                + "--------------------------------------------------------------------------------------------------------------------"
                + "\n 0 meses  | BCG, Hepatite B                                                                                        | "
                + "\n 2 meses  | Hepatite B, Poliomielite, Tríplice bacteriana, Pneumocócica 13V, Rotavírus                             | "
                + "\n 3 meses  | Meningocócica ACWY, Meningocócica B                                                                    | "
                + "\n 4 meses  | Poliomielite, Tríplice bacteriana, Pneumocócica 13V, Rotavírus                                         | "
                + "\n 5 meses  | Meningocócica ACWY, Meningocócica B                                                                    | "
                + "\n 6 meses  | Hepatite B, Poliomielite, Tríplice bacteriana, Pneumocócica 13V, Rotavírus, Influenza                  | "
                + "\n 7 meses  | Meningocócica ACWY, Influenza                                                                          | "
                + "\n 8 meses  | Influenza                                                                                              | "
                + "\n 9 meses  | Febre Amarela, Influenza                                                                               | "
                + "\n 10 meses | Influenza                                                                                              | "
                + "\n 11 meses | Influenza                                                                                              | "
                + "\n 12 meses | Pneumocócica 13V, Meningocócica ACWY, Meningocócica B, Tríplice viral, Varicela, Hepatite A, Influenza |"
                + "\n--------------------------------------------------------------------------------------------------------------------"
        );

        System.out.println("\n"
                + "Escolha uma opção:"
                + "\n 1.Cadastrar bebê"
                + "\n 2.Listar bebês"
                + "\n 3.Remover bebê"
                + "\n 4.Pesquisar bebê"
                + "\n 5.Alterar dados do bebê"
                + "\n 6.Agendar Vacina"
                + "\n 7.Consultar Vacinas Tomadas"
                + "\n 0.Sair");

    Scanner leia = new Scanner(System.in);
    boolean sair = false;
		while(!sair) {
        int opcao = Integer.parseInt(leia.nextLine());

        switch(opcao){
            case 1:
                System.out.println("Digite o nome do bebê:");
                String nomeBebe = leia.nextLine();
                System.out.println("Digite o sexo do bebê:");
                String sexoBebe = leia.nextLine();
                System.out.println("Quantos meses o bebê tem?");
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
                System.out.println("Digite o sexo do bebê:");
                String novoSexo = leia.nextLine();
                System.out.println("Digite quantos meses o bebê tem:");
                int novaIdade = Integer.parseInt(leia.nextLine());
                bebeService.alterarBebe(nomeAlterar, new Bebe(novoNome,novoSexo,novaIdade));
                System.out.println("Dados alterados com sucesso!");
                break;
            case 0:
                sair = true;
        }
    }
		System.out.println("Fim de programa!");

    }
}
