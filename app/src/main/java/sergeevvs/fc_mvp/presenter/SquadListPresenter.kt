package sergeevvs.fc_mvp.presenter

import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.data.Player
import sergeevvs.fc_mvp.data.SerializableSquad
import sergeevvs.fc_mvp.view.SquadListFragment

class SquadListPresenter : BasePresenter<SquadListFragment>() {

    private val squad = mutableListOf<Player>()

    override fun viewIsReady() {
        if (squad.isEmpty()) showPlayers()
    }

    private fun showPlayers() {
        squad.addAll((view?.arguments?.getSerializable("squad") as SerializableSquad).squad)
        view?.updateList()
    }

    fun onBindPlayerAtPosition(holder: SquadAdapter.PlayerCardHolder, position: Int) {
        holder.bindTeam(squad[position])
    }

    fun getPlayerCount(): Int {
        return squad.size
    }
}