package Main;

import java.io.Console;
import java.util.*;

import Main.Veiculo;
import com.sun.security.jgss.GSSUtil;

public class Program {

    static Scanner scan;

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        Imprimir(veiculo);
    }

    static void Imprimir(Veiculo veiculo){
        scan = new Scanner(System.in);
        String continuar;
        do {
            System.out.println("==============================");
            System.out.println("Digite o tipo do automovel: ");
            String DS = scan.next();
            System.out.println("Digite a marca: ");
            String DS2 = scan.next();
            System.out.println("Digite o preço: ");
            double DN = scan.nextFloat();
            System.out.println();
            veiculo = new Veiculo(DS, DS2, DN);
            veiculo.imprimir();
            System.out.println();
            System.out.println("Deseja Continuar: (Y/N)");
            continuar = scan.next();
            System.out.println("============================ ==");
            System.out.println();
        } while (continuar.toUpperCase().equals("Y"));
    }

}
