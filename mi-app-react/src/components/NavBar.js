import React from "react";
import { Link, useNavigate } from "react-router-dom";
import authService from "../services/authService";

export default function NavBar() {
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const logout = () => {
    authService.logout();
    navigate("/login");
  };

  return (
    <nav>
      <Link to="/">Inicio</Link>
      {token && <>
        <Link to="/usuarios">Usuarios</Link>
        <Link to="/vehiculos">Vehículos</Link>
        <button onClick={logout}>Cerrar sesión</button>
      </>}
      {!token && <Link to="/login">Login</Link>}
    </nav>
  );
}
