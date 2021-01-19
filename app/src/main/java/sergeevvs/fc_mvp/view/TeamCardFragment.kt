package sergeevvs.fc_mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.databinding.FragmentCardBinding
import sergeevvs.fc_mvp.model.TeamCardModel
import sergeevvs.fc_mvp.presenter.TeamCardPresenter

class TeamCardFragment : Fragment(), MvpView {

    private lateinit var binding: FragmentCardBinding
    private val presenter = TeamCardPresenter(TeamCardModel())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_card,
            container,
            false
        )

        presenter.attachView(this)
        presenter.viewIsReady()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun getNavController(): NavController {
        return findNavController()
    }

    fun showTeam(team: Team?) {
        binding.includeCard.team = team
        binding.team = team
    }

    fun setOnPlayersButtonClickListener(listener: () -> Unit) {
        binding.playersButton.setOnClickListener { listener() }
    }
}