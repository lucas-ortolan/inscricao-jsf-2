/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.CandidatoJpaController;
import utfpr.persistence.controller.IdiomaJpaController;

/**
 *
 * @author a1151207
 */
@ManagedBean
@SessionScoped
public class ListarBean extends PageBean {
    
    private ListDataModel<Candidato> candidatosDataModel;
    private Idioma idioma;

    public ListarBean() {
        candidatosDataModel = new ListDataModel<>(getListaCandidatos());
    }
    
    public ListDataModel<Candidato> getCandidatosDataModel() {
       return candidatosDataModel;
   } 

    private List<Candidato> getListaCandidatos() {
        List<Candidato> candidatos;
        try {
            CandidatoJpaController ctl = new CandidatoJpaController();
            candidatos = ctl.findCandidatoFilter(idioma);
        } catch (Exception e) {
            candidatos = new ArrayList<>(0);
            log("Lista de candidatos", e);
        }
        return candidatos;
    }
    
    public List<Idioma> getIdiomas() {
        List<Idioma> idiomas;
        try {
            IdiomaJpaController ctl = new IdiomaJpaController();
            idiomas = ctl.findAll();
        } catch (Exception e) {
            idiomas = new ArrayList<>(0);
            log("Lista de idiomas", e);
        }
        return idiomas;
    }
    
}
