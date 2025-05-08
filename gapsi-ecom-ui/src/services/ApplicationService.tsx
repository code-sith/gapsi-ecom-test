import axios from "axios";


const URI = "http://localhost:8080/version";

const getAppVersion = async () => {
    const response = await axios.get(URI);
    return response.data;
};

export const ApplicationService = { getAppVersion };