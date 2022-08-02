package com.infortech.Bazar.model.repositorios;

import java.util.List;

public interface GenericRepository<TipoClasse, TipoVariavelIdentificadora> {
	public void create(TipoClasse t);
    public void update(TipoClasse t);
    public TipoClasse read(TipoVariavelIdentificadora i);
    public void delete(TipoVariavelIdentificadora i);
    public List<TipoClasse> readAll();
}
