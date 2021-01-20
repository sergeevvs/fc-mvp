package sergeevvs.fc_mvp.squad

import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.main.MvpPresenter

interface SquadListPresenter: MvpPresenter<SquadListFragment> {

    fun onBindPlayerAtPosition(holder: SquadAdapter.PlayerCardHolder, position: Int)
    fun getPlayerCount(): Int

    // saving instance
    fun getTeam(): Team
    fun attachTeam(team: Team)
}