
package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    private final CategoriaRepository categoriaRepository;
    
    @Transactional(readOnly=true)
    public List<Categoria> getCategories(boolean activo){
        if (activo){
            return categoriaRepository.findByActivoTrue();
        } else {
            return categoriaRepository.findAll();
        }
    }
}
