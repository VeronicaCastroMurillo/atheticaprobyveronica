package com.veronica.atheticaprobyveronica.repository;

import com.veronica.atheticaprobyveronica.records.CategoriaRecord;
import com.veronica.atheticaprobyveronica.tables.Categoria;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {

    @Autowired
    private DSLContext dsl;

    public List<CategoriaRecord> lista() {
        return dsl.selectFrom(Categoria.CATEGORIA)
                .fetchInto(CategoriaRecord.class);
    }

    public CategoriaRecord guardar(CategoriaRecord categoria) {
        categoria.attach(dsl.configuration());
        categoria.store();
        return categoria;
    }

    public CategoriaRecord obtener(Integer id) {
        return dsl.selectFrom(Categoria.CATEGORIA)
                .where(Categoria.CATEGORIA.ID.eq(id))
                .fetchOneInto(CategoriaRecord.class);
    }

    public void eliminar(Integer id) {
        dsl.deleteFrom(Categoria.CATEGORIA)
            .where(Categoria.CATEGORIA.ID.eq(id))
            .execute();
    }
}
