package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta{

    private List<Veiculo> Estoque = new ArrayList<>();
    protected List<Usuario> Contas = new ArrayList<>();
    protected Usuario user = new Usuario();
    public Scanner scan = new Scanner(System.in);
    public String nomePessoa;
    Veiculo automoveis = new Veiculo();

    void ImprimirVeiculos(){
        System.out.println("\n******************");
        automoveis.ImprimirAutomoveis();
        System.out.println("******************");
    }
    public void VisualizarItens(){
        int Id = 0;
        for (Veiculo x: Estoque) {
            System.out.print(Id + " - ");
            Id++;
            System.out.println(x);
        }
    }

    //Getters
    public List<Veiculo> getEstoque(){return Estoque;}
    public List<Usuario> getContas(){return Contas;}
    public Usuario getUser(){return user;}

    void ComprarVeiculo(int index){
        if(Estoque.get(index).getQuantidade() > 0){
            Estoque.get(index).Venda();
        }
        else System.out.println("Veiculo Acabou");
    }
}
