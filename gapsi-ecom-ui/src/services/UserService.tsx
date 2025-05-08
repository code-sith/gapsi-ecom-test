import axios from "axios";


const URI = "http://localhost:8080/v1/users";

const getUser = async () => {
    const response = await axios.get(`${URI}/1`);
    return response.data;
};

export const UserService = { getUser };