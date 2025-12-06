import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import vehicleService from "../../services/vehicleService";

export default function VehiclesList() {
  const [vehicles, setVehicles] = useState([]);

  const load = async () => {
    try {
      setVehicles(await vehicleService.list());
    } catch (e) {
      console.error(e);
      alert("Error al cargar vehículos");
    }
  };

  useEffect(()=>{ load(); }, []);

  const del = async (id) => {
    if (!window.confirm("Eliminar vehículo?")) return;
    await vehicleService.remove(id);
    load();
  };

  return (
    <div>
      <h2>Vehículos</h2>
      <Link to="/vehiculos/nuevo"><button>Nuevo</button></Link>
      <table>
        <thead><tr><th>ID</th><th>Placa</th><th>Marca</th><th>Modelo</th><th>Acciones</th></tr></thead>
        <tbody>
          {vehicles.map(v => (
            <tr key={v.id}>
              <td>{v.id}</td>
              <td>{v.placa}</td>
              <td>{v.marca}</td>
              <td>{v.modelo}</td>
              <td>
                <Link to={`/vehiculos/editar/${v.id}`}><button>Editar</button></Link>
                <button onClick={()=>del(v.id)}>Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
