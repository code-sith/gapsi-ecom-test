import { ProviderModel } from "@/models/ProviderModel";
import axios from "axios";


const URI = "http://localhost:8080/v1/providers";

const fetchAll = async (page?:number, size?:number) => {
    const response = await axios.get(`${URI}?page=${page?page:0}&size=${size?size:0}`);
    return response.data;
};

const deleteProviders = async (request:DeleteRequest) => {
    return await axios.post(`${URI}/delete`, request);
};

const saveProvider = async (request:ProviderModel) => {
    return await axios.post(URI, request);
};

export const ProviderService = { 
    fetchAll, 
    deleteProviders, 
    saveProvider 
};

export interface DeleteRequest{
    providers:ProviderModel[];
}