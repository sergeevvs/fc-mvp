package sergeevvs.fc_mvp.teamcard

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.getMockTeam
import sergeevvs.fc_mvp.main.BasePresenter
import sergeevvs.fc_mvp.repository.MainRepository

class TeamCardPresenterImpl(private val model: MainRepository) : BasePresenter<TeamCardFragment>(),
    TeamCardPresenter {

    private var team = getMockTeam()

    override fun getTeam() = team

    override fun attachTeam(team: Team) {
        this.team = team
    }

    override fun viewIsReady() {
        if (team.id == 0) loadTeam()
        else view?.showTeam(team)
    }

    private fun loadTeam() {
        view?.getArguments()?.getInt(ID)?.let {
            model.getTeam(it).enqueue(object : Callback<Team> {
                override fun onResponse(call: Call<Team>, response: Response<Team>) {
                    response.body()?.let { it1 -> team = it1 }
                    view?.showTeam(team)
                }

                override fun onFailure(call: Call<Team>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}