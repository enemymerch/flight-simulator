package com.mcan.finartz.service;

import com.mcan.finartz.service.dto.PurchaseDto;

public interface PurchaseService extends BaseService<PurchaseDto> {
    PurchaseDto purchase(PurchaseDto purchaseDto);
    void cancelPurchase(Long id);
}
