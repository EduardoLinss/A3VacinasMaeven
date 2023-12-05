package demo.entidade;



public class caderneta {
    private String nome;
    private String dataAplic;
    private String dose;
    private String local;
    private String cidade;
    

    public caderneta(String nome, String dataAplic, String dose, String local, String cidade){
        this.nome = nome;
        this.dataAplic = dataAplic;
        this.dose = dose;
        this.local = local;
        this.cidade = cidade;
    }
  

    

    public caderneta(int i, String sql, String sql2, String sql3) {
    }


    public String getNome(){
        return this.nome;
    }
  
    public void setNome(String nome){
        this.nome = nome;
    }

  
    public String getDataAplic(){
        return this.dataAplic;
    }
    public void setDataAplic(String dataAplic){
        this.dataAplic = dataAplic;
    }

    public String getDose(){
        return this.dose;
    }
    public void setDose(String dose){
        this.dose= dose;
    }

    public String getLocal(){
        return this.local;
    }
    public void setLocal(String local){
        this.local = local;
    }

   public String getCidade(){
    return this.cidade;
   }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }



  
   
}
