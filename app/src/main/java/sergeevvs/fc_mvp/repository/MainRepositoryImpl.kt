package sergeevvs.fc_mvp.repository

import retrofit2.Call
import sergeevvs.fc_mvp.api.NetworkService
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : MainRepository {

    override fun getTeams(): Call<TeamsList> = networkService.api.getTeams()
    override fun getTeam(id: Int): Call<Team> = networkService.api.getTeam(id)
}