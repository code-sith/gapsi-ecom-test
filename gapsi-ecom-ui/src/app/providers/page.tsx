"use client";

import { ServiceContext } from '@/context/ServiceContext';
import { ProviderModel } from '@/models/ProviderModel';
import { Alert, Box, Fab, Grid, Modal, Paper, Snackbar, SnackbarCloseReason } from '@mui/material';
import { DataGrid, GridCallbackDetails, GridColDef, GridPaginationModel, GridRowId, GridRowSelectionModel } from '@mui/x-data-grid';
import { useContext, useEffect, useState } from 'react';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import { DeleteRequest } from '@/services/ProviderService';
import ProviderForm from '../components/providerForm';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 700,
    bgcolor: 'background.paper',
    boxShadow: 24,
    p: 4,
  };

export default function ProvidersHome() {

    const { providerService } = useContext(ServiceContext);

    const [openModal, setOpenModal] = useState(false);
    const [openSB, setOpenSB] = useState(false);
    const [sbMessage, setSbMessage] = useState('');
    const [providers, setProviders] = useState<ProviderModel[]>([]);
    const [disableDelete, setDisableDelete] = useState<boolean>(true);
    const [selected, setSelected] = useState<ProviderModel[]>([]);
    const [totalRows, setTotalRows] = useState(0);
    const paginationModel = { page: 0, pageSize: 5 };

    const columns: GridColDef<(ProviderModel)>[] = [
        { field: 'id', headerName: 'ID', width: 10},
        { field: 'name', headerName: 'Proveedor', width: 300 },
        { field: 'address', headerName: 'Dirección', width: 400},
        { field: 'companyName', headerName: 'Razón social', width: 400},
    ];

    const selectionChange = (rowSelectionModel: GridRowSelectionModel, details: GridCallbackDetails) => {
        setSelected([]);
        const enableDelete = rowSelectionModel.ids && rowSelectionModel.ids.size > 0;
        const rows = rowSelectionModel.ids.values()
                        .map(gRowId => (details.api.getRow(gRowId.valueOf())) as ProviderModel)
                        .toArray();

        setSelected(rows);
        setDisableDelete(!enableDelete);
    };

    useEffect(()=>{
        fetchAll();
    }, []);

    function fetchAll(){
        providerService.fetchAll(paginationModel.page, paginationModel.pageSize).then(data => {
            paginationModel.page = data.page;
            paginationModel.pageSize = data.size;
            setTotalRows(data.totalResults);
            setProviders(data.results);
        });
    }

    function deleteProviders(){
        const request:DeleteRequest = {
            providers: selected
        }
        console.log(request);
        providerService.deleteProviders(request).then(()=>{
            // reload table
            setSbMessage('Proveedores eliminados con exito');
            setOpenSB(true);
            fetchAll();
            setSelected([]);
        });
    }

    function handleSave(){
        setSbMessage('Proveedor guardado con exito');
        setOpenSB(true);
        setOpenModal(false);
        fetchAll();
    }

    function handleCloseSB (
        event: React.SyntheticEvent | Event,
        reason?: SnackbarCloseReason,
    ){
        if (reason === 'clickaway') {
          return;
        }
    
        setOpenSB(false);
    };

    function handlePagination(model: GridPaginationModel, details: GridCallbackDetails){
        paginationModel.page = model.page;
        paginationModel.pageSize = model.pageSize;
        fetchAll();
    }

    return (
        <>
            <Snackbar
                open={openSB}
                autoHideDuration={6000}
                onClose={handleCloseSB}>
                
                <Alert
                    onClose={handleCloseSB}
                    severity="success"
                    variant="filled"
                    sx={{ width: '100%' }}
                >
                    {sbMessage}
                </Alert>
            </Snackbar>
            <Paper sx={{ width: '100%' }}>
                <Grid
                    spacing={2}
                    container
                    direction="row"
                    sx={{
                        justifyContent: "flex-end",
                        alignItems: "center",
                        padding: 5
                    }}
                >
                    <Fab size="small" color="success" aria-label="add" onClick={()=> setOpenModal(true)}>
                        <AddIcon />
                    </Fab>
                    <Fab 
                        size="small" 
                        color="error" 
                        aria-label="delete" 
                        disabled={disableDelete}
                        onClick={deleteProviders}>
                        <DeleteIcon />
                    </Fab>
                </Grid>
                
                <DataGrid
                    rows={providers}
                    columns={columns}
                    initialState={{ pagination: { paginationModel } }}
                    pageSizeOptions={[5, 10]}
                    checkboxSelection
                    sx={{ border: 0 }}
                    onRowSelectionModelChange={selectionChange}
                    paginationMode='server'
                    rowCount={totalRows}
                    onPaginationModelChange={handlePagination}
                />
            </Paper>
            <Modal
                open={openModal}
                onClose={()=> setOpenModal(false)}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box  sx={style}>
                    <ProviderForm onSave={handleSave}></ProviderForm>
                </Box>
                
            </Modal>
        </>
        
    );
}