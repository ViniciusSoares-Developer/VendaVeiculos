package Main;

public class Admin extends Conta{

    void AdicionarVeiculo(){
        String tipo = TiposAutomovel();
        System.out.println("Marca: ");
        String marca = scan.next();
        System.out.println("Preço: ");
        double preco = scan.nextDouble();
        System.out.println("Quantidade estoque: ");
        int quantidade = scan.nextInt();
        super.getEstoque().add(new Veiculo(tipo, marca, preco, quantidade));
    }
    String TiposAutomovel(){
        ImprimirVeiculos();
        System.out.println("Digite o id do tipo do veiculo: ");
        return automoveis.setAutomovel(scan.nextInt());
    }
    void EditarProduto(){
        System.out.println("\n--------------------");
        System.out.println("Digite a Id do produto a ser Editado: ");
        int index = scan.nextInt();
        if(index < super.getEstoque().size() && index > -1){
            System.out.println();
            String tipo = TiposAutomovel();
            System.out.println("Marca: ");
            String marca = scan.nextLine();
            System.out.println("Preço: ");
            double preco = scan.nextDouble();
            System.out.println("Quantidade estoque: ");
            int quantidade = scan.nextInt();
            super.getEstoque().set(index, new Veiculo(tipo, marca, preco, quantidade));
        }
        else System.out.println("Não tem esse item na lista\n");
        System.out.println("\n--------------------");
    }
}
