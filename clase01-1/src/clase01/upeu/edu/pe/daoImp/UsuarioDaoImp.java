package clase01.upeu.edu.pe.daoImp;

import java.util.ArrayList;
import java.util.List;

import clase01.upeu.edu.pe.dao.UsuarioDao;
import clase01.upeu.edu.pe.entity.Usuario;

public class UsuarioDaoImp implements UsuarioDao{
	public List<Usuario> lista;
    public UsuarioDaoImp() {
		// TODO Auto-generated constructor stub
    	lista = new ArrayList<>();
    	lista.add(new Usuario("dreyna","123"));
	}
	@Override
	public void create(Usuario u) {
		// TODO Auto-generated method stub
		lista.add(u);
	}

	@Override
	public void update(int index, Usuario u) {
		// TODO Auto-generated method stub
		lista.set(index, u);
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		lista.remove(index);
	}

	@Override
	public Usuario read(int index) {
		// TODO Auto-generated method stub
		Usuario x =new Usuario();
		for(int i=0;i<lista.size();i++){
			if(i==index){
				x=lista.get(index);
			}
		}
		return x;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	public int validar(Usuario u) {
		int y = 0;
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNomuser().equals(u.getNomuser()) && lista.get(i).getClave().equals(u.getClave())) {
				y = 1;
			}
		}
		return y;
	}
	@Override
	public int buscar(String nomuser) {
		// TODO Auto-generated method stub
		int x =-1;
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getNomuser().equals(nomuser)){
				x=i;
			}
		}
		return x;
	}

}
