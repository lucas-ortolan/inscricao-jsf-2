/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CandidatoJpaController extends JpaController {

    public CandidatoJpaController() {
    }

    public List<Candidato> findCandidatoFilter(int idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Candidato> q = em.createQuery("select c from Candidato c where c.idioma.descricao=:idioma order by c.nome", Candidato.class);
            q.setParameter("idioma", idioma);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Candidato> findCandidato() {

        //   CriteriaBuilder cb = em.getCriteriaBuilder();
        //CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        //  Root<Idioma> rt = cq.from(Pessoa.class);
         //cq.where(cb.equal(rt.get(Pessoa_.sexo), 'M');
         //TypedQuery<Pessoa> q = em.createQuery(cq);

        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Candidato> cq = cb.createQuery(Candidato.class);
            Root<Candidato> rt = cq.from(Candidato.class);
            TypedQuery<Candidato> q = em.createQuery(cq);

            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        /*EntityManager em = null;
     try {
     em = getEntityManager();
     TypedQuery<Candidato> q = em.createQuery("select c from Candidato c order by c.nome", Candidato.class);
     return q.getResultList();
     } finally {
     if (em != null) {
     em.close();
     }
     }
     }*/
    }
    
}
