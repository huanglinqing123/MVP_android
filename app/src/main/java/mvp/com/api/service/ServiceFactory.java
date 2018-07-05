package mvp.com.api.service;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import mvp.com.api.base.BaseApi;
import mvp.com.api.base.Constant;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    private static OkHttpClient client;

    public static <T> T createNewRetrofitService(final Class<T> clazz, Context mContext) {

        BasicParamsInterceptor basicParamsInterceptor =
                new BasicParamsInterceptor.Builder()  .addParam("app_name", Constant.APP_NAME)
                        .addParam("app_version", Constant.APP_VERSION)
                        .addParam("type",Constant.APP_TYPE)
                        .build();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(basicParamsInterceptor)
                .build();
        if (!NetworkUtils.isConnected(mContext)) {
            ToastUtils.showShortToastSafe(mContext,"请检查你的网络连接");
            return null;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseApi.MainApi)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(AesCbcConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T service = retrofit.create(clazz);
        return service;
    }
    public static <T> T createRetrofitService(final Class<T> clazz, String host,Context mContext) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();

        if (!NetworkUtils.isConnected(mContext)) {
            ToastUtils.showShortToastSafe(mContext,"请检查你的网络连接");
            return null;
        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               // .addConverterFactory(AesCbcConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T service = retrofit.create(clazz);

        return service;
    }
}