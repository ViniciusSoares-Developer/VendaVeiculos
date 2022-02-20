package Main;

public class Veiculo{
    protected int Id = 0;
    private String Tipo;
    private String Marca;
    private double Price;

    protected String[] Automoveis = new String[]{
            "Carro",
            "Moto",
            "Caminhao",
            "Carreta",
            "Bicicleta"
    };

    Veiculo(){}
    Veiculo(String Automovel, String Marca, double Price){
        this.Id++;
        this.Marca = Marca;
        this.Price = Price;
        validacaoTipo(Automovel);
    }

    private String validacaoTipo(String Validacao){
        for(String Tipo : Automoveis) {
            if (Tipo.equals(Validacao)) {
                return this.Tipo = Tipo;
            }
        }
        System.out.println("Marca não encontrada!");
        return this.Tipo;
    }

    void imprimir(){
        System.out.printf("Tipo de automovel: %s", this.Tipo);
        System.out.println();
        System.out.printf("Marca: %s", this.Marca);
        System.out.println();
        System.out.printf("Preço: %.2f", this.Price);
        System.out.println();
    }
}
