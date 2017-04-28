
package cz.code.krtek.vrt.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("vrt")
public class VrtResource {

    @Inject
    VrtDevice device;

    @GET
    public String doesNotMatter() {
        return "no virting today :-(";
    }


}
