package Classes;

public class FaltaDomain {

    private int idFalta;
    private int idAluno_Falta;
    private int idMateria_Falta;
    private int diaFalta;
    private int faltas;
    private int presencas;

    public FaltaDomain(){}

    public FaltaDomain(int idFalta, int idAluno_Falta, int idMateria_Falta, int diaFalta, int faltas, int presencas)
    {
        this.idFalta = idFalta;
        this.idAluno_Falta = idAluno_Falta;
        this.idMateria_Falta = idMateria_Falta;
        this.diaFalta = diaFalta;
        this.faltas = faltas;
        this.presencas = presencas;
    }

    
    /**
     * @return the idFalta
     */
    public int getIdFalta() {
        return idFalta;
    }

    /**
     * @param idFalta the idFalta to set
     */
    public void setIdFalta(int idFalta) {
        this.idFalta = idFalta;
    }

    /**
     * @return the idAluno_Falta
     */
    public int getIdAluno_Falta() {
        return idAluno_Falta;
    }

    /**
     * @param idAluno_Falta the idAluno_Falta to set
     */
    public void setIdAluno_Falta(int idAluno_Falta) {
        this.idAluno_Falta = idAluno_Falta;
    }

    /**
     * @return the idMateria_Falta
     */
    public int getIdMateria_Falta() {
        return idMateria_Falta;
    }

    /**
     * @param idMateria_Falta the idMateria_Falta to set
     */
    public void setIdMateria_Falta(int idMateria_Falta) {
        this.idMateria_Falta = idMateria_Falta;
    }

    /**
     * @return the diaFalta
     */
    public int getDiaFalta() {
        return diaFalta;
    }

    /**
     * @param diaFalta the diaFalta to set
     */
    public void setDiaFalta(int diaFalta) {
        this.diaFalta = diaFalta;
    }

    /**
     * @return the faltas
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    /**
     * @return the presencas
     */
    public int getPresencas() {
        return presencas;
    }
    public void setPresencas(int presencas) {
        this.presencas = presencas;
    }

}
