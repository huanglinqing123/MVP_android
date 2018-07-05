package mvp.com.api.service;

import com.blankj.utilcode.utils.StringUtils;
import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;


final class AesResponseBodyCbcConverter<T> implements Converter<ResponseBody, T> {

    public static final String TAG = "OkHttp";

    private final Gson gson;
    private final Type type;

    AesResponseBodyCbcConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Reader reader = value.charStream();
        String targetString;
        targetString= IOUtils.toString(reader);
        if (targetString.contains("<") && targetString.contains(">")) {
            targetString = targetString.substring(targetString.indexOf("{"),
                    targetString.lastIndexOf("}") + 1);
        }
        reader = new StringReader(targetString);
        try {
            JSONObject jsonObject = new JSONObject(targetString);
            if (jsonObject.has("data")) {
                String data = jsonObject.optString("data");
                if (StringUtils.isEmpty(data)){
                    reader = new StringReader(jsonObject.toString());
                    return gson.fromJson(reader, type);
                }
                String parseData = AesCBC.getInstance().decrypt(data);
                jsonObject.remove("data");
                Object json = new JSONTokener(parseData).nextValue();
                if (json instanceof JSONObject) {
                    jsonObject.put("data", new JSONObject(parseData));
                } else if (json instanceof JSONArray) {
                    jsonObject.put("data", new JSONArray(parseData));
                } else {
                    jsonObject.put("data", parseData);
                }
                reader = new StringReader(jsonObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            return gson.fromJson(reader, type);
        } finally {
            if (reader == null) ;
            try {
                reader.close();
            } catch (IOException ignored) {
            }
        }
    }
}
