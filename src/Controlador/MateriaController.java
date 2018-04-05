package Controlador;

import java.sql.Connection;
import java.util.Scanner;
import SQLConnection.Database;
import SQLConnection.DatabaseFactory;
import Classes.MateriaDomain;
import Base.MateriaView;
import SQLInsertion.MateriaSQL;

public class MateriaController implements MateriaView{
    private final MateriaDomain materia = new MateriaDomain();
    private final MateriaSQL materiaSQL = new MateriaSQL();
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    
    private final Scanner scan = new Scanner(System.in);
    
    
    @Override
    public void menuMateria() {
        System.out.println("Gerenciamento de Cadastros das Matérias:");
        System.out.println("(1) Cadastrar");
        System.out.println("(2) Listar");
        System.out.println("(3) Deletar");
        System.out.println("(4) Atualizar");
        System.out.println("Escolha: ");
        String decisao = "" + scan.next();
        
        
        switch(decisao){
            case "1":
                cadastrarMateria();
                break;
            case "2":
                listarMateria();
                break;
            case "3":
                removerMateria();
                break;
            case "4":
                alterarMateria();
                break;
            default:
                System.out.println("Operação Cancelada.");
                
        }
    }
    
    @Override
    public void cadastrarMateria() {
        materiaSQL.setConnection(connection);
        
        System.out.println("Insira o nome da matéria: ");
        materia.setNomeMateria(scan.next());
        
        System.out.println("Insira nome do Professor: ");
        materia.setNomeProfessor(scan.next());
        
        System.out.println("Insira as Horas da matéria: ");
        materia.setHorasAula(scan.nextInt());
        
        materiaSQL.inserir(materia);
    }

    @Override
    public void listarMateria() {
        materiaSQL.setConnection(connection);
        
        materiaSQL.listar().forEach((p) -> {
            
            System.out.println("ID: " + p.getIdMateria());
            System.out.println("Nome: " + p.getNomeMateria());
            System.out.println("Professor: " + p.getNomeProfessor());
            System.out.println("Carga Horária: " + p.getHorasAula());
            
        });
    }

    @Override
    public void removerMateria() {
        materiaSQL.setConnection(connection);
        
        System.out.println("Escolha uma ID: ");
        materia.setIdMateria(scan.nextInt());
        materiaSQL.buscar(materia);
        
        System.out.println("Deseja excluir a matéria: " + materia.getNomeMateria() + "?");
        System.out.println("Y - Sim / N - Não");
        String decisao = scan.next();
        
        if("Y".equals(decisao) || "y".equals(decisao)){
            
            materiaSQL.remover(materia);
            System.out.println("Matéria removido com sucesso!");
            
        }else if("N".equals(decisao) || "n".equals(decisao)){
            
            System.out.println("Não Removido");
            
        }else{
            
            System.out.println("Escolha inválida");
            
        }
    }

    @Override
    public void alterarMateria() {
        materiaSQL.setConnection(connection);
        
        System.out.println("Escolha um ID: ");
        materia.setIdMateria(scan.nextInt());
        materiaSQL.buscar(materia);
               
        System.out.println("Insira o nome da matéria: ");
        materia.setNomeMateria(scan.next());
        
        System.out.println("Insira nome do Professor: ");
        materia.setNomeProfessor(scan.next());
        
        System.out.println("Insira as Horas da matéria: ");
        materia.setHorasAula(scan.nextInt());
        
        materiaSQL.alterar(materia);
        
    }


}

