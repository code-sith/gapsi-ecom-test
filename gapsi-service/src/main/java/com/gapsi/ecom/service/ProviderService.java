package com.gapsi.ecom.service;

import com.gapsi.ecom.dto.PaginatedResult;
import com.gapsi.ecom.dto.Provider;
import com.gapsi.ecom.entity.ProviderEntity;
import com.gapsi.ecom.exception.ApplicationException;

import java.util.List;

public interface ProviderService {

    /**
     * Converts a <see>Provider</see> object into a <see>ProviderEntity</see>
     * @param provider to transform
     * @return a ProviderEntity object
     * */
    ProviderEntity map(final Provider provider);
    /**
     * Converts a <see>ProviderEntity</see> object into a <see>Provider</see>
     * @param providerEntity to transform
     * @return a Provider object
     * */
    Provider map(final ProviderEntity providerEntity);
    /**
     * Creates a new record in the data base
     * @param provider to be saved
     * @return provider created
     * @throws com.gapsi.ecom.exception.DuplicateRecordException if the record already exists in the data base
     * */
    Provider createNewProvider(final Provider provider) throws ApplicationException;
    /**
     * fetch all providers in the data base
     * @param page number
     * @param size number of rows to fetch
     * @return <see>PaginatedResult</see>
     * */
    PaginatedResult fetchAllProviders(final int page, final int size);
    /**
     * deletes the providers given
     * @param toDelete providers list
     * */
    void deleteProviders(final List<Provider> toDelete);
}
