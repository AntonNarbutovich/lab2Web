package com.company.myapp.converter;

import com.company.myapp.model.dto.BaseDTO;
import com.company.myapp.model.entity.BaseEntity;

public interface Converter<TO extends BaseEntity,DTO extends BaseDTO> {
    DTO convert(TO to);
    TO convert(DTO dto);
}
