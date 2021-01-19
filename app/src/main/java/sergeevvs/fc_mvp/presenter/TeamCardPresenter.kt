package sergeevvs.fc_mvp.presenter

import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.SerializableSquad
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.data.getMockTeam
import sergeevvs.fc_mvp.model.TeamCardModel
import sergeevvs.fc_mvp.view.TeamCardFragment

class TeamCardPresenter(private val model: TeamCardModel) : BasePresenter<TeamCardFragment>() {

    private lateinit var team: Team

    override fun viewIsReady() {
        if (!this::team.isInitialized) loadTeam()
        else sendTeam()
    }

    private fun loadTeam() {
        view?.arguments?.getInt(ID)?.let {
            model.getTeam(it).enqueue(object : Callback<Team> {
                override fun onResponse(call: Call<Team>, response: Response<Team>) {
                    team = response.body() ?: getMockTeam()
                    sendTeam()
                }

                override fun onFailure(call: Call<Team>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }

    private fun sendTeam() {
        view?.showTeam(team)
        view?.setOnPlayersButtonClickListener {
            val bundle = Bundle()
            bundle.putSerializable("squad", SerializableSquad(team.squad))
            view?.getNavController()?.navigate(
                R.id.action_cardFragment_to_squadListFragment,
                bundle
            )
        }
    }
}