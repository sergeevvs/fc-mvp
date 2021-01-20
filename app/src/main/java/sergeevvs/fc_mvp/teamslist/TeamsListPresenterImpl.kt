package sergeevvs.fc_mvp.teamslist

import androidx.navigation.NavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.adapter.TeamsListAdapter
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.data.getMockTeamsList
import sergeevvs.fc_mvp.main.BasePresenter
import sergeevvs.fc_mvp.repository.MainRepository

class TeamsListPresenterImpl(private val model: MainRepository) :
    BasePresenter<TeamsListFragment>(), TeamsListPresenter {

    private lateinit var teams: TeamsList
    private lateinit var navController: NavController

    override fun getTeamsList() = teams

    override fun attachTeamsList(teams: TeamsList) {
        this.teams = teams
    }

    override fun viewIsReady() {
        if (!this::teams.isInitialized) loadTeams()
        view?.getNavController()?.let { navController = it }
    }

    private fun loadTeams() {
        model.getTeams().enqueue(object : Callback<TeamsList> {
            override fun onResponse(call: Call<TeamsList>, response: Response<TeamsList>) {
                teams = response.body() ?: getMockTeamsList()
                view?.updateList()
            }

            override fun onFailure(call: Call<TeamsList>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onBindTeamAtPosition(holder: TeamsListAdapter.TeamCardHolder, position: Int) {
        holder.bindTeam(teams.list[position], navController)
    }

    override fun getTeamCount(): Int {
        return if (this::teams.isInitialized) teams.list.size else 0
    }
}