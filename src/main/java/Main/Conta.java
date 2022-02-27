package Main;

import java.util.ArrayList;
import java.util.List;

public class Conta extends Usuario{


    static Veiculo ImprimirVeiculos(){
        Veiculo automoveis = new Veiculo();
        System.out.println();
        automoveis.ImprimirAutomoveis();
        System.out.println();
        return automoveis;
    }



}
