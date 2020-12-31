import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CuentaCliente implements Serializable{

	// Atributos
	private String codigoCuenta;
	private String nombreCliente;
	private double saldoInicial;

	// Constructor
	public CuentaCliente(String codigoCuenta, String nombreCliente, double saldoInicial) {
		this.codigoCuenta = codigoCuenta;
		this.nombreCliente = nombreCliente;
		this.saldoInicial = saldoInicial;
	}

	// Getters and Setters
	public String getCodigoCuenta() {
		return codigoCuenta;
	}
	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	// Métodos
	public void mostrar() {
		System.out.println("nombre: "+this.nombreCliente);
		System.out.println("nro cuenta: "+this.codigoCuenta);
		System.out.println("monto: "+this.saldoInicial);
	}
	
	
	
}
