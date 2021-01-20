package sergeevvs.fc_mvp.squad

import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.data.TEAM
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.main.BasePresenter

class SquadListPresenterImpl : BasePresenter<SquadListFragment>(), SquadListPresenter {

    private lateinit var team: Team

    override fun getTeam() = team

    override fun attachTeam(team: Team) {
        this.team = team
    }

    override fun viewIsReady() {
        if (!this::team.isInitialized) loadPlayers()
    }

    private fun loadPlayers() {
        team = view?.getArguments()?.getSerializable(TEAM) as Team
        view?.updateList()
    }

    override fun onBindPlayerAtPosition(holder: SquadAdapter.PlayerCardHolder, position: Int) {
        holder.bindPlayer(team.squad[position])
    }

    override fun getPlayerCount(): Int {
        return if (this::team.isInitialized) team.squad.size else 0
    }
}