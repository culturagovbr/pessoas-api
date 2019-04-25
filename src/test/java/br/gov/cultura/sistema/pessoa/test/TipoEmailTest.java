package br.gov.cultura.sistema.pessoa.test;

import static org.junit.Assert.fail;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import br.gov.cultura.sistema.pessoa.rest.TipoEnderecoRESTService;

//@RunWith(Arquillian.class)
public class TipoEmailTest {

//	@Deployment
	public static WebArchive createDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
//				.addAsLibrary(new File("C:\\Users\\xtinote\\.m2\\repository\\br\\gov\\cultura\\sistema\\minc-comum\\1.0\\minc-comum-1.0.jar"))
				.addClass(TipoEnderecoRESTService.class)
//				.addPackages(true, "br.gov.cultura.sistema")
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
		;
		System.out.println(war.toString(true));
		return war;
	}

//	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
