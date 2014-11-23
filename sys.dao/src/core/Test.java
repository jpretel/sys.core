package core;

import core.dao.*;

public class Test {
	public static void main(String[] args) {
		ConceptoDAO aDAO = new ConceptoDAO();
		
		System.out.println(aDAO.findAll());
	}
}
