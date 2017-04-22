
package com.oraclecode.services;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class Hello {

    private String myName;

    public Hello(JsonObject input) {
        this.myName = input.getString("name");
    }

    public Hello(String name) {
        this.myName = name;
    }


    public JsonObject toJson() {
        return Json.createObjectBuilder().add("name", this.myName).build();
    }

}
