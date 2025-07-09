package com.foodorderbe.foodorderbe_artifact.requests;

import java.util.ArrayList;
import java.util.List;

import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckPurchaseType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.PurchaseType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateOrUpdateReq {
    private List<ItemOrderCreateOrUpdateReq> items = new ArrayList<>();
    @NotNull
    @CheckPurchaseType(value = {PurchaseType.MOMO, PurchaseType.CASH, PurchaseType.VNPAY}, message = "Something went wrong here!")
    private String purchaseType = "";
    @NotNull
    @Size(min = 10, max = 200)
    private String shipAddress = "";
   
    
}
