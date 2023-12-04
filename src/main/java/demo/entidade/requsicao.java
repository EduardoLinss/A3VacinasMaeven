package demo.entidade;

public class requsicao {
    private int id;
    private String nomePais;
    private String vacinas;


    public requsicao (int id, String nomePais, String vacinas ){
        this.id = id;
        this.nomePais = nomePais;
        this.vacinas= vacinas;
    }

    public requsicao(String pesquisa, String sql) {
    
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getnomePais(){
        return this.nomePais;
    }
    public void setnomePais(String nomePais){
        this.nomePais = nomePais;
    }

    public String getVacinas(){
        return this.vacinas;
    }
    public void setVacinas(String vacinas){
        this.vacinas = vacinas;
    }
}
