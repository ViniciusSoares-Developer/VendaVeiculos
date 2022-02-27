package Main;

public class Usuario{
    private String Usuario;
    private String Senha;

    Usuario(){};
    Usuario(String usuario, String senha){
        this.Usuario = usuario;
        this.Senha = senha;
    }

    //Getters
    public String getUsuario() {return Usuario;}
    public String getSenha() {return Senha;}

    public int nivelAcesso(String login, String senha){
        if(login.equals(this.Usuario) && senha.equals(this.Senha)) return 1;
        else if(login.equals("admin") && senha.equals("admin")) return 2;
        return 0;
    }

}
