package br.iesb.pi.cadastrararea;

import java.util.List;

public interface BO<T> {
    
    void validar(T entidade) throws AreaException;
    
    void inserir(T entidade) throws AreaException;
    
    void alterar(T entidade) throws AreaException;
    
    void excluir(T entidade) throws AreaException;
    
    T consultar(int id) throws AreaException;
    
    List<T> listar() throws AreaException;
    
}
