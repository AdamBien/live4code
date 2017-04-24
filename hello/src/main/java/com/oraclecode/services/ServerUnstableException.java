
package com.oraclecode.services;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author airhacks.com
 */
@ApplicationException(rollback = true)
public class ServerUnstableException extends WebApplicationException {

    public ServerUnstableException(String message) {
        super(Response.status(Status.CONFLICT).header("reason", message).build());
    }

}
