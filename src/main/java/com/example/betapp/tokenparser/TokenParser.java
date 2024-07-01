package com.example.betapp.tokenparser;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.NoArgsConstructor;

import java.util.Base64;



public class TokenParser {

    public JSONObject parseTokenToJson(String authorizationHeader) throws ParseException {
        String token = authorizationHeader.substring(7);
        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);

        return json;
    }

}
