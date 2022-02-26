package Main;

import javax.swing.plaf.basic.BasicArrowButton;

public class Veiculo{
    private String Tipo;
    private String Marca;
    private double Preco;
    private int Quantidade;

    protected String[] Automoveis = new String[]{
            "Carro",
            "Moto",
            "Caminhao",
            "Carreta",
            "Bicicleta"
    };

    Veiculo(){}
    Veiculo(String automovel, String marca, double preco, int quantidade){
        this.Tipo = automovel;
        this.Marca = marca;
        this.Preco = preco;
        this.Quantidade = quantidade;
    }

    void ImprimirAutomoveis(){
        for (int i = 0; i < Automoveis.length; i++) System.out.println((i+1) + " - " + Automoveis[i]);
    }

    String setAutomovel(int index){
        --index;
        if (index < Automoveis.length && index > -1) return this.Tipo = Automoveis[index];
        return this.Tipo = "Falha ao encontrar o tipo";
    }

    public void printAutomoveis(){
        for (int i = 0; i < Automoveis.length; i++) System.out.println(String.format((i+1) + Automoveis[i]));
    }

    void imprimir(){
        System.out.printf("Tipo de automovel: %s", this.Tipo);
        System.out.println();
        System.out.printf("Marca: %s", this.Marca);
        System.out.println();
        System.out.printf("Preço: %.2f", this.Preco);
        System.out.println();
    }

    void EditarProduto(String automovelNovo, String marcaNova, double precoNovo, int quantidadeNova){
        this.Marca = marcaNova;
        this.Tipo = automovelNovo;
        this.Preco = precoNovo;
        this.Quantidade = quantidadeNova;
    }

    @Override
    public String toString() {return "Tipo Automovel: " + this.Tipo + " | " + "Marca: " + this.Marca + " | " + "Preço: " + this.Preco + " | " + "Quantidade: " + this.Quantidade; }
}
