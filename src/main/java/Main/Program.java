package Main;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class Program {

    static List<Veiculo> Estoque = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String nomePessoa;

    public static void main(String[] args) {
        System.out.println("$$$$$$ Venda de Automovel $$$$$$");
        String select;
        do{
            Inicio();
            select = scan.next();
            switch (select){
                case "1" :
                    if(!Estoque.isEmpty()) VisualizarItens();
                    else System.out.println("Sem veiculos para venda");
                    break;
                case "2":
                    AdicionarVeiculo();
                    break;
                case "3":
                    if(!Estoque.isEmpty()) EditarProduto();
                    else System.out.println("Sem Produto para Editar");
                    break;
                case "4": ImprimirVeiculos();
            }
        }while(!(select.toLowerCase().equals("x")));
    }

    static void Inicio(){
        System.out.println();
        System.out.println("Selecione sua Ação: ");
        System.out.println("1 - Visualizar os itens a venda");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Editar produto");
        System.out.println("4 - Tipos de automovel");
        System.out.println("x - Fechar o Programa");
        System.out.println();
    }

    static void VisualizarItens(){
        int Id = 0;
        for (Veiculo x: Estoque) {
            System.out.print(Id + " - ");
            Id++;
            System.out.println(x);
        }
    }
    static void AdicionarVeiculo(){
        String tipo = TiposAutomovel();
        System.out.println("Marca: ");
        String marca = scan.next();
        System.out.println("Preço: ");
        double preco = scan.nextDouble();
        System.out.println("Quantidade estoque: ");
        int quantidade = scan.nextInt();
        Estoque.add(new Veiculo(tipo, marca, preco, quantidade));
    }
    static String TiposAutomovel(){
        ImprimirVeiculos();
        System.out.println("Digite o id do tipo do veiculo: ");
        return ImprimirVeiculos().setAutomovel(scan.nextInt());
    }
    static Veiculo ImprimirVeiculos(){
        Veiculo automoveis = new Veiculo();
        System.out.println();
        automoveis.ImprimirAutomoveis();
        System.out.println();
        return automoveis;
    }
    static void EditarProduto(){
        System.out.println("Digite a Id do produto a ser Editado: ");
        int index = scan.nextInt();
        if(!Estoque.isEmpty()){
            if(index < Estoque.size() && index > -1){
                System.out.println();
                String tipo = TiposAutomovel();
                System.out.println("Marca: ");
                String marca = scan.next();
                System.out.println("Preço: ");
                double preco = scan.nextDouble();
                System.out.println("Quantidade estoque: ");
                int quantidade = scan.nextInt();
            }
            else System.out.println("Não tem esse item na lista\n");
        }
        else System.out.println("Sem produtos para alterar\n");




    }
}
