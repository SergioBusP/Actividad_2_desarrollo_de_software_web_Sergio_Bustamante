package com.example.demo.core.domain.valueObject;

import java.util.Objects;
import java.util.Set;

import com.example.demo.core.domain.exception.*;

public final class Motor {
	private int cilindraje;
	private String combustible;
	
	private static final Set<String> COMBUSTIBLES_VALIDOS = Set.of(
			"gasolina", "diésel", "gas", "electrico", "hibrido"
    );
	
	public Motor(int cilindraje, String combustible) {
		
		if (cilindraje < 0) {
			throw new MotorInvalidoException("El cilindraje no puede ser menor que 0.");
		}
		if (combustible == null || combustible.isBlank()) {
            throw new MotorInvalidoException("El combustible no puede ser nulo o vacío");
        }
		
		String normalizado = combustible.trim().toLowerCase();
		
		if (!COMBUSTIBLES_VALIDOS.contains(normalizado)) {
            throw new MotorInvalidoException("Combustible no permitido: " + combustible);
        }

		this.cilindraje = cilindraje;
        this.combustible = normalizado;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public String getCombustible() {
		return combustible;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motor)) return false;
        Motor motor = (Motor) o;
        return cilindraje == motor.cilindraje &&
               Objects.equals(combustible, motor.combustible);
    }

    @Override
    public int hashCode() { return Objects.hash(cilindraje, combustible); }

    @Override
    public String toString() {
        return cilindraje + "cc " + combustible;
    }
}
