package Main;

import com.sun.security.jgss.GSSUtil;

import java.util.*;


public class Program extends Admin{

    static List<Veiculo> Estoque = new ArrayList<>();
    public static List<Usuario> Contas = new ArrayList<>();
    public static Usuario user = new Usuario();
    static Scanner scan = new Scanner(System.in);
    static String nomePessoa;

    public static void main(String[] args) {
        System.out.println("$$$$$$ Venda de Automovel $$$$$$");

        int escolha;
        do{
            escolha = loginRegistro();
            switch(escolha){
                case 0:
                    System.out.println("Erro ao realizar o login");
                    break;
                case 1:

                case 2:
                    String continuar;
                    AdminAcess();
                    break;
                default: break;
            }
        }while(true);
    }

    static int loginRegistro(){
        do{
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

    static void AdminAcess(){
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
    static void cliente(){

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
    static void registro(){
        System.out.println("Crie sua conta");
        System.out.println("Digite seu login: ");
        String login = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        Contas.add(new Usuario(login, senha));
    }
    static int login(){
        System.out.println("Digite seu login: ");
        String login = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        for (int i = 0; i < Contas.size(); i++) {
            if ((Contas.get(i).getUsuario().equals(login) && Contas.get(i).getSenha().equals(senha))){
                return Contas.get(i).nivelAcesso(login, senha);
            }
        }
        if(login.equals("admin") && senha.equals("admin")) return user.nivelAcesso(login, senha);
        return 0;
    }
}
