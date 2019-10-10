package modules.myfirstapp.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Billet
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Billet extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "myfirstapp";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Billet";

	/** @hidden */
	public static final String nomBilletPropertyName = "nomBillet";
	/** @hidden */
	public static final String billetPdfPropertyName = "billetPdf";

	/**
	 * NomBillet
	 **/
	private String nomBillet;
	/**
	 * BilletPdf
	 **/
	private String billetPdf;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Billet.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Billet.DOCUMENT_NAME;
	}

	public static Billet newInstance() {
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
														"Billet - {billetPdf}",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Billet) && 
					this.getBizId().equals(((Billet) o).getBizId()));
	}

	/**
	 * {@link #nomBillet} accessor.
	 * @return	The value.
	 **/
	public String getNomBillet() {
		return nomBillet;
	}

	/**
	 * {@link #nomBillet} mutator.
	 * @param nomBillet	The new value.
	 **/
	@XmlElement
	public void setNomBillet(String nomBillet) {
		preset(nomBilletPropertyName, nomBillet);
		this.nomBillet = nomBillet;
	}

	/**
	 * {@link #billetPdf} accessor.
	 * @return	The value.
	 **/
	public String getBilletPdf() {
		return billetPdf;
	}

	/**
	 * {@link #billetPdf} mutator.
	 * @param billetPdf	The new value.
	 **/
	@XmlElement
	public void setBilletPdf(String billetPdf) {
		preset(billetPdfPropertyName, billetPdf);
		this.billetPdf = billetPdf;
	}
}
