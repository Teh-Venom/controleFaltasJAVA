package Classes;

/**
 * @author Gabriel Braz e Santos
 */
public class AlunoDomain {
    private int idAluno;
    private String nome;
        
    public AlunoDomain(){
    }
    
    public AlunoDomain(int idAluno, String nome){
        this.idAluno = idAluno;
        this.nome = nome;
    }

    
    public int getIdAluno() {
        return idAluno;
    }
  
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

