package SQLInsertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.MateriaDomain;

public class MateriaSQL {
    private Connection connection;
            
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(MateriaDomain materia){
        String sql = "INSERT INTO materia (nomeMateria, nomeProfessor, horasAula) VALUES (?, ?, ?)";
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setString   (1, materia.getNomeMateria());
            valores.setString   (2, materia.getNomeProfessor());
            valores.setInt      (3, materia.getHorasAula());
            valores.execute     ();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(MateriaSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(MateriaDomain materia){
        String sql = "UPDATE materia SET nomeMateria = ? , nomeProfessor = ?, horasAula = ? WHERE idmateria = ?";
        try{
            
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setString   (1, materia.getNomeMateria());
            valores.setString   (2, materia.getNomeProfessor());
            valores.setInt      (3, materia.getHorasAula());
            valores.setInt      (4, materia.getIdMateria());
            valores.execute     ();
            return true;
            
        }catch(SQLException ex){
            
            Logger.getLogger(MateriaSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    public boolean remover(MateriaDomain materia){
        String sql = "DELETE FROM materia WHERE idmateria = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt     (1, materia.getIdMateria());
            stmt.execute    ();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(MateriaSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<MateriaDomain> listar(){
        String sql = "SELECT * FROM materia";
        List<MateriaDomain> valorRetornado = new ArrayList<>();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            ResultSet resultado = valores.executeQuery();
            while(resultado.next()){
                
                MateriaDomain materia = new MateriaDomain();
                materia.setIdMateria    (resultado.getInt("idmateria"));
                materia.setNomeMateria  (resultado.getString("nomeMateria"));
                materia.setNomeProfessor(resultado.getString("nomeProfessor"));
                materia.setHorasAula    (resultado.getInt("horasAula"));
                valorRetornado.add      (materia);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(MateriaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
    
    public MateriaDomain buscar(MateriaDomain materia){
        String sql = "SELECT * FROM materia WHERE idmateria = ?";
        MateriaDomain valorRetornado = new MateriaDomain();
        try{
            PreparedStatement valores = getConnection().prepareStatement(sql);
            valores.setInt(1, materia.getIdMateria());
            ResultSet resultado = valores.executeQuery();
            if(resultado.next()){
                materia.setNomeMateria(resultado.getString("nomeMateria"));
                valorRetornado = materia;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorRetornado;
    }
}

