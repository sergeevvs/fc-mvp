package sergeevvs.fc_mvp.interfaces

import com.sergeevvs.footballcards.data.Team

interface IListView : MvpContract.IView {

    fun showTeams(teams: List<Team>)

}