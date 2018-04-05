package Controlador;

import java.sql.Connection;
import java.util.Scanner;
import SQLConnection.Database;
import SQLConnection.DatabaseFactory;
import Classes.AlunoDomain;
import Base.AlunoView;
import SQLInsertion.AlunoSQL;

public class AlunoController implements AlunoView {
    private final AlunoDomain aluno = new AlunoDomain();
    private final AlunoSQL alunoSQL = new AlunoSQL();
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    
    private final Scanner scan = new Scanner(System.in);
    
    
    @Override
    public void menuAluno() {
        System.out.println("Gerenciamento de Cadastros dos Alunos:");
        System.out.println("(1) Cadastrar");
        System.out.println("(2) Listar");
        System.out.println("(3) Deletar");
        System.out.println("(4) Atualizar");
        System.out.println("Escolha: ");
        String decisao = "" + scan.next();
        
        switch(decisao){
            case "1":
                cadastrarAluno();
                break;
            case "2":
                listarAluno();
                break;
            case "3":
                removerAluno();
                break;
            case "4":
                alterarAluno();
                break;
            default:
                System.out.println("Operação finalizada.");
                break;
                
        }
    }
    
    @Override
    public void cadastrarAluno() {
        alunoSQL.setConnection(connection);
        
        System.out.println("Insira o nome do aluno: ");
        aluno.setNome(scan.next());
        
        alunoSQL.inserir(aluno);
        database.desconectar(connection);
    }

    @Override
    public void listarAluno() {
        alunoSQL.setConnection(connection);
        
        alunoSQL.listar().forEach((a) -> {
            System.out.println("ID: " + a.getIdAluno());
            System.out.println("Nome: " + a.getNome());
        });
        database.desconectar(connection);
    }

    @Override
    public void removerAluno() {
        alunoSQL.setConnection(connection);
        
        System.out.println("Delete um ID: ");
        aluno.setIdAluno(scan.nextInt());
        alunoSQL.buscar(aluno);
        
        System.out.println("Apagar o aluno: " + aluno.getNome() + "?");
        System.out.println("Y - Sim / N - Não");
        String decisao = scan.next();
        
        if("Y".equals(decisao) || "y".equals(decisao)){
            alunoSQL.remover(aluno);
            System.out.println("Aluno apagado.");
        }else if("N".equals(decisao) || "n".equals(decisao)){
            System.out.println("Aluno não apagado.");
        }else{
            System.out.println("Comando Incorreto.");
        }
        database.desconectar(connection);
    }

    @Override
    public void alterarAluno() {
        alunoSQL.setConnection(connection);
        
        System.out.println("Digite uma ID: ");
        aluno.setIdAluno(scan.nextInt());
        alunoSQL.buscar(aluno);
        
        System.out.println("Informe o nome: ");
        aluno.setNome(scan.next());
        
        alunoSQL.alterar(aluno);
        database.desconectar(connection);
    } 
}

