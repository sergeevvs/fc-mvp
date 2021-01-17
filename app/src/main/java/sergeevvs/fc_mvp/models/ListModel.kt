package sergeevvs.fc_mvp.models

import com.sergeevvs.footballcards.data.Team
import sergeevvs.fc_mvp.interfaces.IListModel

class ListModel : IListModel {

    override fun getTeams(): List<Team> {

        return listOf()
    }
}