package modules.myfirstapp.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ChambreTest extends AbstractDomainTest<Chambre> {

	@Override
	protected Chambre getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(Chambre.MODULE_NAME, Chambre.DOCUMENT_NAME);
	}
}