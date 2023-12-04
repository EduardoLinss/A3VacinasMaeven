package demo.entidade;

public class login {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private String cpf;
    private String dataNasc;

  
    public login(int id, String nome, String senha, String email, String cpf, String dataNasc){

        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public login(int i, String sql, String sql2) {
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getDataNasc(){
        return this.dataNasc;
    }
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
}
