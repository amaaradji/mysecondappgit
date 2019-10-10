package modules.myfirstapp.domain;

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
import org.skyve.impl.domain.types.jaxb.DateOnlyMapper;

/**
 * Eventdoc
 * 
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
}
