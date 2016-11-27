
public class Cliente
{
	int id;
	String nombre;
	String apellido;
	String dni;
	public Cliente(String nombre, String apellido, String dni)
	{
		super();
		this.id = nextId++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	private static int nextId = 1;
}
