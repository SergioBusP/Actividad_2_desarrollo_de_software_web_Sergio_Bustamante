import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import userService from "../../services/userService";

export default function UsersList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  const load = async () => {
    setLoading(true);
    try {
      setUsers(await userService.list());
    } catch (e) {
      console.error(e);
      alert("Error al cargar usuarios");
    } finally {
      setLoading(false);
    }
  };

  useEffect(()=>{ load(); }, []);

  const handleDelete = async (id) => {
    if (!window.confirm("Confirm delete?")) return;
    try {
      await userService.remove(id);
      load();
    } catch (e) {
      console.error(e);
      alert("Error al eliminar");
    }
  };

  return (
    <div>
      <h2>Usuarios</h2>
      <Link to="/usuarios/nuevo"><button>Nuevo</button></Link>
      {loading ? <p>Cargando...</p> : (
        <table>
          <thead><tr><th>ID</th><th>Nombre</th><th>Email</th><th>Activo</th><th>Acciones</th></tr></thead>
          <tbody>
            {users.map(u=>(
              <tr key={u.id}>
                <td>{u.id}</td>
                <td>{u.nombre || u.name || "-"}</td>
                <td>{u.email}</td>
                <td>{u.activo ? "Sí" : "No"}</td>
                <td>
                  <Link to={`/usuarios/editar/${u.id}`}><button>Editar</button></Link>
                  <button onClick={()=>handleDelete(u.id)}>Eliminar</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
