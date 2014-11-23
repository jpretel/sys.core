package core.dao;

import java.util.List;

import core.entity.GrupoUsuario;
import core.entity.SysFormulario;
import core.entity.SysGrupo;
import core.entity.SysModulo;

public class SysModuloDAO extends AbstractDAO<SysModulo> {

	public SysModuloDAO() {
		super(SysModulo.class);
	}
	
	public List<SysModulo> getModulos(GrupoUsuario grupo){
		
		List<SysFormulario> formularios = new GrupoUsuarioPrivilegioDAO().getFormularioPorGrupoUsuario(grupo);
		
		System.out.println("Formularios: " + formularios);
		
		List<SysGrupo> opciones = new SysOpcionDAO().getPorFormularios(formularios);
		
		System.out.println("Grupos: " + opciones);
		
		//List<SysGrupo> grupos = new SysGrupoDAO().getPorOpciones(opciones);
		
		//System.out.println("Grupos: " + grupos);
		
		return null;
	}
}
