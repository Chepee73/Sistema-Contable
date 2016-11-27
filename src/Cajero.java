import java.util.ArrayList;
import java.util.Date;


public class Cajero
{
	private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	private static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();

	public static ArrayList<Transaccion> getTransacciones()
	{
		return transacciones;
	}

	public static void setTransacciones(ArrayList<Transaccion> transacciones)
	{
		Cajero.transacciones = transacciones;
	}

	public static ArrayList<Cuenta> getCuentas()
	{
		return cuentas;
	}
	
	public static void setCuentas(ArrayList<Cuenta> cuentas)
	{
		Cajero.cuentas = cuentas;
	}
	private static Cuenta containsCuenta(int idCuenta)
	{
		for(Cuenta cuen : cuentas)
		{
			if(cuen.getId() == idCuenta)
				return cuen;
		}
		return null;
	}
	public static Cuenta login(int idCuenta, String clave)
	{
		Cuenta cuen = containsCuenta(idCuenta);
		if(cuen != null)
		{
			if(cuen.ValidarClave(clave))
				return cuen;
		}
		return null;
	}
	public static void addCuenta(Cuenta cuenta)
	{
		if(!getCuentas().contains(cuenta))
			getCuentas().add(cuenta);
	}
	
	public static void depositar(Cuenta cuenta, float monto)
	{
		Cajero.addTransaccion(cuenta, monto, Transaccion.TipoTransaccion.DEPOSITO);
		cuenta.depositar(monto);
	}
	
	private static void addTransaccion(Transaccion transaccion)
	{
		getTransacciones().add(transaccion);
	}
	
	public static void addTransaccion(Cuenta cuenta, float monto, Transaccion.TipoTransaccion tipoTransaccion)
	{
		Transaccion transaccion = new Transaccion(cuenta, monto, new Date(), tipoTransaccion);
		addTransaccion(transaccion);
		addCuenta(cuenta);
		
	}
	
	
	public static ArrayList<Transaccion> getTransacciones(Cuenta cuenta)
	{
		ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>(); 
		
		int id = cuenta.getId();
		
		if(cuentas.contains(cuenta))
		{
			for(Transaccion trans : Cajero.getTransacciones())
			{
				if(trans.getIDCuenta() == id)
				{
					transacciones.add(trans);
				}
			}
		}
		return transacciones;
	}
	
	public static void extraer(Cuenta cuenta, float monto)
	{
		cuenta.extraer(monto);
	}
	
	public static void transferir(Cuenta emisor, int idReceptor, float monto)
	{
		Cuenta temp = containsCuenta(idReceptor);
		if(temp != null)
		{
			emisor.extraer(monto);
			temp.depositar(monto);
		}
	}
}
