package sergeevvs.fc_mvp.model

import retrofit2.Call
import sergeevvs.fc_mvp.api.NetworkService
import sergeevvs.fc_mvp.data.Team

class CardModel : MvpModel {
    fun getTeam(id: Int): Call<Team> = NetworkService.instance().getTeam(id)
}