package Base;

import Controlador.AlunoController;
import Controlador.FaltaController;
import Controlador.MateriaController;
import java.util.Scanner;

class Menu {
    Scanner scan = new Scanner(System.in);

    MateriaController materiacontrol = new MateriaController();
    AlunoController alunocontrol = new AlunoController();
    FaltaController faltacontrol = new FaltaController();
    int scanResult;
    void menuInicial(){
        while (scanResult!=4) {
            System.out.println("Sistema de controle de Faltas/n");
            System.out.println("(1) Gerenciar Matérias");
            System.out.println("(2) Gerenciar Aluno");
            System.out.println("(3) Gerenciar Faltas");
            System.out.println("(4) Terminar Operação");
            System.out.println("Marque sua Escolha: ");
            scanResult = scan.nextInt();

            if (scanResult==1) {
                materiacontrol.menuMateria();
            }
            if (scanResult==2) {
                alunocontrol.menuAluno();
            }
            if (scanResult==3) {
                faltacontrol.menuFalta();
            }
        }
    }
}

