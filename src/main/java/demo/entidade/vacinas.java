package demo.entidade;

public class vacinas {
    private int id_vacina;
    private String nomeVacina;
    private String tratamento;

    public vacinas(String nomeVacina, String tratamento){
        this.id_vacina = id_vacina;
        this.nomeVacina = nomeVacina;
        this.tratamento = tratamento;
    }

    public vacinas(int i, String sql, String sql2) {
    }

    public int getId_vacina(){
        return this.id_vacina;
    }
    public void setId_vacina(int id_vacina){
        this.id_vacina = id_vacina;
    }

    public String getNomeVacina(){
        return this.nomeVacina;
    }
    public void setNomeVacina(String nomeVacina){
        this.nomeVacina = nomeVacina;
    }

    public String getTratamento(){
        return this.tratamento;
    }
    public void setTratamento(String tratamento){
        this.tratamento = tratamento;
    }

}
