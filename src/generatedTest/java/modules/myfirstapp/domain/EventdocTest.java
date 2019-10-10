package modules.myfirstapp.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class EventdocTest extends AbstractDomainTest<Eventdoc> {

	@Override
	protected Eventdoc getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(Eventdoc.MODULE_NAME, Eventdoc.DOCUMENT_NAME);
	}
}