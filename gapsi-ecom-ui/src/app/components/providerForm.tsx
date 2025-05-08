import { ServiceContext } from "@/context/ServiceContext";
import { ProviderModel } from "@/models/ProviderModel";
import { Alert, AlertColor, AlertPropsColorOverrides, Button, FormControl, Grid, Input, InputLabel, TextField } from "@mui/material";
import { useContext, useState } from "react";
import WarningIcon from '@mui/icons-material/Warning';
import { OverridableStringUnion } from "@mui/types";

export interface AlertModel {
    severity?: OverridableStringUnion<AlertColor, AlertPropsColorOverrides>;
    show: boolean;
    message?: string;
}

export default function ProviderForm({ onSave }){

    const { providerService } = useContext(ServiceContext); 
    const [ alert, setAlert] = useState<AlertModel>({show: false});
    const [formData, setFormData] = useState({
        name: "",
        address: "",
        companyName: ""
    });

    function save(event:any){
        event.preventDefault();

        setAlert({show: false});
        
        const request:ProviderModel = {...formData};
        providerService.saveProvider(request)
            .then((data) => {
                setAlert({
                    show: true,
                    message: 'Proveedor guardado con exito',
                    severity: 'success'
                });
                onSave('Some data from child');
            })
            .catch((error) => {
                console.log(error);
                setAlert({
                    show: true,
                    message: 'Este proveedor ya existe, por favor intenta con uno nuevo',
                    severity: 'error'
                });
            });
    }

    function handleChange(event:any){
        const { name, value, type } = event.target;
        setFormData({...formData, [name]:value });
    }

    return (
        <>
            { (alert && alert.show) &&
                <Alert icon={<WarningIcon fontSize="inherit" />} severity={ alert.severity as  OverridableStringUnion<AlertColor, AlertPropsColorOverrides> }>
                    { alert.message }
                </Alert>
            }
            
            <form onSubmit={save}>
                <Grid container spacing={2}>
                    <Grid size={6}>
                        <FormControl required={true} fullWidth={true} variant="standard">
                            <InputLabel htmlFor="name">Proveedor</InputLabel>
                            <Input id="name" name="name" aria-describedby="provider-name" onChange={handleChange}/>
                        </FormControl>
                    </Grid>
                    <Grid size={6}>
                        <FormControl required={true} fullWidth={true} variant="standard">
                            <InputLabel htmlFor="companyName">Razón social</InputLabel>
                            <Input id="companyName" name="companyName" aria-describedby="provider-company" onChange={handleChange}/>
                        </FormControl>
                    </Grid>
                    <Grid size={12}>
                        <FormControl required={true} fullWidth={true} variant="standard">
                            <InputLabel htmlFor="address">Dirección</InputLabel>
                            <Input id="address" name="address" aria-describedby="provider-address" onChange={handleChange}/>
                        </FormControl>
                    </Grid>
                    <Grid size={12}>
                        <Button type="submit" variant="contained">Guardar</Button>
                    </Grid>
                </Grid>
            </form>
        </>
    );
}