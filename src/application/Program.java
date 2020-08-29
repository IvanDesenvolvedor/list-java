package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employer> list = new ArrayList<>();

		System.out.print("How many employess will be registered? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Employe " + (i + 1) + ": ");
			System.out.print("Id:");
			Integer id = sc.nextInt();
            while(hasId(list, id)) {//enquanto tem esse id na lista
            	System.out.println("Esse id j� existe tnte novamente");
            	 id = sc.nextInt();
            }
            	
            	
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employer emp = new Employer(id, name, salary);
			list.add(emp);
		}
		System.out.println("Entre com o id do funcion�rio que vaiter o salario encrementado: ");
		int idsalary = sc.nextInt();
		
		//filtra so osquetiverem o idsalari
		//e pega o primeiro
		//se n�o existir retorna null
		Employer emp=list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		
		
		//Integer pos = position(list, idsalary);
		// se for igual a nulo quer dizerquen�o encontrou
		if (emp == null) {
			System.out.println("Esse id n�o existe: ");
		} else {// se existir eu pergunto a porcentagem eachamo a fun��o
			System.out.println("Entre com a porcentagem: ");
			double porcentage = sc.nextDouble();
			//list.get(pos).increaseSalary(percentage);
			emp.increaseSalary(porcentage);
		}
		System.out.println();
		System.out.println("Lista de funcion�rios: ");
		for (Employer e : list) {
			System.out.println(e);
		}

		sc.close();
	}

	// fun��o praretorna um id com a posi��o na lista
	public static Integer position(List<Employer> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			// se o iddalista for igual ao id que eu informei
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;// retorna -1 se n�o encontrar nada
	}
	
	public static boolean hasId(List<Employer> list,int id) {
		Employer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;//se for diferente de nulo encontrou
	}

}
