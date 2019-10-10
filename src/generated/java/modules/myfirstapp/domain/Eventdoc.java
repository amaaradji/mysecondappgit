package modules.myfirstapp.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.DateOnly;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.ChangeTrackingArrayList;
import org.skyve.impl.domain.types.jaxb.DateOnlyMapper;

/**
 * Eventdoc
 * 
 * @navcomposed 1 billets 0..n Billet
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Eventdoc extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "myfirstapp";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Eventdoc";

	/** @hidden */
	public static final String nomDeLévénementPropertyName = "nomDeLévénement";
	/** @hidden */
	public static final String dateDebutPropertyName = "dateDebut";
	/** @hidden */
	public static final String dateFinPropertyName = "dateFin";
	/** @hidden */
	public static final String descriptionPropertyName = "description";
	/** @hidden */
	public static final String imagePropertyName = "image";
	/** @hidden */
	public static final String billetsPropertyName = "billets";
	/** @hidden */
	public static final String feuilleDeRoutePropertyName = "feuilleDeRoute";

	/**
	 * Nom de l’événement
	 **/
	private String nomDeLévénement;
	/**
	 * Date debut
	 **/
	private DateOnly dateDebut;
	/**
	 * Date fin
	 **/
	private DateOnly dateFin;
	/**
	 * Description
	 **/
	private String description;
	/**
	 * Image
	 **/
	private String image;
	/**
	 * Billets
	 **/
	private List<Billet> billets = new ChangeTrackingArrayList<>("billets", this);
	/**
	 * Feuille de route
	 **/
	private String feuilleDeRoute;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Eventdoc.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Eventdoc.DOCUMENT_NAME;
	}

	public static Eventdoc newInstance() {
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
														"Eventdoc - {nomDeLévénement}",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Eventdoc) && 
					this.getBizId().equals(((Eventdoc) o).getBizId()));
	}

	/**
	 * {@link #nomDeLévénement} accessor.
	 * @return	The value.
	 **/
	public String getNomDeLévénement() {
		return nomDeLévénement;
	}

	/**
	 * {@link #nomDeLévénement} mutator.
	 * @param nomDeLévénement	The new value.
	 **/
	@XmlElement
	public void setNomDeLévénement(String nomDeLévénement) {
		preset(nomDeLévénementPropertyName, nomDeLévénement);
		this.nomDeLévénement = nomDeLévénement;
	}

	/**
	 * {@link #dateDebut} accessor.
	 * @return	The value.
	 **/
	public DateOnly getDateDebut() {
		return dateDebut;
	}

	/**
	 * {@link #dateDebut} mutator.
	 * @param dateDebut	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setDateDebut(DateOnly dateDebut) {
		preset(dateDebutPropertyName, dateDebut);
		this.dateDebut = dateDebut;
	}

	/**
	 * {@link #dateFin} accessor.
	 * @return	The value.
	 **/
	public DateOnly getDateFin() {
		return dateFin;
	}

	/**
	 * {@link #dateFin} mutator.
	 * @param dateFin	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setDateFin(DateOnly dateFin) {
		preset(dateFinPropertyName, dateFin);
		this.dateFin = dateFin;
	}

	/**
	 * {@link #description} accessor.
	 * @return	The value.
	 **/
	public String getDescription() {
		return description;
	}

	/**
	 * {@link #description} mutator.
	 * @param description	The new value.
	 **/
	@XmlElement
	public void setDescription(String description) {
		preset(descriptionPropertyName, description);
		this.description = description;
	}

	/**
	 * {@link #image} accessor.
	 * @return	The value.
	 **/
	public String getImage() {
		return image;
	}

	/**
	 * {@link #image} mutator.
	 * @param image	The new value.
	 **/
	@XmlElement
	public void setImage(String image) {
		preset(imagePropertyName, image);
		this.image = image;
	}

	/**
	 * {@link #billets} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<Billet> getBillets() {
		return billets;
	}

	/**
	 * {@link #billets} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public Billet getBilletsElementById(String bizId) {
		return getElementById(billets, bizId);
	}

	/**
	 * {@link #billets} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setBilletsElementById(String bizId, Billet element) {
		 setElementById(billets, element);
	}

	/**
	 * {@link #feuilleDeRoute} accessor.
	 * @return	The value.
	 **/
	public String getFeuilleDeRoute() {
		return feuilleDeRoute;
	}

	/**
	 * {@link #feuilleDeRoute} mutator.
	 * @param feuilleDeRoute	The new value.
	 **/
	@XmlElement
	public void setFeuilleDeRoute(String feuilleDeRoute) {
		preset(feuilleDeRoutePropertyName, feuilleDeRoute);
		this.feuilleDeRoute = feuilleDeRoute;
	}
}
