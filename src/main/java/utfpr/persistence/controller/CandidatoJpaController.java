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

/**
 *
 * @author a1151207
 */
public class CandidatoJpaController extends JpaController {

    public CandidatoJpaController() {
    }
    
    public List<Candidato> findCandidatoFilter(Idioma idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Candidato> q = em.createQuery("select c from Candidato c where c.idioma.codigo=:idioma order by c.nome", Candidato.class);
            q.setParameter("idioma", idioma.getCodigo());
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
