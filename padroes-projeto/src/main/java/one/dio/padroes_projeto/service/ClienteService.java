package one.dio.padroes_projeto.service;

import one.dio.padroes_projeto.model.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
