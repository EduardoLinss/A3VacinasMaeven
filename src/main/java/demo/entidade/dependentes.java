package demo.entidade;



public class dependentes {

    private int id;
    private String nome;
    private String cpf;
    private String idade;

    public dependentes (int id, String nome, String cpf, String idade){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public dependentes() {
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

    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getIdade(){
        return this.idade;
    }
    public void setIdade(String idade){
        this.idade = idade;
    }
}
