import axios from "../api/axiosInstance";

const list = () => axios.get("/usuarios").then(r => r.data);
const getById = (id) => axios.get(`/usuarios/${id}`).then(r => r.data);
const create = (payload) => axios.post("/usuarios", payload).then(r => r.data);
const update = (id, payload) => axios.put(`/usuarios/${id}`, payload).then(r => r.data);
const remove = (id) => axios.delete(`/usuarios/${id}`).then(r => r.data);

export default { list, getById, create, update, remove };
