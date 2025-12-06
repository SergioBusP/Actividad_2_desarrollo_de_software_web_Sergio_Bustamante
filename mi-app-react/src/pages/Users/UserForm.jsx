import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import userService from "../../services/userService";

export default function UserForm() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [form, setForm] = useState({ nombre: "", email: "", password: "" });

  useEffect(() => {
    if (id) {
      userService.getById(id).then(u => setForm({ nombre: u.nombre, email: u.email, password: "" })).catch(console.error);
    }
  }, [id]);

  const submit = async (e) => {
    e.preventDefault();
    try {
      if (id) {
        await userService.update(id, form);
      } else {
        await userService.create(form);
      }
      navigate("/usuarios");
    } catch (err) {
      console.error(err);
      alert("Error al guardar usuario");
    }
  };

  const setField = (k, v) => setForm(prev => ({ ...prev, [k]: v }));

  return (
    <div>
      <h2>{id ? "Editar Usuario" : "Nuevo Usuario"}</h2>
      <form onSubmit={submit}>
        <div>
          <label>Nombre</label><br />
          <input value={form.nombre} onChange={(e)=>setField("nombre", e.target.value)} required />
        </div>
        <div>
          <label>Email</label><br />
          <input type="email" value={form.email} onChange={(e)=>setField("email", e.target.value)} required />
        </div>
        <div>
          <label>Password {id ? "(dejar vacío para no cambiar)" : ""}</label><br />
          <input type="password" value={form.password} onChange={(e)=>setField("password", e.target.value)}  />
        </div>
        <div style={{ marginTop: 8 }}>
          <button type="submit">Guardar</button>
        </div>
      </form>
    </div>
  );
}
