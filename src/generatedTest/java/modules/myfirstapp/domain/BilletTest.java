package modules.myfirstapp.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class BilletTest extends AbstractDomainTest<Billet> {

	@Override
	protected Billet getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(Billet.MODULE_NAME, Billet.DOCUMENT_NAME);
	}
}