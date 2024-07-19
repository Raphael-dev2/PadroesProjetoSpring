package service.ímpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import model.ClienteRepository;
import model.Endereco;
import model.EnderecoRepository;
import service.ClienteService;
import service.ViaCepService;

/* Implementação da Strategy {@link ClienteService}, a qual pode ser injetada pelo Spring(Via {@link Autowired}).
 * Com isso, como essa é um {@link Service},ela será tratada como um Singleton
 * 
 * */
@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	// Busca todos os clientes
	public Iterable<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	// Buscar cliente por ID
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	
	public void  inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
		}

	public void  atualizar( Long id,Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	} 
	
	public void  deletar(Long id) {
		clienteRepository.deleteById(id);
	} 
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}
	
}
