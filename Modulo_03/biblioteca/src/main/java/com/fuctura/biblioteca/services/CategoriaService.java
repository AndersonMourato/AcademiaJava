package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.CategoriaDTO;
import com.fuctura.biblioteca.models.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaDTO findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return modelMapper.map(cat.orElse(null), CategoriaDTO.class);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
        return modelMapper.map(cat, CategoriaDTO.class);
    }

    public CategoriaDTO update(CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
        return modelMapper.map(cat, CategoriaDTO.class);
    }

    public void delete(Integer id){
        categoriaRepository.deleteById(id);
    }
}
