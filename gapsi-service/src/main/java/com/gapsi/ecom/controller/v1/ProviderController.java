package com.gapsi.ecom.controller.v1;

import com.gapsi.ecom.dto.DeleteProviderRequest;
import com.gapsi.ecom.dto.PaginatedResult;
import com.gapsi.ecom.dto.Provider;
import com.gapsi.ecom.exception.ApplicationException;
import com.gapsi.ecom.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Arrays;

@RestController
@RequestMapping("/v1/providers")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProviderController {

    private final ProviderService providerService;

    /**
     * Endpoint to fetch all the existing providers
     * @param page Number of the page
     * @param size Number of results to fetch
     * @return paginated results
     * */
    @GetMapping
    public PaginatedResult getAllProviders(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size){
        return providerService.fetchAllProviders(page, size);
    }

    /**
     * Endpoint to create a new provider
     * @param provider data
     * @return a provider object that was created
     * */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Provider createProvider(@RequestBody Provider provider) throws ApplicationException {
        return providerService.createNewProvider(provider);
    }

    /**
     * Endpoint to delete the providers given
     * @param deleteProviderRequest contains a list of provider ids to delete
     * */
    @PostMapping("/delete")
    public void deleteProvider(@RequestBody DeleteProviderRequest deleteProviderRequest){
        this.providerService.deleteProviders(Arrays.asList(deleteProviderRequest.providers()));
    }
}
