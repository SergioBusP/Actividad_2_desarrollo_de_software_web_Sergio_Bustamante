import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import Dashboard from "./pages/Dashboard";
import UsersList from "./pages/Users/UsersList";
import UserForm from "./pages/Users/UserForm";
import VehiclesList from "./pages/Vehicles/VehiclesList";
import VehicleForm from "./pages/Vehicles/VehicleForm";
import RequireAuth from "./router/RequireAuth";
import NavBar from "./components/NavBar";

export default function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <Routes>
          <Route path="/login" element={<LoginPage />} />

          <Route element={<RequireAuth />}>
            <Route path="/" element={<Dashboard />} />
            <Route path="/usuarios" element={<UsersList />} />
            <Route path="/usuarios/nuevo" element={<UserForm />} />
            <Route path="/usuarios/editar/:id" element={<UserForm />} />
            <Route path="/vehiculos" element={<VehiclesList />} />
            <Route path="/vehiculos/nuevo" element={<VehicleForm />} />
            <Route path="/vehiculos/editar/:id" element={<VehicleForm />} />
          </Route>

          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </div>
    </>
  );
}
