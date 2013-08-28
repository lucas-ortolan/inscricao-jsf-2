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

@ManagedBean
@SessionScoped
public class ListarBean extends PageBean {
    
    private ListDataModel<Candidato> candidatosDataModel;
    private List<Idioma> idiomas;
    //private Idioma idioma = new Idioma();
    private String idioma = "Inglês";

    public ListarBean() {
        candidatosDataModel = new ListDataModel<>(getListaCandidatos());        
    }
    
    public ListDataModel<Candidato> getCandidatosDataModel() {
       return candidatosDataModel;
   } 

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }    

    private List<Candidato> getListaCandidatos() {
        List<Candidato> candidatos;
        try {
            CandidatoJpaController ctl = new CandidatoJpaController();
//            candidatos = ctl.findCandidatoFilter(idioma);
            candidatos = ctl.findCandidato();
        } catch (Exception e) {
            candidatos = new ArrayList<>(0);
            log("Lista de candidatos", e);
            
        }
        return candidatos;
    }
    
    public List<Idioma> getIdiomas() {
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
