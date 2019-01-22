package com.valery.myapplication.dagger.modules

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.valery.myapplication.BuildConfig
import com.valery.myapplication.dagger.scope.SessionScope
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Named

private const val INTERCEPTOR_LOGGING = "INTERCEPTOR_LOGGING"
@Module
class NetworkModule {

    @Provides
    @SessionScope
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.build()
    }

    @Provides
    @SessionScope
    fun provideRetrofitBuilder(client: OkHttpClient, objectMapper: ObjectMapper): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://restcountries.eu/rest/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
    }

    @Provides
    @SessionScope
    fun provideJacksonObjectMapper(): ObjectMapper {
        return jacksonObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    @Provides
    @SessionScope
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @Provides
    @SessionScope
    fun provideOkHttpClienBuilder(
        @Named(INTERCEPTOR_LOGGING)
        loggingInterceptor: Interceptor
        ): OkHttpClient.Builder {
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
    }

    @Provides
    @SessionScope
    @Named(INTERCEPTOR_LOGGING)
    fun provideLoggingInterceptor(): Interceptor {
        val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor()
            .setLevel(level)
    }

}