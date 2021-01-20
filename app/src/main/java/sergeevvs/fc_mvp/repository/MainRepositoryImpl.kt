package sergeevvs.fc_mvp.repository

import retrofit2.Call
import sergeevvs.fc_mvp.api.NetworkService
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList

class MainRepositoryImpl : MainRepository {
    override fun getTeams(): Call<TeamsList> = NetworkService.instance().getTeams()
    override fun getTeam(id: Int): Call<Team> = NetworkService.instance().getTeam(id)
}