package sergeevvs.fc_mvp.teamslist

import sergeevvs.fc_mvp.adapter.TeamsListAdapter
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.main.MvpPresenter

interface TeamsListPresenter : MvpPresenter<TeamsListFragment> {

    fun onBindTeamAtPosition(holder: TeamsListAdapter.TeamCardHolder, position: Int)
    fun getTeamCount(): Int

    // saving instance
    fun getTeamsList(): TeamsList
    fun attachTeamsList(teams: TeamsList)
}