"use client";

import { ServiceContext } from "@/context/ServiceContext";
import { UserModel } from "@/models/UserModel";
import { Button, Card, CardContent, CardMedia, Container, Stack, Typography } from "@mui/material";
import { useRouter } from "next/navigation";
import { useContext, useEffect, useState } from "react";

export default function WelcomePage() {
    const { userService } = useContext(ServiceContext);
    const [user, setUser] = useState<UserModel>();
    const router = useRouter();

    useEffect(() => {
        fetchUser();
    },[]);

    function fetchUser(){
        userService.getUser().then(data => setUser(data));
    }

    return (
        <Container maxWidth="lg">
            <Card raised={true} sx={{ display:'grid', justifyContent:'center'}}>
                <CardMedia
                    sx={{ width: 250, paddingLeft: 7 }}
                    component="img"
                    alt="user photo"
                    height="30"
                    image="/images/user.png"
                    title="user" />
                <CardContent>
                    { user ? (
                        <Stack spacing={2} sx={{ justifyContent: "center", alignItems:"center" }}>
                            <Typography variant="h5" gutterBottom>
                                Bienvenido {user.fullName}
                            </Typography>
                            <Button variant="contained" onClick={()=> router?.push("providers")}>Continuar</Button>
                        </Stack> )
                        : (<span>Loading...</span>)
                    }
                    
                </CardContent>
            </Card>
        </Container>    
    );
}