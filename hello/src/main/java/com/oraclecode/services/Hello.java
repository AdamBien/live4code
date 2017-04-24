
package com.oraclecode.services;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class Hello {

    private String name;

    public Hello(JsonObject input) {
        this.name = input.getString("name");
    }

    public Hello(String name) {
        this.name = name;
    }


    public JsonObject toJson() {
        return Json.createObjectBuilder().
                add("name", this.name).
                build();
    }

}
