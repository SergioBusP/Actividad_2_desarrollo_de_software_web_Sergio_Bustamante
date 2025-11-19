package com.adapter.rest.controller;

import com.adapter.rest.dto.VehiculoRequest;
import com.adapter.rest.dto.VehiculoResponse;

import org.springframework.web.bind.annotation.*;
import com.adapter.rest.mapper.VehiculoRestMapper;
import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.in.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final CrearVehiculoUseCase crearVehiculoUseCase;
    private final ActualizarVehiculoUseCase actualizarVehiculoUseCase;
    private final EliminarVehiculoUseCase eliminarVehiculoUseCase;
    private final ObtenerVehiculoUseCase ObtenerVehiculoUseCase;
    private final ListarVehiculosUseCase listarVehiculosUseCase;

    public VehiculoController(
            CrearVehiculoUseCase crear,
            ActualizarVehiculoUseCase actualizar,
            EliminarVehiculoUseCase eliminar,
            ObtenerVehiculoUseCase obtener,
            ListarVehiculosUseCase listar
    ) {
        this.crearVehiculoUseCase = crear;
        this.actualizarVehiculoUseCase = actualizar;
        this.eliminarVehiculoUseCase = eliminar;
        this.ObtenerVehiculoUseCase = obtener;
        this.listarVehiculosUseCase = listar;
    }

    @PostMapping
    public VehiculoResponse crear(@RequestBody VehiculoRequest req) {
        Vehiculo v = crearVehiculoUseCase.ejecutar(VehiculoRestMapper.toDomain(req));
        return toResponse(v);
    }

    @PutMapping("/{id}")
    public VehiculoResponse actualizar(@PathVariable UUID id, @RequestBody VehiculoRequest req) {
        Vehiculo v = actualizarVehiculoUseCase.ejecutar(id, VehiculoRestMapper.toDomain(req));
        return toResponse(v);
    }

    @GetMapping("/{id}")
    public VehiculoResponse obtener(@PathVariable UUID id) {
        return toResponse(ObtenerVehiculoUseCase.ejecutar(id));
    }

    @GetMapping
    public List<VehiculoResponse> listar() {
        return listarVehiculosUseCase.ejecutar().stream()
                .map(this::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable UUID id) {
        eliminarVehiculoUseCase.ejecutar(id);
    }

    private VehiculoResponse toResponse(Vehiculo v) {
        return new VehiculoResponse(
                v.getIdVehiculo(),
                v.getPlaca().getValor(),
                v.getMarcaModelo().getMarca(),
                v.getMarcaModelo().getModelo(),
                v.getMarcaModelo().getVersion(),
                v.getColor().getValor(),
                v.getCapacidad().getNumPuestos(),
                v.getCapacidad().getNumPuertas(),
                v.getMotor().getCombustible(),
                v.getKilometraje().getValor(),
                v.getMotor().getCilindraje(),
                v.getCategoria().getTipo()
        );
    }
}
