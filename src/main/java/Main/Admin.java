package Main;

import static Main.Program.Estoque;
import static Main.Program.scan;

public class Admin extends Conta{
    public static void VisualizarItens(){
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
