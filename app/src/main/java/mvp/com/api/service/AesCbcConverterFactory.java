package mvp.com.api.service;


import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class AesCbcConverterFactory extends Converter.Factory {
    private final Gson gson;

    public static AesCbcConverterFactory create() {
        return create(new Gson());
    }

    public static AesCbcConverterFactory create(Gson gson) {
        return new AesCbcConverterFactory(gson);
    }
    private AesCbcConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,Retrofit retrofit) {
       //TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new AesResponseBodyCbcConverter<>(gson, type);  //响应
    }




}
