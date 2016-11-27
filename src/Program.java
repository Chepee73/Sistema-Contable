import java.util.ArrayList;
import java.util.Scanner;


public class Program
{
	public static void menu(Cuenta cuenta)
	{
			int opcion = 0;
			System.out.print("BIENVENIDO A BANCO PATITO");
			do
			{			
				System.out.println("\n1.Ver saldo");
				System.out.println("2.Depositar");
				System.out.println("3.Ver transacciones");
				System.out.println("4.Extraer");
				System.out.println("5.Transferir");
				System.out.println("0.Salir");
				System.out.print("Opcion: ");
				opcion = new Scanner(System.in).nextInt();
				switch(opcion)
				{
				case 1:
					System.out.println("Su saldo es: " + cuenta.getSaldo());
					break;
				case 2:
					System.out.print("Ingrese monto a depositar: ");
					float tempMonto = new Scanner(System.in).nextFloat();
					Cajero.depositar(cuenta, tempMonto);
					System.out.print("Su saldo actual es: " + cuenta.getSaldo());
					break;
				case 3:
					ArrayList<Transaccion> tempTransacciones = Cajero.getTransacciones(cuenta);
					System.out.println("Transacciones realizadas: ");
					for(Transaccion trans : tempTransacciones)
					{
						System.out.println(trans.getId() + ": " + trans.getTipoTransaccion() + " $" + trans.getMonto() + " (" + trans.getFecha() + ")" );
					}
					break;
				case 4:
					System.out.print("Ingrese monto a extraer: ");
					tempMonto = new Scanner(System.in).nextFloat();
					Cajero.extraer(cuenta, tempMonto);
					System.out.print("Su saldo actual es: " + cuenta.getSaldo());
					break;
				case 5:
					int tempIdCuentaTransf;
					do
					{
						System.out.print("Ingrese id de cuenta a transferir: ");
						tempIdCuentaTransf = new Scanner(System.in).nextInt();
						if(!Cajero.existeCuenta(tempIdCuentaTransf))
							System.out.println("CUENTA INEXISTENTE");
					}while(!Cajero.existeCuenta(tempIdCuentaTransf));
					System.out.print("Ingrese monto a transferir: ");
					tempMonto = new Scanner(System.in).nextFloat();
					Cajero.transferir(cuenta, tempIdCuentaTransf, tempMonto);
					System.out.print("Su saldo actual es: " + cuenta.getSaldo());
					break;
				}
			} while(opcion != 0); 
	}
	
	public static Cuenta login()
	{
		Cuenta tempCuenta;
		String tempClave;
		int tempID;
		do
		{
			System.out.print("Ingrese id: ");
			tempID = new Scanner(System.in).nextInt();	
			if(!Cajero.existeCuenta(tempID))
				System.out.println("CUENTA INEXISTENTE");
		}while(!Cajero.existeCuenta(tempID));
		do
		{
			System.out.print("Ingrese clave: ");
			tempClave = new Scanner(System.in).nextLine();
			tempCuenta = Cajero.login(tempID, tempClave);
			if(tempCuenta == null)
			{
				System.out.println("CLAVE INCORRECTA.");
			}
		} while(tempCuenta == null);
		return tempCuenta;
	}
	
	public static void main(String[] args)
	{
		Cajero.addCuenta(new Cuenta(500.0f, Cuenta.TipoCuenta.GOLD, new Cliente("Cezar", "Azevedo", "93965081"), "180495"));
		Cajero.addCuenta(new Cuenta(500.0f, Cuenta.TipoCuenta.PLATINUM, new Cliente("Diego", "Fernandez", "40542434"), "594700"));
		
		Cuenta tempCuenta;
		do
		{
			tempCuenta = login();
			menu(tempCuenta);
		}while(true);
	}
}
