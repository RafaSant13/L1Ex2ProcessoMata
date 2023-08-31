package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {

	public static void main(String arqs[]) {
		KillController kc = new KillController();
		int X = 0;
		while(X!=9) {
			X = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Lista Processos (Console)\n2 - Mata por PID\n3 - Mata por Nome\n9 - Fim"));
			switch (X) {
				case 1:
					kc.listaProcessos();
					break;
				case 2:
					String Pid = JOptionPane.showInputDialog("Insira o PID do Processo: ");
					kc.mataPid(Pid);
					break;
				case 3:
					String Nome = JOptionPane.showInputDialog("Insira o Nome do Processo: ");
					kc.mataNome(Nome);
					break;
				case 9:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Valor Inválido");
					break;
			}
		}
		
	}

}
