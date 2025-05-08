"use client";

import { ServiceContext } from "@/context/ServiceContext";
import { AppBar, Box, Toolbar } from "@mui/material";
import { useContext, useEffect, useState } from "react";

export default function Footer() {
    const { applicationService } = useContext(ServiceContext);
    const [appVersion, setAppVersion] = useState<string>('');

    useEffect(() => {
        fetchAppVersion();
    },[]);

    function fetchAppVersion(){
        applicationService.getAppVersion().then(data => setAppVersion(data));
    }

    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static" color="transparent">
                <Toolbar sx={{ justifyContent:'end'}}>
                        <p>version { appVersion } </p>
                </Toolbar>
            </AppBar>
      </Box>
    );
}