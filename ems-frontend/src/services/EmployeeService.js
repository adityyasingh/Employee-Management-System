import axios from "axios" ;

const REST_API_BASE_URL= 'http://13.127.158.152:8080/api/employees'

export const listEmployees = () => axios.get(REST_API_BASE_URL);

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employee) => axios.get(REST_API_BASE_URL + '/' + employee);

export const updateEmployee = (employeeId, employee) => axios.put(`${REST_API_BASE_URL}/${employeeId}`, employee);

export const deleteEmployee = (employeeId) => axios.delete(`${REST_API_BASE_URL}/${employeeId}`);
