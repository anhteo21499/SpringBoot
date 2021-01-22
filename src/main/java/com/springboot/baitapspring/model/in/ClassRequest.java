package com.springboot.baitapspring.model.in;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRequest {
    private long id;
    private String name;
}
