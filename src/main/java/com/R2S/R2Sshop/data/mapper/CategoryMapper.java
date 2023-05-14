package com.R2S.R2Sshop.data.mapper;

import com.R2S.R2Sshop.data.dto.CategoryDTO;
import com.R2S.R2Sshop.data.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);
}
