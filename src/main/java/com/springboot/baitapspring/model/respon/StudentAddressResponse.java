package com.springboot.baitapspring.model.respon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddressResponse {
    private String address;
    private long total;
}
