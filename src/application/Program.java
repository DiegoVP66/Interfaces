package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Dados do contrato");
		try {
			System.out.print("Número do contrato: ");
			int contractNumber = sc.nextInt();
			System.out.print("Data do contrato (dd/MM/yyyy): ");
			Date contractData = sdf.parse(sc.next());
			System.out.print("Valor total do contrato: ");
			double totalValue = sc.nextDouble();
			
			// Instanciando novo Contrato com os parâmetros número, data e valor 
			Contract contract = new Contract(contractNumber, contractData, totalValue);
			System.out.println();
			System.out.println(contract.getContractNumber()+", "+sdf.format(contractData)+", "+contract.getTotalValue());

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}catch(InputMismatchException e) {
			System.out.println("Valor inválido!");
			e.printStackTrace();
		}

		sc.close();
	}

}
