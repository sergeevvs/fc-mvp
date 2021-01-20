package sergeevvs.fc_mvp.repository

import retrofit2.Call
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList

interface MainRepository {

    fun getTeams(): Call<TeamsList>
    fun getTeam(id: Int): Call<Team>
}