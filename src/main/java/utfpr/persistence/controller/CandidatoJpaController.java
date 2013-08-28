/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CandidatoJpaController extends JpaController {

    public CandidatoJpaController() {
    }
    
    public List<Candidato> findCandidatoFilter(String idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();            
            TypedQuery<Candidato> q = em.createQuery("select c from Candidato c where c.idioma.descricao=:idioma order by c.nome", Candidato.class);
            q.setParameter("idioma", idioma);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Candidato> findCandidato() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Candidato> q = em.createQuery("select c from Candidato c order by c.nome", Candidato.class);            
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
