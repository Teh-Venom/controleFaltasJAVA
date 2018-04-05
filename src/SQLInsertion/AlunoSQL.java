package SQLInsertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.AlunoDomain;

public class AlunoSQL {
    private Connection connection;
            
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(AlunoDomain aluno){
        String sql = "INSERT INTO aluno (nomeAluno) VALUES (?)";
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setString   (1, aluno.getNome());
            valores.execute     ();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(AlunoDomain aluno){
        String sql = "UPDATE aluno SET nomeAluno = ? WHERE idAluno = ?";
        try{
            
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setString   (1, aluno.getNome());
            valores.setInt      (2, aluno.getIdAluno());
            valores.execute     ();
            return true;
            
        }catch(SQLException ex){
            
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    public boolean remover(AlunoDomain aluno){
        String sql = "DELETE FROM aluno WHERE idAluno = ?";
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt (1, aluno.getIdAluno());
            valores.execute();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<AlunoDomain> listar(){
        String sql = "SELECT * FROM aluno";
        List<AlunoDomain> valorRetornado = new ArrayList<>();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            ResultSet resultado = valores.executeQuery();
            while(resultado.next()){
                
                AlunoDomain aluno = new AlunoDomain();
                aluno.setIdAluno(resultado.getInt("idAluno"));
                aluno.setNome   (resultado.getString("nomeAluno"));
                valorRetornado.add(aluno);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
    
    public AlunoDomain buscar(AlunoDomain aluno){
        String sql = "SELECT * FROM aluno WHERE idAluno = ?";
        AlunoDomain valorRetornado = new AlunoDomain();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt(1, aluno.getIdAluno());
            ResultSet resultado = valores.executeQuery();
            if(resultado.next()){
                aluno.setNome(resultado.getString("nomeAluno"));
                valorRetornado = aluno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
}

