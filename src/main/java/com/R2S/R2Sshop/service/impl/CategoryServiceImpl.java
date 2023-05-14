package com.R2S.R2Sshop.service.impl;

import com.R2S.R2Sshop.data.dto.CategoryDTO;
import com.R2S.R2Sshop.data.entity.Category;
import com.R2S.R2Sshop.data.mapper.CategoryMapper;
import com.R2S.R2Sshop.data.repository.CategoryRepository;
import com.R2S.R2Sshop.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.toDTO(category)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category.setId(0);
        return categoryMapper.toDTO(categoryRepository.save(category));
    }
}
