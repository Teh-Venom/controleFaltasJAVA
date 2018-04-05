package Controlador;

import java.sql.Connection;
import java.util.Scanner;
import SQLConnection.Database;
import SQLConnection.DatabaseFactory;
import SQLInsertion.AlunoSQL;
import SQLInsertion.FaltaSQL;

import SQLInsertion.MateriaSQL;
import java.time.LocalDate;
import Base.AlunoView;
import Base.FaltaView;
import Classes.AlunoDomain;
import Controlador.AlunoController;
import Controlador.MateriaController;

import Classes.FaltaDomain;

public class FaltaController implements FaltaView {
    private final FaltaDomain falta = new FaltaDomain();
    private final AlunoDomain aluno = new AlunoDomain();

    private final AlunoSQL alunoSQL = new AlunoSQL();
    private final FaltaSQL faltaSQL = new FaltaSQL();


    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    
    private final Scanner scan = new Scanner(System.in);
    
    
    @Override
    public void menuFalta() {
        System.out.println("Gerenciamento de Controle das Faltas:");
        System.out.println("(1) Marcar faltas do dia");
        System.out.println("(2) Mostrar Presenças/Faltas de um aluno");
        System.out.println("(3) Mostrar Presenças/Faltas de uma matéria");
        System.out.println("(4) Mostrar Presenças/Faltas de um dia");
        System.out.println("Escolha: ");
        String decisao = "" + scan.next();
        
        switch(decisao){
            case "1":
                cadastrarFalta();
                break;
            case "2":
                listarFaltasPesqAluno();
                break;
            case "3":
                listarFaltasPesqMateria();
                break;
            case "4":
                listarFaltasPesqDia();
                break;
            default:
                System.out.println("Operação finalizada.");
                break;
                
        }
    }
    
    @Override
    public void cadastrarFalta() {
        faltaSQL.setConnection(connection);

        System.out.println("Insira a ID do aluno:");
        falta.setIdAluno_Falta(scan.nextInt());

        System.out.println("Insira a ID da materia:");
        falta.setIdMateria_Falta(scan.nextInt());

        System.out.println("Insira o dia de hoje:");
        falta.setDiaFalta(scan.nextInt());

        System.out.println("Insira quantas faltas o aluno teve:");
        falta.setFaltas(scan.nextInt());

        System.out.println("Insira quantas presenças o aluno teve:");
        falta.setPresencas(scan.nextInt());

        faltaSQL.inserir(falta);
        database.desconectar(connection);
    }

    @Override
    public void listarFaltasPesqAluno() {
        faltaSQL.setConnection(connection);
        
        alunoSQL.listar().forEach((a) -> {
            System.out.println("ID: " + a.getIdAluno());
            System.out.println("Nome: " + a.getNome());
        });
        
        database.desconectar(connection);
    }

    @Override
    public void listarFaltasPesqMateria() {
       /* alunoSQL.setConnection(connection);
        
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
        }*/
    }

    @Override
    public void listarFaltasPesqDia() {
       /* alunoSQL.setConnection(connection);
        
        System.out.println("Digite uma ID: ");
        aluno.setIdAluno(scan.nextInt());
        alunoSQL.buscar(aluno);
        
        System.out.println("Informe o nome: ");
        aluno.setNome(scan.next());
        
        alunoSQL.alterar(aluno);*/
    }

}

