package com.company.myapp.converter;

import com.company.myapp.model.dto.BaseDTO;
import com.company.myapp.model.entity.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<TO extends BaseEntity, DTO extends BaseDTO> implements Converter<TO,DTO>{

    public List<DTO> convert(Collection<TO> tos) {
        if(!tos.isEmpty()) {
            return tos.stream().map(this::convert).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<TO> reverseConvert(Collection<DTO> tos) {
        if(!tos.isEmpty()) {
            return tos.stream().map(this::convert).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}