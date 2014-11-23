package core.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import core.entity.Docingreso;

public class DocingresoDAO extends AbstractDAO<Docingreso> {
	public DocingresoDAO(){
		super(Docingreso.class);
	}
	
	@SuppressWarnings("unchecked")
	public int getPorSerie(String serie){
		CriteriaQuery<Docingreso> q = cb.createQuery(Docingreso.class);
		Root c = q.from(Docingreso.class);
		Predicate condicion = cb.equal(c.get("serie"), serie);
		q.select((Selection<? extends Docingreso>) cb.max(c.get("numero"))).where(condicion);
		System.out.println(getEntityManager().createQuery(q).getSingleResult());
		int Numero = 0;
		if (getEntityManager().createQuery(q).getSingleResult() instanceof Object)
			Numero = Integer.parseInt(((Object)getEntityManager().createQuery(q).getSingleResult()).toString());
		return Numero;
	}
	
	public List<Docingreso> getFiltro(int idesde, int ihasta, String serie,
			int numero) {

		CriteriaQuery<Docingreso> q = cb.createQuery(Docingreso.class);
		Root<Docingreso> c = q.from(Docingreso.class);
		
		Expression<Integer> expfecha = c.get("aniomesdia");
				
		Predicate ps = null;
		
		if (serie.trim().length() > 0)
			ps = cb.equal(c.get("serie"), serie);
		
		if (numero != 0)
			if (ps == null)
				ps = cb.equal(c.get("numero"), numero);
			else
				ps = cb.and(ps, cb.equal(c.get("numero"), numero));
		
		if (idesde != 0)
			if (ps == null) {
				ps = cb.greaterThanOrEqualTo(expfecha, idesde);
			} else {
				ps = cb.and(ps, cb.greaterThanOrEqualTo(expfecha, idesde));
			}
		
		if (ihasta != 0)
			if (ps == null) {
				ps = cb.lessThanOrEqualTo(expfecha, ihasta);
			} else {
				ps = cb.and(ps, cb.lessThanOrEqualTo(expfecha, ihasta));
			}
		
		if (ps != null){
			q.select(c).where(ps);
		} else 
			q.select(c);
		
		return getEntityManager().createQuery(q).getResultList();
	}
}
