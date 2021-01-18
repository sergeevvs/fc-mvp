package sergeevvs.fc_mvp.model

import retrofit2.Call
import sergeevvs.fc_mvp.api.NetworkService
import sergeevvs.fc_mvp.data.TeamsList

class ListModel : MvpModel {
    fun getTeams(): Call<TeamsList> = NetworkService.instance().getTeams()
}