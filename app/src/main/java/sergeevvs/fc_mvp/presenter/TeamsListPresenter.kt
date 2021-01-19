package sergeevvs.fc_mvp.presenter

import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.adapter.TeamAdapter
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.model.TeamsListModel
import sergeevvs.fc_mvp.view.TeamsListFragment

class TeamsListPresenter(private val model: TeamsListModel) : BasePresenter<TeamsListFragment>() {

    private val teams = mutableListOf<Team>()

    override fun viewIsReady() {
        if (teams.isEmpty()) loadTeams()
    }

    private fun loadTeams() {
        model.getTeams().enqueue(object : Callback<TeamsList> {
            override fun onResponse(call: Call<TeamsList>, response: Response<TeamsList>) {
                teams.addAll(response.body()?.list ?: emptyList())
                view?.updateList()
            }

            override fun onFailure(call: Call<TeamsList>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun onBindTeamAtPosition(holder: TeamAdapter.TeamCardHolder, position: Int) {
        val currentTeam = teams[position]
        holder.bindTeam(currentTeam) {
            val bundle = Bundle()
            bundle.putInt(ID, currentTeam.id)
            view?.getNavController()?.navigate(
                R.id.action_listFragment_to_cardFragment,
                bundle
            )
        }
    }

    fun getTeamCount(): Int {
        return teams.size
    }
}