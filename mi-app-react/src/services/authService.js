import axios from "../api/axiosInstance";

const login = async (email, password) => {
  const res = await axios.post("/api/usuarios/login", { email, password });
  return res.data; // expects { token: "..." } or similar
};

const logout = () => {
  localStorage.removeItem("token");
};

const saveToken = (token) => localStorage.setItem("token", token);
const getToken = () => localStorage.getItem("token");

export default { login, logout, saveToken, getToken };
