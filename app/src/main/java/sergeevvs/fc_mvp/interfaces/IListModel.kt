package sergeevvs.fc_mvp.interfaces

import com.sergeevvs.footballcards.data.Team

interface IListModel {
    fun getTeams(): List<Team>
}