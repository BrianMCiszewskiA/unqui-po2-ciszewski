package banco;

import java.util.List;

public interface BancoAdminClientes {
	public void agregarCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public void removerCliente(Cliente cliente);
}
