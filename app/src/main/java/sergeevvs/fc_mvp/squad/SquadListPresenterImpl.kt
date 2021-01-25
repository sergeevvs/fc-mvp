package sergeevvs.fc_mvp.squad

import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.data.TEAM
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.getMockTeam
import sergeevvs.fc_mvp.main.BasePresenter
import javax.inject.Inject

class SquadListPresenterImpl @Inject constructor() : BasePresenter<SquadListFragment>(),
    SquadListPresenter {

    private var team = getMockTeam()

    override fun getTeam() = team

    override fun attachTeam(team: Team) {
        this.team = team
    }

    override fun viewIsReady() {
        if (team.id == 0) loadPlayers()
    }

    private fun loadPlayers() {
        view?.getArguments()?.getSerializable(TEAM)?.let { team = it as Team }
        view?.updateList()
    }

    override fun onBindPlayerAtPosition(holder: SquadAdapter.PlayerCardHolder, position: Int) {
        holder.bindPlayer(team.squad[position])
    }

    override fun getPlayerCount(): Int {
        return team.squad.size
    }
}