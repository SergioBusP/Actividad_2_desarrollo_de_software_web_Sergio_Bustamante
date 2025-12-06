import axios from "../api/axiosInstance";

const list = () => axios.get("/vehiculos").then(r => r.data);
const getById = (id) => axios.get(`/vehiculos/${id}`).then(r => r.data);
const create = (payload) => axios.post("/vehiculos", payload).then(r => r.data);
const update = (id, payload) => axios.put(`/vehiculos/${id}`, payload).then(r => r.data);
const remove = (id) => axios.delete(`/vehiculos/${id}`).then(r => r.data);

export default { list, getById, create, update, remove };
