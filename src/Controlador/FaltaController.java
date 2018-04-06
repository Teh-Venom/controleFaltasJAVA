package Controlador;

import java.sql.Connection;
import java.util.Scanner;
import SQLConnection.Database;
import SQLConnection.DatabaseFactory;
import SQLInsertion.AlunoSQL;
import SQLInsertion.FaltaSQL;
import java.util.Iterator;

import SQLInsertion.MateriaSQL;
import java.time.LocalDate;
import Base.AlunoView;
import Base.FaltaView;
import Classes.AlunoDomain;
import Controlador.AlunoController;
import Controlador.MateriaController;

import Classes.FaltaDomain;
import Classes.MateriaDomain;
import java.util.ArrayList;
import java.util.List;

public class FaltaController implements FaltaView {
    private final FaltaDomain falta = new FaltaDomain();
    private final AlunoDomain aluno = new AlunoDomain();
    private final MateriaDomain materia = new MateriaDomain();

    private final AlunoSQL alunoSQL = new AlunoSQL();
    private final FaltaSQL faltaSQL = new FaltaSQL();
    private final MateriaSQL materiaSQL = new MateriaSQL();


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
    }

    @Override
    public void listarFaltasPesqAluno() {
        faltaSQL.setConnection(connection);
        alunoSQL.setConnection(connection);
        materiaSQL.setConnection(connection);
        
        System.out.println("Insira a ID do aluno:");
        falta.setIdAluno_Falta(scan.nextInt());
             
        aluno.setIdAluno(falta.getIdAluno_Falta());
        
        List<FaltaDomain> listaFaltas = new ArrayList();
        listaFaltas = faltaSQL.buscarFaltaPorAluno(aluno); //temos todas as faltas do aluno
        
        
        alunoSQL.buscar(aluno); //temos o aluno
        
        List<MateriaDomain> listaMaterias = new ArrayList();
        listaMaterias = materiaSQL.listar(); //temos todas as materias
        
        //começando a mostrar dados
        
        System.out.println("Nome do aluno:");
        System.out.println("--> " + aluno.getNome());
        
        for(MateriaDomain x: listaMaterias){
            int faltasTotal = 0;
            int presencasTotal = 0;
            System.out.println("Matéria: " + x.getNomeMateria());
            
            for(FaltaDomain somador : listaFaltas)
            {
                if (somador.getIdMateria_Falta() == x.getIdMateria()){
                    faltasTotal += somador.getFaltas();
                    presencasTotal += somador.getPresencas();
                }   
            }
            
            System.out.println("Presenças: " + presencasTotal 
                    + " /Faltas: " + faltasTotal);
            
            System.out.println("Horas No Curso: " + x.getHorasAula());
            System.out.println("");
            System.out.println("------------------------");
         }        
    }

    @Override
    public void listarFaltasPesqMateria() {
        faltaSQL.setConnection(connection);
        alunoSQL.setConnection(connection);
        materiaSQL.setConnection(connection);
        
        System.out.println("Insira a ID da Matéria:");
        materia.setIdMateria(scan.nextInt());
        
        materiaSQL.buscar(materia); //dados da matéria obtidos
        System.out.println("Matéria: " + materia.getNomeMateria());
        
        List<AlunoDomain> listaAlunos = alunoSQL.listar();
        List<FaltaDomain> listaFaltas = faltaSQL.buscarFaltaPorMateria(materia);
        
        for (AlunoDomain x : listaAlunos){
            int faltasAluno = 0;
            int presencasAluno = 0;
            
            for(FaltaDomain somador : listaFaltas)
            {
                if (somador.getIdAluno_Falta() == x.getIdAluno()){
                    faltasAluno += somador.getFaltas();
                    presencasAluno += somador.getPresencas();
                }   
            }
            
            System.out.println("Aluno: " + x.getNome());
            System.out.println("Faltas: " + faltasAluno 
                             + " /Presenças: " + presencasAluno);
            System.out.println("\n----------------------");
        }
    }

    @Override
    public void listarFaltasPesqDia() {
        faltaSQL.setConnection(connection);
        alunoSQL.setConnection(connection);
        materiaSQL.setConnection(connection);
        
        System.out.println("Insira o dia das Faltas:");
        falta.setDiaFalta(scan.nextInt());
        List<FaltaDomain> listaFaltas = faltaSQL.buscarFaltaPorDia(falta);
        List<AlunoDomain> listaAlunos = alunoSQL.listar();
        List<MateriaDomain> listaMaterias = materiaSQL.listar();
        
        System.out.println("Dia: " + falta.getDiaFalta());
        
        
        for (FaltaDomain x : listaFaltas){
            for (AlunoDomain y : listaAlunos){
                if (x.getIdAluno_Falta() == y.getIdAluno()) {
                    System.out.println("Aluno: " + y.getNome());
                    System.out.println("Faltas: " + x.getFaltas());
                    System.out.println("\n----------------------");
                }
            }
        }
    }
}

