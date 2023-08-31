package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os(){
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos() {
		String os = os();
		String process = "";
		if (os.contains("Windows")) {
			process = "TASKLIST /FO TABLE";
		}
		else if(os.contains("Linux")) {
			process = "ps -ef";
		}
		try {
			Process kill = Runtime.getRuntime().exec(process);
			InputStream fluxo = kill.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
			
	}
	
	public void mataPid(String Pid) {
		String os = os();
		String process = "";
		if (os.contains("Windows")) {
			process = "TASKKILL /PID " + Pid;
		}
		else if (os.contains("Linux")) {
			process = "kill -9 " + Pid;
		}
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
	
	public void mataNome(String Nome) {
		String os = os();
		String process = "";
		if (os.contains("Windows")) {
			process = "TASKKILL /IM " + Nome;
		}
		else if (os.contains("Linux")) {
			process = "pkill -f " + Nome;
		}
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
}

