package demo.entidade;

public class ubs {
    private int id;
    private String endereco;
    private String cep;


    public ubs (int id, String endereco, String cep){
        this.id = id;
        this.endereco = endereco;
        this.cep = cep;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getCep(){
        return this.cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }

   
}
