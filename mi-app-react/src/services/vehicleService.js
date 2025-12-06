import axios from "../api/axiosInstance";

const list = () => axios.get("/api/vehiculos").then(r => r.data);
const getById = (id) => axios.get(`/api/vehiculos/${id}`).then(r => r.data);
const create = (payload) => axios.post("/api/vehiculos", payload).then(r => r.data);
const update = (id, payload) => axios.put(`/api/vehiculos/${id}`, payload).then(r => r.data);
const remove = (id) => axios.delete(`/api/vehiculos/${id}`).then(r => r.data);

export default { list, getById, create, update, remove };
