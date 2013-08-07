/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author a1151207
 */
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String email = (String) o;
        if (email.indexOf('@') == -1) {
            throw new ValidatorException(new FacesMessage("E-mail \'" + email + "\' inválido."));
        }
    }
}
