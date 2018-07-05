package mvp.com.api.service;

import com.google.gson.Gson;

/**
 */
public class BaseReqData {

    public String decode() {
        String gson = new Gson().toJson(this);
        String encode = AesCBC.getInstance().encrypt(gson);
        encode = encode.replaceAll("\\s+", "");
        return encode;
    }
}
