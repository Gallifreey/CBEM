package com.sd.entity.saler;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ledger {
    private List<InfoData> infoDataList;
    private List<PaymentData> paymentDataList;
}
