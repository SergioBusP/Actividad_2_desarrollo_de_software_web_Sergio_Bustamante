package com.example.demo.adapter.databases.sql.mappers;

import com.example.demo.adapter.databases.sql.entity.VehiculoJpaEntity;
import com.example.demo.core.domain.entity.Categoria;
import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.domain.valueObject.*;

public class VehiculoJpaMapper {

    public static VehiculoJpaEntity toJpaEntity(Vehiculo v) {
        VehiculoJpaEntity e = new VehiculoJpaEntity();
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

    public static Vehiculo toDomain(VehiculoJpaEntity e) {
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
