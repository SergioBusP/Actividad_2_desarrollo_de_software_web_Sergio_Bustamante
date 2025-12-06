import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import authService from "../services/authService";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const location = useLocation();

  const from = (location.state && location.state.from) || "/";

  const submit = async (e) => {
    e.preventDefault();
    try {
      const data = await authService.login(email, password);
      const token = data.token || data.accessToken || data.jwt;
      if (!token) throw new Error("No token in response");
      authService.saveToken(token);
      navigate(from, { replace: true });
    } catch (err) {
      console.error(err);
      setError(err.response?.data?.message || err.message || "Login failed");
    }
  };

  return (
    <div style={{ maxWidth: 420, margin: "30px auto" }}>
      <h2>Iniciar sesión</h2>
      <form onSubmit={submit}>
        <div>
          <label>Email</label><br />
          <input value={email} onChange={(e)=>setEmail(e.target.value)} required/>
        </div>
        <div>
          <label>Password</label><br />
          <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)} required/>
        </div>
        <div style={{ marginTop: 12 }}>
          <button type="submit">Login</button>
        </div>
        {error && <div style={{ color: "red", marginTop: 8 }}>{error}</div>}
      </form>
    </div>
  );
}
