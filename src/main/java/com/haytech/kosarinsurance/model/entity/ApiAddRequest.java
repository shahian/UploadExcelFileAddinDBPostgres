package com.haytech.kosarinsurance.model.entity;


import com.haytech.kosarinsurance.model.enums.HttpMethods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public class ApiAddRequest {

    @NotBlank
    @Size(max = 255)
    private String url;

    @NotNull
    private HttpMethods method;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String routeUrl;

    @Size(max = 200)
    private String description;

    public ApiAddRequest(String name, String url) {
        this.title=name;
        this.url=url;
    }
}
