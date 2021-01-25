package sergeevvs.fc_mvp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import sergeevvs.fc_mvp.squad.SquadListPresenter
import sergeevvs.fc_mvp.squad.SquadListPresenterImpl
import sergeevvs.fc_mvp.teamcard.TeamCardPresenter
import sergeevvs.fc_mvp.teamcard.TeamCardPresenterImpl
import sergeevvs.fc_mvp.teamslist.TeamsListPresenter
import sergeevvs.fc_mvp.teamslist.TeamsListPresenterImpl

@InstallIn(ApplicationComponent::class)
@Module
abstract class PresenterModule {

    @Binds
    abstract fun bindTeamsListPresenter(impl: TeamsListPresenterImpl): TeamsListPresenter

    @Binds
    abstract fun bindTeamCardPresenter(impl: TeamCardPresenterImpl): TeamCardPresenter

    @Binds
    abstract fun bindSquadListPresenter(impl: SquadListPresenterImpl): SquadListPresenter
}