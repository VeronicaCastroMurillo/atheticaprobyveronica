package com.veronica.atheticaprobyveronica.services;

import com.veronica.atheticaprobyveronica.records.CategoriaRecord;
import com.veronica.atheticaprobyveronica.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas las categorías
    public List<CategoriaRecord> lista() {
        return categoriaRepository.lista();
    }

    // Guardar o actualizar una categoría
    public CategoriaRecord guardar(CategoriaRecord categoria) {
        return categoriaRepository.guardar(categoria);
    }

    // Buscar una categoría por ID
    public CategoriaRecord obtener(Integer id) {
        return categoriaRepository.obtener(id);
    }

    // Eliminar una categoría por ID
    public void eliminar(Integer id) {
        categoriaRepository.eliminar(id);
    }
}
