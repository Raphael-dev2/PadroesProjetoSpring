package service;

import model.Cliente;

/* Interface que define o padrão Strategy no dominio de cliente. 
 * Com isso, se necessario, podemos ter multiplas implementações dessas mesma interface.*/
public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);
}
