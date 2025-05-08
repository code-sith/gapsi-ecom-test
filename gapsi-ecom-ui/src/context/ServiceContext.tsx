import { ApplicationService } from "@/services/ApplicationService";
import { ProviderService } from "@/services/ProviderService";
import { UserService } from "@/services/UserService";
import React from "react";

export const ServiceContext = React.createContext({
    userService: UserService,
    applicationService: ApplicationService,
    providerService: ProviderService,
});

export const ServiceProvider = ServiceContext.Provider;