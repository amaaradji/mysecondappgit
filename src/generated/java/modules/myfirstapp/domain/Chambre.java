package modules.myfirstapp.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Chambre
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Chambre extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "myfirstapp";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Chambre";

	/** @hidden */
	public static final String nomPropertyName = "nom";
	/** @hidden */
	public static final String capacitéPropertyName = "capacité";
	/** @hidden */
	public static final String planPropertyName = "plan";

	/**
	 * nom
	 **/
	private String nom;
	/**
	 * Capacité
	 **/
	private Integer capacité;
	/**
	 * Plan
	 **/
	private String plan;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Chambre.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Chambre.DOCUMENT_NAME;
	}

	public static Chambre newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage(org.skyve.CORE.getUser().getCustomer(),
														"Chambre - {nom}",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Chambre) && 
					this.getBizId().equals(((Chambre) o).getBizId()));
	}

	/**
	 * {@link #nom} accessor.
	 * @return	The value.
	 **/
	public String getNom() {
		return nom;
	}

	/**
	 * {@link #nom} mutator.
	 * @param nom	The new value.
	 **/
	@XmlElement
	public void setNom(String nom) {
		preset(nomPropertyName, nom);
		this.nom = nom;
	}

	/**
	 * {@link #capacité} accessor.
	 * @return	The value.
	 **/
	public Integer getCapacité() {
		return capacité;
	}

	/**
	 * {@link #capacité} mutator.
	 * @param capacité	The new value.
	 **/
	@XmlElement
	public void setCapacité(Integer capacité) {
		preset(capacitéPropertyName, capacité);
		this.capacité = capacité;
	}

	/**
	 * {@link #plan} accessor.
	 * @return	The value.
	 **/
	public String getPlan() {
		return plan;
	}

	/**
	 * {@link #plan} mutator.
	 * @param plan	The new value.
	 **/
	@XmlElement
	public void setPlan(String plan) {
		preset(planPropertyName, plan);
		this.plan = plan;
	}
}
