package sergeevvs.fc_mvp.teamcard

import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestBuilder
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.data.TEAM
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.databinding.FragmentCardBinding
import sergeevvs.fc_mvp.repository.MainRepositoryImpl

class TeamCardFragmentImpl : Fragment(), TeamCardFragment {

    private lateinit var binding: FragmentCardBinding
    private val presenter: TeamCardPresenter = TeamCardPresenterImpl(MainRepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.getSerializable(TEAM)?.let { presenter.attachTeam(it as Team) }
    }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(TEAM, presenter.getTeam())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showTeam(team: Team, requestBuilder: RequestBuilder<PictureDrawable>) {
        binding.includeCard.team = team
        binding.team = team
        binding.playersButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(TEAM, team)
            findNavController().navigate(
                R.id.action_cardFragment_to_squadListFragment,
                bundle
            )
        }
        requestBuilder.load(team.crestUrl).into(binding.includeCard.cardImage)
    }
}