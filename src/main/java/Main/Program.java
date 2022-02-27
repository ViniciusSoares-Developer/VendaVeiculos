package Main;

import com.sun.security.jgss.GSSUtil;

import java.util.*;


public class Program{

    protected static Admin admin = new Admin();
    protected static Conta conta = admin;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("$$$$$$ Venda de Automovel $$$$$$");

        int escolha;
        do{
            escolha = loginRegistro();
            switch(escolha){
                case 0:
                    System.out.println("\n=================");
                    System.out.println("Erro ao realizar o login");
                    break;
                case 1:
                    ClienteAcess();
                    break;
                case 2:
                    AdminAcess();
                    break;
                default: return;
            }
        }while(true);
    }

    static int loginRegistro(){
        do{
            System.out.println("\n=================");
            System.out.println("1 - Logar");
            System.out.println("2 - Registrar");
            System.out.println("3 - Fechar Programa");
            int escolha = scan.nextInt();
            int login = 0;
            switch (escolha) {
                case 1: return login();
                case 2: registro(); break;
                default:
                    return 3;
            }
        }while(true);
    }

    static void registro(){
        System.out.println("\n=================");
        System.out.println("Crie sua conta");
        System.out.println("=================\n");
        System.out.println("Digite seu login: ");
        String login = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        conta.getContas().add(new Usuario(login, senha));
    }
    static int login(){
        System.out.println("\n=================");
        System.out.println("Digite seu login: ");
        String login = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        for (int i = 0; i < conta.getContas().size(); i++) {
            if ((conta.getContas().get(i).getUsuario().equals(login) && conta.getContas().get(i).getSenha().equals(senha))){
                return conta.getContas().get(i).nivelAcesso(login, senha);
            }
        }
        if(login.equals("admin") && senha.equals("admin")) return conta.getUser().nivelAcesso(login, senha);
        return 0;
    }

    static void AdminAcess(){
        String select;
        do{
            InicioAdmin();
            select = scan.next();
            switch (select){
                case "1" :
                    if(!admin.getEstoque().isEmpty()) admin.VisualizarItens();
                    else System.out.println("\nSem veiculos cadastrados");
                    break;
                case "2":
                    admin.AdicionarVeiculo();
                    break;
                case "3":
                    if(!admin.getEstoque().isEmpty()) admin.EditarProduto();
                    else System.out.println("\n+++++ Sem veiculos para editar +++++\n");
                    break;
                case "4": admin.ImprimirVeiculos();
            }
        }while(!(select.toLowerCase().equals("x")));
    }
    static void ClienteAcess(){
        String select;
        do{
            InicioCliente();
            select = scan.next();
            switch (select){
                case "1" :
                    if(!conta.getEstoque().isEmpty()) conta.VisualizarItens();
                    else System.out.println("Sem veiculos para vender");
                    break;
                case "2":
                    if(!admin.getEstoque().isEmpty()) {
                        System.out.println("Digite o id do veiculo: ");
                        while(!admin.getEstoque().isEmpty()){
                            conta.VisualizarItens();
                            System.out.println();
                            int i = scan.nextInt();
                            if(i > -1 && i < conta.getEstoque().size()){
                                conta.ComprarVeiculo(i);
                                break;
                            }
                            else{
                                System.out.println("Id invalida");
                                break;
                            }
                        }
                    }
                    else System.out.println("\nSem veiculo para comprar");
                    break;
                case "3": conta.ImprimirVeiculos();
            }
        }while(!(select.toUpperCase().equals("X")));
    }

    static void InicioAdmin(){
        System.out.println("\n=================");
        System.out.println("Selecione sua Ação: ");
        System.out.println("1 - Visualizar os itens a venda");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Editar produto");
        System.out.println("4 - Tipos de automovel");
        System.out.println("x - Desconectar");
    }
    static void InicioCliente(){
        System.out.println("\n=================");
        System.out.println("Selecione sua Ação: ");
        System.out.println("1 - Visualizar os itens a venda");
        System.out.println("2 - Realizar uma compra");
        System.out.println("3 - Tipos de automovel");
        System.out.println("x - Desconectar");
    }

}
