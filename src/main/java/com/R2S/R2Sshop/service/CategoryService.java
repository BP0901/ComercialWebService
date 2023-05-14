package com.R2S.R2Sshop.service;

import com.R2S.R2Sshop.data.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO create(CategoryDTO categoryDTO);

}
