package sergeevvs.fc_mvp.squad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.data.TEAM
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.databinding.FragmentSquadBinding
import javax.inject.Inject

@AndroidEntryPoint
class SquadListFragmentImpl : Fragment(), SquadListFragment {

    @Inject lateinit var presenter: SquadListPresenter
    private lateinit var binding: FragmentSquadBinding

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
            R.layout.fragment_squad,
            container,
            false
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = SquadAdapter(presenter)

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

    override fun updateList() {
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}