package br.iesb.pi.cadastrararea;

import br.iesb.pi.dados.AreaDAO;
import br.iesb.pi.dados.DadosException;
import java.util.ArrayList;
import java.util.List;
import br.iesb.pi.entidades.Area;

public class AreaBO implements BO<Area> {

    @Override
    public void validar(Area entidade) throws AreaException {

        if (entidade.getArea().isEmpty()) {
            throw new AreaException("Campo Area Obrigatório");
        }

        if (entidade.getSituacao().isEmpty()) {
            throw new AreaException("Campo Situação Obrigatório");
        }

    }

    @Override
    public void inserir(Area entidade) throws AreaException {
        validar(entidade);
        AreaDAO dao = new AreaDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }
    }

    @Override
    public void alterar(Area entidade) throws AreaException {
        consultar(entidade.getId());
        validar(entidade);
        AreaDAO dao = new AreaDAO();

        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }
    }

    @Override
    public void excluir(Area entidade) throws AreaException {
        consultar(entidade.getId());
        AreaDAO dao = new AreaDAO();

        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }
    }

    @Override
    public Area consultar(int id) throws AreaException {
        Area area = new Area();
        AreaDAO dao = new AreaDAO();
        try {
            area = dao.consultar(id);
            if (area.getId() == 0) {
                throw new AreaException("Área não encontrada.");
            }
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }

        return area;

    }

    @Override
    public List<Area> listar() throws AreaException {
        List<Area> lista = new ArrayList<Area>();
        AreaDAO dao = new AreaDAO();
        try {
            lista = dao.listar();
            if (lista.isEmpty()) {
                throw new AreaException("Área não encontrada.");
            }
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }
        return lista;
    }

    public List<Area> listar(String condominio) throws AreaException {
        List<Area> lista = new ArrayList<Area>();
        AreaDAO dao = new AreaDAO();
        try {
            lista = dao.listar();
            if (lista.isEmpty()) {
                throw new AreaException("Unidade não encontrada.");
            }
        } catch (DadosException ex) {
            throw new AreaException("", ex);
        }
        return lista;
    }
}
