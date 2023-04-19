package proyecto;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Timer;
import proyecto.parqueo;


public class parqueo {
	int nBicicleta;
	int nDisponibilidad;
	Time nTiempoRenta;
	Time nTiempoDevolucion;
	double nPrecio;
	
	public parqueo(int nBicicleta, int nDisponibilidad, Time nTiempoRenta, Time nTiempoDevolucion, double nPrecio) {
		super();
		this.nBicicleta = nBicicleta;
		this.nDisponibilidad = nDisponibilidad;
		this.nTiempoRenta = nTiempoRenta;
		this.nTiempoDevolucion = nTiempoDevolucion;
		this.nPrecio = nPrecio;
	}
	
	public int getnBicicleta() {
		return nBicicleta;
	}


	public void setnBicicleta(int nBicicleta) {
		this.nBicicleta = nBicicleta;
	}

	public int getnDisponibilidad() {
		return nDisponibilidad;
	}

	public void setnDisponibilidad(int nDisponibilidad) {
		this.nDisponibilidad = nDisponibilidad;
	}

	public Time getnTiempoRenta() {
		return nTiempoRenta;
	}

	public void setnTiempoRenta(Time nTiempoRenta) {
		this.nTiempoRenta = nTiempoRenta;
	}

	public Time getnTiempoDevolucion() {
		return nTiempoDevolucion;
	}

	public void setnTiempoDevolucion(Time nTiempoDevolucion) {
		this.nTiempoDevolucion = nTiempoDevolucion;
	}

	public double getnPrecio() {
        return nPrecio;
    }

    public void setnPrecio(double nPrecio) {
        this.nPrecio = nPrecio;
    }


    void setnTiempoRenta(int i) {
        throw new UnsupportedOperationException("Esta acción todavía no se encuentra disponible en el programa. "); 
    }

    void setnTiempoDevolucion(int minuto) {
        throw new UnsupportedOperationException("Esta acción todavía no se encuentra disponible en el programa. "); 
        
    }




	
	
	
	
}
