package com.gapsi.ecom.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PaginatedResult<T> {

    private int page;
    private int size;
    private long totalResults;
    private List<T> results;

    private PaginatedResult(){};

    public static <K> PaginatedResult getInstance(){
        return new PaginatedResult<K>();
    }

    public PaginatedResult currentPage(final int page){
        this.page = page;
        return this;
    }

    public PaginatedResult currentSize(final int size){
        this.size = size;
        return this;
    }

    public PaginatedResult totalRows(final long total){
        this.totalResults = total;
        return this;
    }

    public PaginatedResult rows(List<T> results){
        this.results = results;
        return this;
    }

}
