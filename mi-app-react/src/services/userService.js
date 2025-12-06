import axios from "../api/axiosInstance";

const list = () => axios.get("/api/usuarios").then(r => r.data);
const getById = (id) => axios.get(`/api/usuarios/${id}`).then(r => r.data);
const create = (payload) => axios.post("/api/usuarios/registrar", payload).then(r => r.data);
const update = (id, payload) => axios.put(`/api/usuarios/${id}`, payload).then(r => r.data);
const remove = (id) => axios.delete(`/api/usuarios/${id}`).then(r => r.data);

export default { list, getById, create, update, remove };
