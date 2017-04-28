/*
 */
package cz.code.krtek.boundary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class VirtResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8484/krtek/resources/vrt");
    }

    @Test
    public void virtFunctionality() {
        String virtingMessage = this.tut.request().get(String.class);
        assertNotNull(virtingMessage);
        System.out.println("virtingMessage = " + virtingMessage);
    }

}
