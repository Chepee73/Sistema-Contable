
public class Cuenta 
{
	public Cuenta(float saldo, TipoCuenta tipo, Cliente owner, String clave)
	{
		super();
		this.id = nextId++;
		this.saldo = saldo;
		this.tipo = tipo;
		this.owner = owner;
		this.clave = clave;
	}
	public int getId()
	{
		return id;
	}
	public enum TipoCuenta
	{
		STANDARD,
		GOLD,
		PLATINUM
	}
	
	public boolean ValidarClave(String clave)
	{
		return clave.equals(this.clave);
	}
	public float getSaldo()
	{
		return saldo;
	}
	
	public void depositar(float monto)
	{
		if(monto > 0)
		{			
			this.saldo += monto;
		}
	}
	
	public void extraer(float monto)
	{
		if(monto <= getSaldo())
		{
			this.saldo -= saldo;
		}
	}
	
	private static int nextId = 1;
	
	private int id;
	private float saldo;
	private TipoCuenta tipo;
	private Cliente owner;
	private String clave;
}
