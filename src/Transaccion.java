import java.util.ArrayList;
import java.util.Date;




public class Transaccion
{
	public enum TipoTransaccion
	{
		DEPOSITO,
		EXTRACCION,
		TRANSFERENCIA
	};
	
	private int id;
	private TipoTransaccion tipoTransaccion;
	private Cuenta cuenta;
	private float monto;
	private Date fecha;

	private static int nextId = 1;
	
	
	public int getIDCuenta()
	{
		return cuenta.getId();
	}


	public int getId()
	{
		return id;
	}


	public TipoTransaccion getTipoTransaccion()
	{
		return tipoTransaccion;
	}


	public float getMonto()
	{
		return monto;
	}


	public Date getFecha()
	{
		return fecha;
	}


	public Transaccion(Cuenta cuenta, float monto, Date fecha, TipoTransaccion tipoTransaccion)
	{
		super();
		this.id = nextId++;
		this.cuenta = cuenta;
		this.monto = monto;
		this.fecha = fecha;
		this.tipoTransaccion = tipoTransaccion;
	}
	
	
	
}

