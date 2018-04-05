package Classes;

/**
 * @author Gabriel Braz e Santos
 */
public class MateriaDomain {
    private int idMateria;
    private String nomeMateria;
    private String nomeProfessor;
    private int horasAula;
    
    
    
    public MateriaDomain(int idMateria, String nomeMateria, String nomeProfessor, int horasAula){
        this.idMateria = idMateria;
        this.nomeMateria = nomeMateria;
        this.nomeProfessor = nomeProfessor;
        this.horasAula = horasAula;
    }
    
    public MateriaDomain()
    {
    }
    
    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    /**
     * @return the nomeMateria
     */
    public String getNomeMateria() {
        return nomeMateria;
    }

    /**
     * @param nomeMateria the nomeMateria to set
     */
    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    /**
     * @return the nomeProfessor
     */
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    /**
     * @param nomeProfessor the nomeProfessor to set
     */
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    /**
     * @return the horasAula
     */
    public int getHorasAula() {
        return horasAula;
    }

    /**
     * @param horasAula the horasAula to set
     */
    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

}

