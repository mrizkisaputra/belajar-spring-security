package com.mrizkisaputra.model.response;

import lombok.Data;

@Data
public class PagingResponse {
    private Long totalElements;
    
    private Integer totalPages;
    
    private Integer size;
    
    public PagingResponse() { }
    
    public PagingResponse(Long totalElements, Integer totalPages, Integer size) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.size = size;
    }
}
