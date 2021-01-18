package sergeevvs.fc_mvp.model

import sergeevvs.fc_mvp.data.TeamsList
import retrofit2.Call
import sergeevvs.fc_mvp.api.NetworkService
import sergeevvs.fc_mvp.interfaces.IListModel

class ListModel : IListModel {

    override fun getTeams(): Call<TeamsList> = NetworkService.instance().getTeams()

}