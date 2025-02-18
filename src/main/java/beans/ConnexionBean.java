package beans;

import bdbeans.Personne;
import bdbeans.PersonneHome;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class ConnexionBean implements Serializable {

    private Personne utilisateur = new Personne(); // Utilisateur connecté

    private PersonneHome personneHome = new PersonneHome();

    public Personne getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Personne utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String seConnecter() {
        Personne personne = personneHome.findByLogin(utilisateur.getLogin());

        if (personne != null && personne.getMotdepasse().equals(utilisateur.getMotdepasse())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilisateurConnecte", personne);
            utilisateur = personne; // Met à jour l'utilisateur connecté
            return "test.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de connexion", "Login ou mot de passe incorrect."));
            return null;
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        utilisateur = new Personne(); // Réinitialisation de l'objet utilisateur
        return "loginpms.xhtml?faces-redirect=true"; // Redirige vers la page de connexion
    }
}
