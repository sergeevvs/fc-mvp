package sergeevvs.fc_mvp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import sergeevvs.fc_mvp.repository.MainRepository
import sergeevvs.fc_mvp.repository.MainRepositoryImpl

@InstallIn(ApplicationComponent::class)
@Module
abstract class NetworkModule {

    @Binds
    abstract fun bindMainRepository(impl: MainRepositoryImpl): MainRepository

}