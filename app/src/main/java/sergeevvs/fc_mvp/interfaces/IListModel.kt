package sergeevvs.fc_mvp.interfaces

import sergeevvs.fc_mvp.data.TeamsList
import retrofit2.Call

interface IListModel {
    fun getTeams(): Call<TeamsList>
}