package SQLInsertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.FaltaDomain;
import Classes.AlunoDomain;
import Classes.MateriaDomain;

public class FaltaSQL {
    private Connection connection;
            
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(FaltaDomain falta){
        String sql = "INSERT INTO presencadia " +
                "(idAluno_PresencaDia, idMateria_PresencaDia, diaFalta, faltas, presencas) " +
                "VALUES (?, ?, ? ,? ,?)";
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt      (1, falta.getIdAluno_Falta());
            valores.setInt      (2, falta.getIdMateria_Falta());
            valores.setInt      (3, falta.getDiaFalta());
            valores.setInt      (4, falta.getFaltas());
            valores.setInt      (5, falta.getPresencas());
            valores.execute();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<FaltaDomain> buscarFaltaPorAluno(AlunoDomain aluno){
        String sql = "SELECT * FROM presencadia WHERE idALuno_PresencaDia = ?";
        List<FaltaDomain> valorRetornado = new ArrayList<>();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt(1, aluno.getIdAluno());
            ResultSet resultado = valores.executeQuery();
            while(resultado.next()){
                FaltaDomain falta = new FaltaDomain();
                falta.setIdFalta        (resultado.getInt("idPresencaDia"));
                falta.setIdAluno_Falta  (resultado.getInt("idAluno_PresencaDia"));
                falta.setIdMateria_Falta(resultado.getInt("idMateria_PresencaDia"));
                falta.setDiaFalta       (resultado.getInt("diaFalta"));
                falta.setFaltas         (resultado.getInt("faltas"));
                falta.setPresencas      (resultado.getInt("presencas"));
                valorRetornado.add(falta);

            }
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
    
    public List<FaltaDomain> buscarFaltaPorMateria(MateriaDomain materia){
        String sql = "SELECT * FROM presencadia WHERE idMateria_PresencaDia = ?";
        List<FaltaDomain> valorRetornado = new ArrayList<>();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt(1, materia.getIdMateria());
            ResultSet resultado = valores.executeQuery();
            while(resultado.next()){
                FaltaDomain falta = new FaltaDomain();
                falta.setIdFalta        (resultado.getInt("idPresencaDia"));
                falta.setIdAluno_Falta  (resultado.getInt("idAluno_PresencaDia"));
                falta.setIdMateria_Falta(resultado.getInt("idMateria_PresencaDia"));
                falta.setDiaFalta       (resultado.getInt("diaFalta"));
                falta.setFaltas         (resultado.getInt("faltas"));
                falta.setPresencas      (resultado.getInt("presencas"));
                valorRetornado.add(falta);

            }
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
    
    public List<FaltaDomain> buscarFaltaPorDia(FaltaDomain falta){
        String sql = "SELECT * FROM presencadia WHERE diaFalta = ?";
        List<FaltaDomain> valorRetornado = new ArrayList<>();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt(1, falta.getDiaFalta());
            ResultSet resultado = valores.executeQuery();
            while(resultado.next()){
                falta.setIdFalta        (resultado.getInt("idPresencaDia"));
                falta.setIdAluno_Falta  (resultado.getInt("idAluno_PresencaDia"));
                falta.setIdMateria_Falta(resultado.getInt("idMateria_PresencaDia"));
                falta.setDiaFalta       (resultado.getInt("diaFalta"));
                falta.setFaltas         (resultado.getInt("faltas"));
                falta.setPresencas      (resultado.getInt("presencas"));
                valorRetornado.add(falta);

            }
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
}

