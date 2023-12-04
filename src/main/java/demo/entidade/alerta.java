package demo.entidade;

public class alerta {
    private int id_alerta;
    private String NomeVacina;
    private String dataProx;


    public alerta(int id_alerta, String NomeVacina, String dataProx){
        this.id_alerta = id_alerta;
        this.NomeVacina = NomeVacina;
        this.dataProx = dataProx;
    }
    
    public int getId(){
        return this.id_alerta;
    }
    public void setId(int id_alerta){
        this.id_alerta = id_alerta;
    }

     public String getNomeVacina(){
        return this.NomeVacina;
    }
    public void setNomeVacina(String NomeVacina){
        this.NomeVacina = NomeVacina;
    }
     public String getDataProx(){
        return this.dataProx;
    }
    public void setdataProc(String dataProx){
        this.dataProx = dataProx;
    }
}
