package br.com.wellingtoncosta.amdk.di.modules

import br.com.wellingtoncosta.amdk.data.remote.Api
import br.com.wellingtoncosta.amdk.domain.repository.ColorRepository
import br.com.wellingtoncosta.amdk.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Wellington Costa on 31/12/2017.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retorfit: Retrofit) : Api {
        return retorfit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api): UserRepository {
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideColorRepository(api: Api): ColorRepository {
        return ColorRepository(api)
    }

}