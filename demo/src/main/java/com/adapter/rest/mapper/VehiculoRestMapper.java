package com.adapter.rest.mapper;

import com.adapter.rest.dto.VehiculoRequest;
import com.example.demo.core.domain.entity.Categoria;
import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.domain.valueObject.Capacidad;
import com.example.demo.core.domain.valueObject.Color;
import com.example.demo.core.domain.valueObject.Kilometraje;
import com.example.demo.core.domain.valueObject.MarcaModelo;
import com.example.demo.core.domain.valueObject.Motor;
import com.example.demo.core.domain.valueObject.Placa;

public class VehiculoRestMapper {
    public static VehiculoRequest toRequest(Vehiculo v) {
        VehiculoRequest e = new VehiculoRequest();
        e.setId(v.getIdVehiculo());
        e.setPlaca(v.getPlaca().getValor());
        e.setMarca(v.getMarcaModelo().getMarca());
        e.setModelo(v.getMarcaModelo().getModelo());
        e.setVersion(v.getMarcaModelo().getVersion());
        e.setColor(v.getColor().getValor());
        e.setNumPuestos(v.getCapacidad().getNumPuestos());
        e.setNumPuertas(v.getCapacidad().getNumPuertas());
        e.setCombustible(v.getMotor().getCombustible());
        e.setKilometros(v.getKilometraje().getValor());
        e.setCilindraje(v.getMotor().getCilindraje());
        e.setCategoria(v.getCategoria().getTipo());
        return e;
    }

    public static Vehiculo toDomain(VehiculoRequest e) {
        return Vehiculo.crear(
                e.getId(),
                new Placa(e.getPlaca()),
                new MarcaModelo (e.getMarca(), e.getModelo(), e.getVersion()),
                new Color(e.getColor()),
                new Motor(e.getCilindraje(), e.getCombustible()),
                new Capacidad(e.getNumPuestos(), e.getNumPuertas()),
                new Kilometraje(e.getKilometros()),
                new Categoria(e.getCategoria(), null)
        );
    }
}
