package com.core.domain.entity;

import java.util.Objects;
import java.util.UUID;
import com.core.domain.valueObject.*;
import com.core.domain.event.*;
import com.core.domain.exception.*;

public class Vehiculo {

		private final UUID idVehiculo;
		private final Placa placa;
		private final MarcaModelo marcaModelo;
		private final Color color;
		private final Motor motor;
		private final Capacidad capacidad;
		private Kilometraje kilometraje;
		private Categoria categoria;
		
		private Vehiculo(
				UUID idVehiculo,
				Placa placa,
				MarcaModelo marcaModelo,
				Color color,
				Motor motor,
				Capacidad capacidad,
				Kilometraje kilometraje,
				Categoria categoria
				) {
			if (placa == null) throw new IllegalArgumentException("El vehículo debe tener una placa");
	        if (marcaModelo == null) throw new IllegalArgumentException("El vehículo debe tener marca y modelo");
	        if (motor == null) throw new IllegalArgumentException("El vehículo debe tener motor");
	        if (capacidad == null) throw new IllegalArgumentException("El vehículo debe tener capacidad definida");
	        if (color == null) throw new IllegalArgumentException("El vehículo debe tener color");
	        if (kilometraje == null) throw new IllegalArgumentException("El vehículo debe tener kilometraje inicial");
	        if (categoria == null) throw new IllegalArgumentException("El vehículo debe tener categoría");
	        
	        this.idVehiculo = idVehiculo == null ? UUID.randomUUID() : idVehiculo;
	        this.placa = placa;
	        this.marcaModelo = marcaModelo;
	        this.color = color;
	        this.motor = motor;
	        this.capacidad = capacidad;
	        this.kilometraje = kilometraje;
	        this.categoria = categoria;
		}
		
		public static Vehiculo crear(
				UUID idVehiculo,
				Placa placa,
				MarcaModelo marcaModelo,
				Color color,
				Motor motor,
				Capacidad capacidad,
				Kilometraje kilometraje,
				Categoria categoria
				) {
			Vehiculo vehiculo = new Vehiculo(UUID.randomUUID(), placa, marcaModelo, color, motor, capacidad, kilometraje, categoria);
			return vehiculo;
		}
		
		public KilometrajeActualizado registrarKilometraje(int adicional) {
			int anterior = this.kilometraje.getValor();
		    this.kilometraje = this.kilometraje.incrementar(adicional);
		    if (anterior > this.kilometraje.getValor()) throw new KilometrajeInvalidoException();
		    return new KilometrajeActualizado(this.placa, anterior, this.kilometraje.getValor());
	        
	    }

	    public void cambiarCategoria(Categoria nuevaCategoria) {
	        if (nuevaCategoria == null) throw new CategoriaInvalidaException(nuevaCategoria);
	        this.categoria = nuevaCategoria;
	    }
	    
	    public UUID getIdVehiculo() { return idVehiculo; }
	    public Placa getPlaca() { return placa; }
	    public MarcaModelo getMarcaModelo() { return marcaModelo; }
	    public Color getColor() { return color; }
	    public Motor getMotor() { return motor; }
	    public Capacidad getCapacidad() { return capacidad; }
	    public Kilometraje getKilometraje() { return kilometraje; }
	    public Categoria getCategoria() { return categoria; }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Vehiculo)) return false;
	        Vehiculo vehiculo = (Vehiculo) o;
	        return Objects.equals(placa, vehiculo.placa);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(placa);
	    }
}
