import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import vehicleService from "../../services/vehicleService";
import userService from "../../services/userService";

export default function VehicleForm() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [form, setForm] = useState({
    placa: "", marca: "", modelo: "", version: "", color: "", numPuestos: 4, numPuertas: 4,
    combustible: "", kilometros: 0, cilindraje: 0, categoria: "", usuarioId: null
  });
  const [users, setUsers] = useState([]);

  useEffect(()=>{
    userService.list().then(setUsers).catch(console.error);
    if (id) vehicleService.getById(id).then(v => setForm(v)).catch(console.error);
  }, [id]);

  const submit = async (e) => {
    e.preventDefault();
    try {
      if (id) await vehicleService.update(id, form);
      else await vehicleService.create(form);
      navigate("/vehiculos");
    } catch (err) {
      console.error(err);
      alert("Error al guardar vehículo");
    }
  };

  const setField = (k, v) => setForm(prev => ({ ...prev, [k]: v }));

  return (
    <div>
      <h2>{id ? "Editar Vehículo" : "Nuevo Vehículo"}</h2>
      <form onSubmit={submit}>
        <div><label>Placa</label><br/><input value={form.placa} onChange={(e)=>setField("placa", e.target.value)} required/></div>
        <div><label>Marca</label><br/><input value={form.marca} onChange={(e)=>setField("marca", e.target.value)} /></div>
        <div><label>Modelo</label><br/><input value={form.modelo} onChange={(e)=>setField("modelo", e.target.value)} /></div>
        <div><label>Usuario</label><br/>
          <select value={form.usuarioId || ""} onChange={(e)=>setField("usuarioId", e.target.value)}>
            <option value="">-- seleccionar --</option>
            {users.map(u => <option key={u.id} value={u.id}>{u.nombre} ({u.email})</option>)}
          </select>
        </div>
        <div style={{ marginTop: 8 }}>
          <button type="submit">Guardar</button>
        </div>
      </form>
    </div>
  );
}
