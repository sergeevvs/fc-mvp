package sergeevvs.fc_mvp.presenter

import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.RecyclerAdapter
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.model.ListModel
import sergeevvs.fc_mvp.view.ListFragment

class ListPresenter(model: ListModel) : BasePresenter<ListFragment, ListModel>(model) {

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

    fun onBindTeamAtPosition(holder: RecyclerAdapter.TeamCardHolder, position: Int) {
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