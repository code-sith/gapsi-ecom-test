package com.gapsi.ecom.service.impl;

import com.gapsi.ecom.dto.PaginatedResult;
import com.gapsi.ecom.dto.Provider;
import com.gapsi.ecom.entity.ProviderEntity;
import com.gapsi.ecom.exception.ApplicationException;
import com.gapsi.ecom.exception.DuplicateRecordException;
import com.gapsi.ecom.repository.ProviderRepository;
import com.gapsi.ecom.service.ProviderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    public ProviderEntity map(Provider provider) {
        return ProviderEntity.builder()
                .id(provider.getId())
                .address(provider.getAddress())
                .name(provider.getName())
                .companyName(provider.getCompanyName())
                .build();
    }

    @Override
    public Provider map(ProviderEntity providerEntity) {
        return Provider.builder()
                .id(providerEntity.getId())
                .name(providerEntity.getName())
                .address(providerEntity.getAddress())
                .companyName(providerEntity.getCompanyName())
                .build();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public Provider createNewProvider(Provider provider) throws ApplicationException {
        log.info("checking if provider name is available");
        // if provider does exist then throw a conflict error
        if(providerRepository.findByName(provider.getName()).isPresent()){
            log.error("a provider with that name already exists");
            throw new DuplicateRecordException();
        }
        log.info("creating new provider");
        ProviderEntity providerEntity = this.providerRepository.saveAndFlush(this.map(provider));
        log.info("provider has been created");
        return this.map(providerEntity);
    }

    @Override
    public PaginatedResult fetchAllProviders(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProviderEntity> pageResult = this.providerRepository.findAll(pageRequest);
        return PaginatedResult.getInstance()
                .currentPage(page)
                .currentSize(size)
                .totalRows(pageResult.getTotalElements())
                .rows(pageResult.stream().map(entity -> map(entity)).toList());
    }

    @Override
    public void deleteProviders(List<Provider> toDelete) {
        log.info("deleting {} providers", toDelete.size());
        List<Long> ids = toDelete.stream().map(Provider::getId).toList();
        this.providerRepository.deleteAllById(ids);
        log.info("all providers has been deleted");
    }
}
