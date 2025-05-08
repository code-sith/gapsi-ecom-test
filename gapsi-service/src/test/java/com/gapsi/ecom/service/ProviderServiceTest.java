package com.gapsi.ecom.service;


import com.gapsi.ecom.dto.Provider;
import com.gapsi.ecom.entity.ProviderEntity;
import com.gapsi.ecom.exception.ApplicationException;
import com.gapsi.ecom.exception.DuplicateRecordException;
import com.gapsi.ecom.repository.ProviderRepository;
import com.gapsi.ecom.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProviderServiceTest {

    @Mock
    private ProviderRepository providerRepository;
    @InjectMocks
    private ProviderServiceImpl providerService;

    @Test
    void testCreateProvider() throws ApplicationException {
        when(providerRepository.findByName(any())).thenReturn(Optional.empty());
        when(providerRepository.saveAndFlush(any())).thenReturn(buildEntity());

        Provider newProvider = providerService.createNewProvider(buildDto());
        Assertions.assertNotNull(newProvider);
        Assertions.assertNotNull(newProvider.getId());
    }

    @Test
    void testCreateProviderDuplicated() {
        when(providerRepository.findByName(any())).thenReturn(Optional.of(buildEntity()));

        Assertions.assertThrows(DuplicateRecordException.class, ()-> providerService.createNewProvider(buildDto()));
    }

    private Provider buildDto(){
        return Provider.builder()
                .name("provider test")
                .address("address")
                .companyName("company name")
                .build();
    }

    private ProviderEntity buildEntity(){
        return ProviderEntity.builder()
                .id(1113L)
                .name("provider test")
                .build();
    }
}
